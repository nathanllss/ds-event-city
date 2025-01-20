package com.devsuperior.demo.mappers;

import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventDTO entityToDTO(Event event);

    Event dtoToEntity(EventDTO eventDTO);
}
