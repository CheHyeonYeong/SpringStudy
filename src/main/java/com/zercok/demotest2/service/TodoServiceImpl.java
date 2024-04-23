package com.zercok.demotest2.service;

import com.zercok.demotest2.domain.TodoVO;
import com.zercok.demotest2.dto.TodoDTO;
import com.zercok.demotest2.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<TodoDTO> getAll() {
        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList()); //stream을 collect 타입으로 바꿔짐 -> 지금은 타입이 list로 되어 있어서 list로 변경!

        return dtoList;
    }

    @Override
    public TodoDTO getOne(Long tno) {
        TodoVO vo = todoMapper.selectOne(tno);
        TodoDTO dto = modelMapper.map(vo, TodoDTO.class);

        return dto;
    }

}
