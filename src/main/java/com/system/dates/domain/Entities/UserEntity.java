package com.system.dates.domain.Entities;

import com.system.dates.domain.utils.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class UserEntity {
    @Id
    private long id;
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;


}
