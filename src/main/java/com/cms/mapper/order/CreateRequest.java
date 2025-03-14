package com.cms.mapper.order;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRequest {
    public Long bookId;
    public Long scholarId;
    public LocalDate placedOn;
}
