package com.zercok.demotest2.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.Arrays;

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
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;

    private String link; //페이지와 사이즈 정보를 같이 넘기기 위한 변수


    //검색을 위함
    private String[] types; //검색 종류, 제목, 작성자
    private String keyword; // 검색값
    private boolean finished; //완료 여부 - 필터링
    private LocalDate from; //일시 - 필터링 사용
    private LocalDate to;
    //맨 끝 페이지로 넣어감
    public int getSkip(){
        return (page-1)*size;
    }

    public String getLink() {
        if(link == null){
            StringBuilder builder = new StringBuilder();
            builder.append("page="+this.page);
            builder.append("&size="+this.size);
            link = builder.toString();
        }
        return link;
    }
    public boolean checkType(String type){
        if (types==null || types.length==0 ){
            return false;
        }
        return Arrays.stream(types).anyMatch(type::equals);
    }
}
