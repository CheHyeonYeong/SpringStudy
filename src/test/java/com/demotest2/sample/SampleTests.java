package com.demotest2.sample;

import com.zercok.demotest2.sample.SampleService;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@Log4j2 //로그
@ExtendWith(SpringExtension.class) //스프링 동작
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTests {

    @Autowired//의존성 주입
    private SampleService sampleService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testService1() {
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }


    @Test
    public void testConnection() throws Exception {
        Connection connection = dataSource.getConnection();
        log.info(connection);
        Assertions.assertNotNull(connection); //null이면 fail로 들어간다.
        connection.close();
    }

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testSqlSessionFactory() throws Exception {
        log.info(sqlSessionFactory);
        Assertions.assertNotNull(sqlSessionFactory);
    }
}
