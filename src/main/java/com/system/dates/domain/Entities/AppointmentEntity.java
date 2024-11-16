package com.system.dates.domain.Entities;

import com.system.dates.domain.utils.DoctorStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;
    private LocalDateTime hour;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private UserEntity doctor;

    @ManyToOne
    @JoinColumn(name= "patient_id")
    private UserEntity patient;

    @ManyToOne
    @JoinColumn(name = "DoctorStatus")
    private DoctorStatus doctorStatus;

}
