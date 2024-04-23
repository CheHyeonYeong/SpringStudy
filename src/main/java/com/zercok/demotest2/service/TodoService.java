package com.zercok.demotest2.service;

import com.zercok.demotest2.dto.PageRequestDTO;
import com.zercok.demotest2.dto.PageResponseDTO;
import com.zercok.demotest2.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    //등록
    void  register(TodoDTO todoDTO);

    //목록 서비스
//    List<TodoDTO> getAll();
    //Paging 목록 서비스
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    TodoDTO getOne(Long tno);
    void delete(Long tno);
    void update(TodoDTO todoDTO);

}
