package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events=new ArrayList<>();
    public static List<Location> locations=new ArrayList<>();

    //@PostConstruct
    public void init() {

        locations = new ArrayList<>();
        locations.add(new Location("1L", "City Hall", "123 Main St", "500", "The main city hall used for large events."));
        locations.add(new Location("2L", "Conference Center", "456 Park Ave", "300", "A popular location for conferences and seminars."));
        locations.add(new Location("3L", "The Grand Theater", "789 Broadway", "1000", "A historic theater with a large seating capacity."));
        locations.add(new Location("4L", "Outdoor Amphitheater", "101 Lake Rd", "750", "An open-air venue for concerts and performances."));
        locations.add(new Location("5L", "University Auditorium", "202 College Blvd", "200", "A small auditorium at the local university."));

        events = new ArrayList<>();
        events.add(new Event("concert", "music concert", 8.7, locations.get(0)));
        events.add(new Event("car exhibition", "old cars", 7.5, locations.get(0)));
        events.add(new Event("museum", "art gallery", 9.2, locations.get(1)));
        events.add(new Event("theater", "drama performance", 6.8, locations.get(1)));
        events.add(new Event("conference", "latest trends", 4.9, locations.get(2)));
        events.add(new Event("book fair", "meet the author", 7.3, locations.get(2)));
        events.add(new Event("food festival", "trying kitchens", 9.0, locations.get(3)));
        events.add(new Event("cinema", "indie film festival", 7.9, locations.get(3)));
        events.add(new Event("football match", "fundraising match", 2.7,locations.get(4)));
        events.add(new Event("science fair", "student projects", 8.4, locations.get(4)));


    }

}
