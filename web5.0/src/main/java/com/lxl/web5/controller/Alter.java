package com.lxl.web5.controller;

import com.lxl.web5.data.MessageInfor;
import com.lxl.web5.dao.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Alter {

    @Autowired
    private UserJpaRepository userJpaRepository;

    // 访问修改联系人 -- 因为修改联系人界面必然是 form 表单通过post提交的
    @PostMapping("/alter")
    public String showAlter(HttpServletRequest request, @ModelAttribute(name = "name") String name, Model model) {
        model.addAttribute("cont", userJpaRepository.findByContactname(name).get(0));
        return "alter";
    }

    // 直接访问修改联系人 --- 直接弹回去
    @GetMapping("/alter")
    public String redirectAlter() {
        return "redirect:/message";
    }

    // 直接访问判断联系人修改 直接重定向回去
    @GetMapping("/checkalter")
    public String redirectCheckAlter() {
        return "redirect:/message";
    }

    // 修改联系人信息 （因为名字不能修改 所以一定可以修改成功）
    @PostMapping("/checkalter")
    public String checkAlter(MessageInfor infor, HttpServletRequest request) {
        userJpaRepository.save(infor);
        return "redirect:/message";
    }

    // 删除联系人，不需要返回view 直接使用model 进行处理 如果是直接请求，必然是逻辑错误 直接跳转回去
    @GetMapping("/del")
    public String redirectDel() {
        return "redirect:/message";
    }

    // 删除联系人
    @PostMapping("/del")    // ModelAttribute 可以理解成随请求一起发过来的参数Param
    public String DeleteContact(@ModelAttribute(value = "name") String name, HttpServletRequest request) {
        userJpaRepository.deleteByContactname(name);
        return "redirect:/message";
    }

}
