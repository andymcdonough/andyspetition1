package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PetitionController {

    private List<Petition> petitions = new ArrayList<>();

    @GetMapping("/petitions")
    public String viewPetitions(Model model) {
        model.addAttribute("petitions", petitions);
        return "view_petitions";
    }

    @GetMapping("/petitions/create")
    public String createPetitionForm(Model model) {
        model.addAttribute("petition", new Petition());
        return "create_petition";
    }

    @PostMapping("/petitions/create")
    public String createPetition(@ModelAttribute Petition petition) {
        petition.setId(Petition.getIdCounter());
        Petition.setIdCounter(Petition.getIdCounter() + 1);
        petition.setSignatures(new ArrayList<>());
        petitions.add(petition);
        return "redirect:/petitions";
    }

    @GetMapping("/petitions/search")
    public String searchPetitionForm() {
        return "search_petition";
    }

    @PostMapping("/petitions/search")
    public String searchPetition(@RequestParam String keyword, Model model) {
        List<Petition> searchResults = petitions.stream()
                .filter(p -> p.getTitle().contains(keyword) || p.getContent().contains(keyword))
                .collect(Collectors.toList());
        model.addAttribute("searchResults", searchResults);
        return "search_result";
    }

    @GetMapping("/petitions/{id}")
    public String viewPetition(@PathVariable int id, Model model) {
        Petition petition = petitions.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if (petition != null) {
            model.addAttribute("petition", petition);
            model.addAttribute("signature", new Signature());
            return "view_petition";
        } else {
            return "redirect:/petitions";
        }
    }

    @PostMapping("/petitions/{id}/sign")
    public String signPetition(@PathVariable int id, @ModelAttribute Signature signature) {
        Petition petition = petitions.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if (petition != null) {
            petition.getSignatures().add(signature);
        }
        return "redirect:/petitions";
    }
}
