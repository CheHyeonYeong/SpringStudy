package com.zercok.demotest2.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {
    //todo dto의 목록과 전체 데이터의 수와 페이지 번호의 처리를 위한 데이터 처리
    private int page;
    private int size;
    private int total;
    //시작 페이지 번호
    private int start;
    private int end;
    //이전 페이지 존재 여부
    private boolean prev;
    //다음페이지 존재 여부
    private boolean next;

    private List<E> dtoList;

    @Builder(builderMethodName = "withAll") //생성자에 Lombok @Builder
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {

        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();
        this.total = total;
        this.dtoList = dtoList;

        //마지막 페이지 (realEnd)
        this.end = (int)(Math.ceil(this.page/10.0))*10 ; //10은 page 번호 개수
        this.start = this.end-9;

        int last = (int)(Math.ceil(total /(double) size));
        this.end = end > last ? last : end;

        this.prev = this.start>1;
        this.next = total > this.end * this.size;
    }
}
