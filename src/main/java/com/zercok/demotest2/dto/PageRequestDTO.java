package com.zercok.demotest2.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
    //페이지 처리를 위해서 페이지 번호화 한 페이지 당 보여줄 데이터의 추가
    @Builder.Default //default 값으로 썼다
    @Min(value=1)
    @Positive
    private int page =1;

    @Builder.Default //default 값으로 썼다
    @Min(value=10)
    @Max(value = 100)
    @Positive
    private int size = 10;

    //맨 끝 페이지로 넣어감
    public int getSkip(){
        return (page-1)*size;
    }



}
