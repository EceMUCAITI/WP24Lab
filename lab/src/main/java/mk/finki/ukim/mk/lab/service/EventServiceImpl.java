package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.InMemoryEventRepository;
import mk.finki.ukim.mk.lab.repository.InMemoryLocationRepository;
import mk.finki.ukim.mk.lab.repository.jpa.EventRepository;
import mk.finki.ukim.mk.lab.repository.jpa.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    public EventServiceImpl(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
        return eventRepository.searchEvents(text);
    }
    @Override
    public Optional<Event> findById(long id){
        return eventRepository.findById(id);

    }

    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Optional<Event> save(String name, String description, double popularityScore, String locationId) {
        Location location = locationRepository.findById(locationId).orElse(null);
        if (location != null) {
            Event event = new Event(name, description, popularityScore, location);
            return Optional.of(eventRepository.save(event));
        }
        return Optional.empty();
    }

    @Override
    public void update(Long id, String name, String description, double popularityScore, Location location) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.setName(name);
        event.setDescription(description);
        event.setPopularityScore(popularityScore);
        event.setLocation(location);

        eventRepository.save(event);
    }




}
