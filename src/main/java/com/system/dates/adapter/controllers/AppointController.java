package com.system.dates.adapter.controllers;

import com.system.dates.application.service.AppointmentService;
import com.system.dates.domain.Entities.AppointmentEntity;
import com.system.dates.exceptions.exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointment")
public class AppointController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentEntity appointmentEntity) {
        try {
            if (appointmentEntity.getDoctor() == null || appointmentEntity.getPatient() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Both the doctor and the patient are required");
            }
            AppointmentEntity newAppointment = appointmentService.saveAppointment(appointmentEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(newAppointment);
        } catch (exceptions.appointmentHourConflictoException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request error");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error");
        }
    }
}