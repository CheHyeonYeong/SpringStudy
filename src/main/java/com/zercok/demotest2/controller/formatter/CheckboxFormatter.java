package com.zercok.demotest2.controller.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CheckboxFormatter implements Formatter<Boolean> {
    //checked가 on으로 들어오는데 이걸 bool 타입으로 바궈줘!
    @Override
    public Boolean parse(String text, Locale locale) throws ParseException {
        if(text ==null || text.equals("")){
            return false;
        }
        return text.equals("on");
    }

    @Override
    public String print(Boolean object, Locale locale) {
        return object.toString();
    }
}
