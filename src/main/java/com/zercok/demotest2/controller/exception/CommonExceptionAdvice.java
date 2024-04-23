package com.zercok.demotest2.controller.exception;


import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

    @ResponseBody   //데이터 그 자체를 전달한다. (약간 json 같은 느낌이지 않을까?)
    @ExceptionHandler(NumberFormatException.class)
    public String exceptionNumber(NumberFormatException e) {
        log.error("---------------------------------------");
        log.error(e.getMessage());
        return "NUMBER FORMAT EXCEPTION";
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exceptCommmon(Exception e) {

        log.error(e.getMessage());
        StringBuffer buffer = new StringBuffer("<ul>");
        buffer.append("<li>"+e.getMessage()+"</li>");
        Arrays.stream(e.getStackTrace()).forEach(stackTraceElement -> {
            buffer.append("<li>"+stackTraceElement.toString()+"</li>");
        });
        buffer.append("</ul>");
        return buffer.toString();
    }

    @ExceptionHandler(NoHandlerFoundException.class)  //내가 작성하려고 하는 핸들러중에 없는 애들 -> 못찾는 핸들어 exception에 대하여
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound() {

        return "customer404";
    }


}
