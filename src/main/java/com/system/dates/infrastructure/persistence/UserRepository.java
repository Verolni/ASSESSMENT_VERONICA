package com.system.dates.infrastructure.persistence;

import com.system.dates.domain.Entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppointmentEntity, Long> {

}
