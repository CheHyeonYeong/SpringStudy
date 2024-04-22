package com.zercok.demotest2.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable //spring bean에 대한 설정하는 클래스를 명시한다.
public class ModelMapperConfig {

    @Bean //java code로 세팅 설정 -> root context.xml에서 작업해도 된다.
    public ModelMapper getMapper() { //model mapper가 application context에 등록을 해야지만 저장이 된다.
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true) 
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE) //private 접근 설정함
                .setMatchingStrategy(MatchingStrategies.STRICT); //이름과 해당 내용이 딱 맞아 떨어지면 매칭을 해주겠다 (타입과 이름이 같아야 한다) strict : 엄격한

        return modelMapper;
    }
}
