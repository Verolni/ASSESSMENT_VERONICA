package com.system.dates.application.service;

import com.system.dates.domain.Entities.AppointmentEntity;
import com.system.dates.domain.utils.DoctorStatus;
import com.system.dates.infrastructure.persistence.AppointmentRepository;
import com.system.dates.infrastructure.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    public AppointmentEntity saveAppointment(AppointmentEntity appointmentEntity) throws ApplicationContextException {
        Optional<AppointmentEntity> existingAppointment = appointmentRepository.findByDoctorAndHour(
                appointmentEntity.getDoctor(),
                appointmentEntity.getHour()
        );

        if (existingAppointment.isPresent()) {
            throw new ApplicationContextException("The selected time slot is already occupied");
        }

        appointmentEntity.setDoctorStatus(DoctorStatus.AVAILABLE);


        return appointmentRepository.save(appointmentEntity);
    }


    @Value("${appoimentRepository.url}")
    private String appointmentRepositoryUrl;

    public List<AppointmentEntity> getAllAppointments() {
        return appointmentRepository.findAllFromUrl(appointmentRepositoryUrl);
    }
}






