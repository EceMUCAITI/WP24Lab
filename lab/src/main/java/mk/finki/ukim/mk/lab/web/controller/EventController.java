package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.service.LocationServiceImpl;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {


    private final EventService eventService;
    private final LocationServiceImpl locationService;

    public EventController(EventService eventService, LocationServiceImpl locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

    // GET: List all events
    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error, Model model) {
        List<Event> events = this.eventService.listAll();

        // Logging the fetched events
        System.out.println("Fetched Events: " + events);

        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("events", events);
        return "listEvents"; // Thymeleaf template name
    }

    // GET: Show add event form
    @GetMapping("/add-form")
    public String addEventPage(Model model) {
        List<Location> locationList = locationService.findAll();

        // Logging the available locations
        System.out.println("Available Locations: " + locationList);

        model.addAttribute("locations", locationList);
        return "add-event"; // Thymeleaf template name
    }

    // POST: Save or update event
    @PostMapping("/add")
    public String saveEvent(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam double popularityScore,
            @RequestParam String locationId) {

        try {
            Location location = locationService.findById(locationId)
                    .orElseThrow(() -> new RuntimeException("Location not found"));

            if (id != null) {
                // Editing an existing event
                eventService.update(id, name, description, popularityScore, location);
            } else {
                // Adding a new event
                eventService.save(name, description, popularityScore, locationId);
            }
            return "redirect:/events";
        } catch (Exception e) {
            System.err.println("Error saving event: " + e.getMessage());
            e.printStackTrace();
            return "redirect:/events?error=" + e.getMessage();
        }
    }

    // GET: Show edit event form
    @GetMapping("/edit-form/{id}")
    public String editEventPage(Model model, @PathVariable Long id) {
        try {
            Event event = eventService.findById(id)
                    .orElseThrow(() -> new RuntimeException("Event not found"));

            List<Location> locationList = locationService.findAll();
            model.addAttribute("locations", locationList);
            model.addAttribute("event", event);

            // Logging the event being edited
            System.out.println("Editing Event: " + event);

            return "add-event"; // Thymeleaf template name
        } catch (Exception e) {
            System.err.println("Error loading edit form: " + e.getMessage());
            return "redirect:/events?error=" + e.getMessage();
        }
    }

    // GET: Delete an event
    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        try {
            this.eventService.deleteById(id);
            System.out.println("Deleted Event ID: " + id);
            return "redirect:/events";
        } catch (Exception e) {
            System.err.println("Error deleting event: " + e.getMessage());
            return "redirect:/events?error=" + e.getMessage();
        }
    }

    // POST: Confirm booking
    @PostMapping("/submit")
    public String confirmBooking(
            @RequestParam Long selectedEventId,
            @RequestParam int ticketCount,
            Model model) {
        try {
            Event event = this.eventService.findById(selectedEventId)
                    .orElseThrow(() -> new RuntimeException("Event not found"));

            model.addAttribute("event", event);
            model.addAttribute("ticketCount", ticketCount);

            // Logging booking confirmation details
            System.out.println("Booking Confirmed for Event: " + event.getName() + ", Tickets: " + ticketCount);

            return "bookingConfirmation"; // Thymeleaf template name
        } catch (Exception e) {
            System.err.println("Error confirming booking: " + e.getMessage());
            return "redirect:/events?error=" + e.getMessage();
        }
    }
}
