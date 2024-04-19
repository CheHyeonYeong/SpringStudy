package com.zercok.demotest2.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

    @ToString
    @Service
    @RequiredArgsConstructor
    public class SampleService {
//      @Autowired 1
        @Qualifier("normal")
        private final SampleDAO sampleDAO;
        //2 final로 지정하고 @RequiredArgsConstructor생성자 주입이 일어남

//        @Autowired 3
//        public SampleDAO setSampleDAO(SampleDAO sampleDAO01) {
//            this sampleDAO = sampleDAO01;
//        }
    }
