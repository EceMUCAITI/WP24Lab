package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text);
    Optional<Event> findById(long id);
    void deleteById(Long id);
    Optional<Event> save(String name, String description, double popularityScore, String locationId);
    public void update(Long id, String name, String description, double popularityScore, Location location);


}
