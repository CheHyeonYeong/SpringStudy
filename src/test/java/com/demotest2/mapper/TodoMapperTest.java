package com.demotest2.mapper;

import com.zercok.demotest2.domain.TodoVO;
import com.zercok.demotest2.dto.PageRequestDTO;
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
    @Test
    public void testDelete(){
        todoMapper.delete(1L);
        log.info(todoMapper.selectAll());
    }
    @Test
    public void testUpdate(){
        TodoVO vo = todoMapper.selectOne(2L);
        TodoVO todoVO = TodoVO.builder()
                    .tno(vo.getTno())
                    .title(vo.getTitle()+"modify")
                    .dueDate(vo.getDueDate())
                    .finished(!vo.isFinished()).build();
        log.info(vo);
        todoMapper.update(todoVO);
        log.info(todoMapper.selectOne(2L));
    }

    @Test
    public void testSelectList(){
        //1. PageRequestDTO를 먼저 만든다
        //2. todoMapper.selectList()를 테스트한 결과를 List<TodoVO>로 담기
        //3. 내용 출력하기
        PageRequestDTO dto = new PageRequestDTO();
        List<TodoVO> voList = todoMapper.selectList(dto);
        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testCount(){
        log.info(todoMapper.getCount(new PageRequestDTO()));
    }
}
