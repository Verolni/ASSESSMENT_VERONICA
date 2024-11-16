package com.system.dates.infrastructure.persistence;

import com.system.dates.domain.Entities.AppointmentEntity;
import com.system.dates.domain.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
Optional<AppointmentEntity> findByDoctorAndHour( UserEntity doctor, LocalDateTime hora);

List<AppointmentEntity> findByPatient (UserEntity patient);

    List<AppointmentEntity> findAllFromUrl(String appointmentRepositoryUrl);
}
