package com.zercok.demotest2.controller;

import com.sun.tools.javac.comp.Todo;
import com.zercok.demotest2.dto.PageRequestDTO;
import com.zercok.demotest2.dto.PageResponseDTO;
import com.zercok.demotest2.dto.TodoDTO;
import com.zercok.demotest2.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Log4j2
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void registerGet() {
        log.info("get register");
    }

    private final TodoService todoService;
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

        todoService.register(todoDTO);
        return "redirect:/todo/list";
    }
    @RequestMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO ,BindingResult bindingResult , Model model) {
        log.info(pageRequestDTO);
        //valid는 pageRequestDTO를 학인하기 위함
        if(bindingResult.hasErrors()) {
            log.info("has errors..........");
            model.addAttribute("errors", bindingResult.getAllErrors());
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO)); //forward 되면서 jsp로 전달된다
    }
    //한개의 투두 조회하기
    @GetMapping({"/read", "/modify"}) //경로 두 개를 묶음
    public void read(Long tno,PageRequestDTO pageRequestDTO, Model model) { //파라미터 값으로 tno를 받음, list에서 title에 작업을 해서 넣어줘야한다!
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);
        model.addAttribute("dto", todoDTO);
    }

    @PostMapping("/remove")
    public String remove(Long tno, RedirectAttributes redirectAttributes) {
        log.info("remove todo: " + tno);
        todoService.delete(tno);
        return "redirect:/todo/list";
    }
    @PostMapping("/modify")
    public String modify(TodoDTO todoDTO,BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("modify todo: " + todoDTO);
        todoService.update(todoDTO);
        if (bindingResult.hasErrors()){
            log.info("has errors..........");
            redirectAttributes.addAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno()); //get 파라미터로 넣음.
            return "redirect:/todo/modify";
        }
        return "redirect:/todo/list";
    }
}
