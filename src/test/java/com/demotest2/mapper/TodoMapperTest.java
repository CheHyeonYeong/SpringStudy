package com.demotest2.mapper;

import com.zercok.demotest2.domain.TodoVO;
import com.zercok.demotest2.mapper.TodoMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTest {
    @Autowired(required = false) //요구 사항을 반드시 요구하지 않아도 된다.
    private TodoMapper todoMapper; //직접 참조해야 한다

    @Test
    public void testGetTime() {
        log.info("timeMapper : "+todoMapper.getTime()); //인터페이스를 만들어서 직접 주입했다
    }

    @Test
    public void testInsert() {
        TodoVO vo = TodoVO.builder()
                .title("test")
                .dueDate(LocalDate.of(2024,04,22))
                .writer("user00")
                .build();
        todoMapper.insert(vo);
    }
    @Test
    public void testSelectAll(){
        List<TodoVO> list = todoMapper.selectAll();
//        for(TodoVO vo : list){
//            log.info(vo.toString());
//        }
        list.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectOne(){
        TodoVO vo = todoMapper.selectOne(1L);
        log.info(vo);
    }
}
