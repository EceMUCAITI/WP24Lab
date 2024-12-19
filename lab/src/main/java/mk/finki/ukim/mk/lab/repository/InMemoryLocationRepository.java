package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository

public class InMemoryLocationRepository {
    public List<Location> LocationRepository= new ArrayList<>();

    public List<Location> findAll(){
        return DataHolder.locations;
    }

    public void deleteById(String locationId){
   //todo
    }


    public Optional<Location> findById(String locationId) {
            return DataHolder.locations.stream().filter(location -> location.getId().equals(locationId)).findFirst();
        }
    }

