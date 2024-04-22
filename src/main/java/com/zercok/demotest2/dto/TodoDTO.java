package com.zercok.demotest2.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TodoDTO {
    private int tno;

    @NotEmpty
    private String title;
    @Future
    private LocalDate dueDate;

    private Boolean finished ;
    @NotEmpty
    private String writer;

}
