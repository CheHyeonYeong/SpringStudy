package com.zercok.demotest2.service;

import com.zercok.demotest2.domain.TodoVO;
import com.zercok.demotest2.dto.TodoDTO;
import com.zercok.demotest2.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@Log4j2
@RequiredArgsConstructor    //생성자 주입하려고 했음!
public class TodoServiceImpl implements TodoService {
    //spring의 느슨한 결합을 위함
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper; //DTO를 VO, vo를 dto로 변환해줌
    
    @Override
    public void register(TodoDTO todoDTO) {
        log.info(modelMapper);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info(todoVO);
        todoMapper.insert(todoVO);
    }

}
