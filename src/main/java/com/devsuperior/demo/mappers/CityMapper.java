package com.devsuperior.demo.mappers;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.entities.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityDTO entityToDTO(City city);
    City dtoToEntity(CityDTO cityDTO);
}
