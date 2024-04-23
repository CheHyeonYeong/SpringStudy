package com.zercok.demotest2.service;

import com.zercok.demotest2.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    //등록
    void  register(TodoDTO todoDTO);

    //목록 서비스
    List<TodoDTO> getAll();
    TodoDTO getOne(Long tno);
}
