package com.cms.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ScholarEntity {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime updated = LocalDateTime.now();
    private String name;
    private Long mobile;
    @OneToMany(mappedBy = "scholarEntity", cascade = CascadeType.ALL)
    private List<OrderEntity> orderEntityList = new ArrayList<>();
    private Boolean defaulter = Boolean.FALSE;
}
