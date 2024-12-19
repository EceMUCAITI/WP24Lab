package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.service.EventServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Controller
@RequestMapping("/EventBooking")
public class EventBookingController {
    EventServiceImpl eventService;
    SpringTemplateEngine templateEngine;

    public EventBookingController(EventServiceImpl eventService, SpringTemplateEngine templateEngine) {
        this.eventService = eventService;
        this.templateEngine = templateEngine;
    }

    @GetMapping
    public String getEventBookingPage(@RequestParam(required = false) String error, Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("events", this.eventService.listAll());
        return "bookingConfirmation";
    }
}
