package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.Event;
import com.devsuperior.demo.repositories.CityRepository;
import com.devsuperior.demo.repositories.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private CityRepository cityRepository;

    public EventDTO updateEvent(Long id, EventDTO event) {
        if (!eventRepository.existsById(id)) throw new EntityNotFoundException("Event not found");
        Event entity = eventRepository.getReferenceById(id);
        updateProperties(event, entity);
        entity = eventRepository.save(entity);
        return new EventDTO(entity);
    }

    private void updateProperties(EventDTO source, Event target) {
        target.setName(source.getName());
        target.setDate(source.getDate());
        target.setUrl(source.getUrl());
        target.setCity(cityRepository.findById(source.getCityId()).get());
    }

}
