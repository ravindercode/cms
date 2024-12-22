package com.cms.domain;

import com.cms.constant.PropertyConstant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime updated = LocalDateTime.now();
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "scholar_id")
    private ScholarEntity scholarEntity;
    private LocalDate postedOn = LocalDate.now();
    private LocalDate expectedOn = LocalDate.now().plusDays(PropertyConstant.returnPeriod);
    private LocalDate returnOn;

    public OrderEntity(BookEntity bookEntity, ScholarEntity scholarEntity) {
        this.bookEntity = bookEntity;
        this.scholarEntity = scholarEntity;
    }
}
