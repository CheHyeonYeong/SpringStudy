package com.zercok.demotest2.controller;

import com.zercok.demotest2.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {
    @GetMapping("/hello")
    public void hello() {
        log.info("hello");
    }

    //RequestMapping에서 파생된 어노테이션 : GetMapping, PostMapping
    //1. 기본 자료형 데이터 자동 수집
    @GetMapping("/ex1")
    public void ex1(String name,int age) {
        log.info("ex1");
        log.info("name : "+name);
        log.info("age : "+age);
    }

    //2.    @RequestParam() -> 파라미터에 있는 값을 받아 처리하는 어노테이션
    //name => 매개변수 이름, defaultvalue=기본값 설정, 해당 name으로 들어오는 것이 없을 경우 설정값
    @GetMapping("/ex2")
    public void ex2(@RequestParam(name = "name", defaultValue = "AAA")String name, @RequestParam(name = "age", defaultValue = "20")int age) {
        log.info("ex2");
        log.info("name : "+name);
        log.info("age : "+age);
    }

    //3. Formatter 를 이용한 파라미터 처리
    //http는 문자열 데이터를 전달하기 때문에 컨트롤러는 문자열을 기준으로 특정 클래스 객체로 처리하는
    //작업을 진행하게 된다, 이때 개발에서 가장 문제되는 타입이 날짜 관련 타입
    //브라우저에서 2024-04-19 와 같은 문자열을 받아서 Date,LocalDate나 LocalDateTime으로
    //변환하는 작업은 많이 필요하나, 이에 대한 파라미터 수집은 에러 발생
    //이 때 사용하는 것이 Formater

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        //03:06:38  WARN [org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver] Resolved
        // [org.springframework.web.method.annotation.MethodArgumentTypeMismatchException:
        // Failed to convert value of type 'java.lang.String' to required type 'java.time.LocalDate';
        // nested exception is org.springframework.core.convert.ConversionFailedException:
        // Failed to convert from type [java.lang.String] to type [java.time.LocalDate] for value
        // [2024-04-19]; nested exception is java.lang.IllegalArgumentException: Parse attempt failed for value [2024-04-19]]
        log.info("ex3");
        log.info("dueDate : "+dueDate);
    }

    //4. 객체 자료형 파라미터 수집 : dto => web에서 data를 전달하기 위함-> todoController

    //5. model 객체를 이용한 데이터 처리
    @GetMapping("ex4")
    public void ex4(Model model) {
        log.info("ex4");
        model.addAttribute("message", "HelloWorld1!");
    }

    //6. java bean과 @ModelAttribute의 사용, 그냥 모델에 담아서 전달해준다!
//    @GetMapping("ex4_1")
//    public void ex4_1(TodoDTO todoDTO, Model model) {
//        log.info("ex4_1");
//        log.info("todoDTO : "+todoDTO);
//    }
    @GetMapping("ex4_1")
    public void ex4_1(@ModelAttribute("dto") TodoDTO todoDTO, Model model) {
        log.info("ex4_1");
        log.info("todoDTO : "+todoDTO);
    }

    //7. RedirectAttributes와 리다이렉션
    //post 방식으로 어떤 처리를 하고, Redirect로 Get 방식으로 특정 페이지로 이동하는 패턴 (PRG 패턴)
    //RedirectAttributes 타입을 제공
    //Model과 마찬가지로 파라미터를 추가해 주기만한다면 자동으로 생성하는 방식으로 개발 할 수 있다.
    // - AddAttribute(key,value) : 리다이렉트 할 때 쿼리 스트링이 되는 값을 지정
    // - AddFlashAttribute(key,value) : 일회용으로만 데이터를 전달하고 삭제되는 값을 지정할 때

    @GetMapping("/ex5")
    public  String ex5(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("name", "abc");
        redirectAttributes.addFlashAttribute("result", "success");
        return "redirect:/ex6";
    }

    @GetMapping("/ex6")
    public void ex6() {

    }


    @GetMapping("/ex7")
    public void ex7(String p1, int p2) {
        log.info("p1 :"+p1);
        log.info("p2 :"+ p2);

    }

}