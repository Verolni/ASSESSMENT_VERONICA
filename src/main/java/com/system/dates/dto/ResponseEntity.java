package com.system.dates.dto;

import com.system.dates.domain.Entities.AppointmentEntity;
import com.system.dates.exceptions.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@PostMapping
public org.springframework.http.ResponseEntity<?> CreateAppointment(@RequestBody AppointmentEntity appointmentEntity) {
    try {

        AppointmentEntity newAppointment = AppointmentService.guardarCita(appointmentEntity);

        return org.springframework.http.ResponseEntity.status(HttpStatus.CREATED).body(newAppointment);
    } catch (exceptions.appointmentHourConflictoException ex) {

        return org.springframework.http.ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe una cita para este doctor a esa hora.");
    } catch (IllegalArgumentException ex) {

        return org.springframework.http.ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos incorrectos: " + ex.getMessage());
    } catch (Exception ex) {

        return org.springframework.http.ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado: " + ex.getMessage());
    }
}