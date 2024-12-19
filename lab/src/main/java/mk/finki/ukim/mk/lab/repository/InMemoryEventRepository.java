package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Repository
public class InMemoryEventRepository {
    public List<Event> EventRepository= new ArrayList<>();

    public List<Event> findAll(){
        return DataHolder.events;
    };
    public List<Event> searchEvents(String text){
        return DataHolder.events.stream()
                .filter(c -> c.getName().contains(text) ||
                        c.getDescription().contains(text))
                .toList();
    };
    public Optional<Event> save(String name, String description, double popularityScore, Location location) {
        Event newEvent = new Event(name, description, popularityScore, location);
        DataHolder.events.removeIf(e -> Objects.equals(e.getName(), name));
        DataHolder.events.add(newEvent);
        return Optional.of(newEvent);
    }


    public void deleteById(Long id) {
        DataHolder.events.removeIf(event -> Objects.equals(event.getId(), id));

    }

    public Optional<Event> findById(long id) {
        return DataHolder.events.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public void save(Event event) {
        // Find the index of the event with the same ID in the list
        int index = -1;
        for (int i = 0; i < DataHolder.events.size(); i++) {
            if (DataHolder.events.get(i).getId().equals(event.getId())) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            // Update the existing event
            DataHolder.events.set(index, event);
        } else {
            // Add a new event if it doesn't exist
            DataHolder.events.add(event);
        }
    }
}
