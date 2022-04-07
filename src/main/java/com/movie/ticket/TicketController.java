package com.movie.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TicketController {
    @Autowired
    TicketRepo ticketRepo;

    @GetMapping("/ticket")
    public String showSignUpForm(Ticket ticket) {
        return "ticket";
    }

    @PostMapping("/addticket")
    public String addUser(Ticket ticket, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "ticket";
        }

        ticketRepo.save(ticket);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String showUserList(Model model) {
        model.addAttribute("tickets", ticketRepo.findAll());
        return "list";
    }
}
