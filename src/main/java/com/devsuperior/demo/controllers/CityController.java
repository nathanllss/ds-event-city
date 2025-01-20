package com.devsuperior.demo.controllers;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.mappers.CityMapper;
import com.devsuperior.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    public CityService cityService;
    @Autowired
    private CityMapper cityMapper;

    @GetMapping
    public ResponseEntity<List<CityDTO>> getAllCitiesSortedByName() {
        List<CityDTO> result = cityService.findAllCitiesSortedByName()
                .stream().map(cityMapper::entityToDTO).toList();
        return ResponseEntity.ok(result);
    }
}
