package com.zercok.demotest2.dto;

import lombok.*;

import java.time.LocalDate;

@ToString
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TodoDTO {
    private int tno;
    private String title;
    private LocalDate dueDate;
    private Boolean finished ;
    private String writer;

}
