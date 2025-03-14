package com.cms.mapper.book;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRequest {
    public Long bookId;
    public Long scholarId;
    public LocalDateTime placedOn;
}
