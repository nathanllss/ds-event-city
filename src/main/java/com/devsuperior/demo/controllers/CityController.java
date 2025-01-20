package com.devsuperior.demo.controllers;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.mappers.CityMapper;
import com.devsuperior.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<CityDTO> insertCity(@RequestBody CityDTO cityDTO) {
        City entity = cityMapper.dtoToEntity(cityDTO);
        entity = cityService.saveCity(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(cityMapper.entityToDTO(entity));
    }
}
