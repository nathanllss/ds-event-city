package com.devsuperior.demo.services;

import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.repositories.CityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Transactional(readOnly = true)
    public List<City> findAllCitiesSortedByName() {
        return cityRepository.findAll(Sort.by("name"));
    }

    @Transactional
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Transactional
    public void deleteCity(Long id) {
        if (!cityRepository.existsById(id)) throw new EntityNotFoundException("City not found");
        cityRepository.deleteById(id);
    }
}
