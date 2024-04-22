package com.zercok.demotest2.controller;

import com.sun.tools.javac.comp.Todo;
import com.zercok.demotest2.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Log4j2
@RequestMapping("/todo")
public class TodoController {
    @RequestMapping("/list")
    public void list() { // todo/list로 접근 시 동작
        log.info("list");

    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void registerGet() {
        log.info("get register");
    }

    //4.객체 자료 수집
    @PostMapping(value = "/register")
    public String registerPost(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("post register");
        if(bindingResult.hasErrors()) {
            log.info("has errors..........");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }
        log.info("todoDTO: " + todoDTO);
        return "redirect:/todo/list";
    }

}
