package mk.finki.ukim.mk.lab.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity

@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    String name;
    String description;
    double popularityScore;
    @ManyToOne
    private Location location;

    public Event(String name, String description, double popularityScore, Location location) {
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.id = (long) (Math.random() * 1000000);
        this.location=location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPopularityScore(double popularityScore) {
        this.popularityScore = popularityScore;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public Location getLocation() { return location ;}

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPopularityScore(){
        return popularityScore;
    }

}
