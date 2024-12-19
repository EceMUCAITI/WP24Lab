package mk.finki.ukim.mk.lab.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Location {


    @Id
    private String id;

    private String name;
	private String address;
	private String capacity;
	private String description;
    @OneToMany
    private List<Event> events;

    public Location(String id, String name, String address, String capacity, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getDescription() {
        return description;
    }
}
