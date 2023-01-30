package de.memozone.todoappbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoModel {

    private Long id;

    private String text;

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate day;


    private Boolean reminder;



}
