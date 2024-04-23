package com.zercok.demotest2.mapper;

import com.zercok.demotest2.domain.TodoVO;
import com.zercok.demotest2.dto.PageRequestDTO;

import java.util.List;

//todo Mybatis를 위한 인터페이스
public interface TodoMapper { //퍼시스턴트부터 작업 필요!!
    String getTime();
    void insert(TodoVO todoVO);
    List<TodoVO> selectAll();
    //조회 기능
    TodoVO selectOne(Long tno);
    void update(TodoVO todoVO);
    void delete(Long tno);
    //페이징 처리를 위한 목록보기
    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);
    //전체 게시물 개수 알아오기
    int getCount(PageRequestDTO pageRequestDTO);
}
