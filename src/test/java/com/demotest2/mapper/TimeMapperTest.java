package com.demotest2.mapper;

import com.zercok.demotest2.mapper.TimeMapper;
import com.zercok.demotest2.mapper.TimeMapper2;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")

public class TimeMapperTest {
    @Autowired(required = false) //요구 사항을 반드시 요구하지 않아도 된다.
    private TimeMapper timeMapper; //직접 참조해야 한다

    @Test
    public void testGetTime() {
        log.info(timeMapper.getTime()); //인터페이스를 만들어서 직접 주입했다
    }
    @Autowired(required = false) //요구 사항을 반드시 요구하지 않아도 된다.
    private TimeMapper2 timeMapper2; //직접 참조해야 한다

    @Test
    public void testGetNow() {
        log.info(timeMapper2.getNow()); //인터페이스를 만들어서 직접 주입했다
    }


}
