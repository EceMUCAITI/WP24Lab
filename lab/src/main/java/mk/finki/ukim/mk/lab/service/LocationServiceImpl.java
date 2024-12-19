package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.jpa.LocationRepository;

import mk.finki.ukim.mk.lab.repository.InMemoryLocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService{

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> findAll(){
        return locationRepository.findAll();
    }

    @Override
    public void deleteById(String locationId) {
        locationRepository.deleteById(locationId);
    }

    @Override
    public Optional<Location> findById(String id) {
        return locationRepository.findById(id);
    }
}
