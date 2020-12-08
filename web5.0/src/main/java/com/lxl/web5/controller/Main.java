package com.lxl.web5.controller;

import com.lxl.web5.data.MessageInfor;
import com.lxl.web5.data.Table;
import com.lxl.web5.dao.UserJpaRepository;
import com.lxl.web5.service.Typechange;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class Main {
    @Autowired
    private UserJpaRepository userJpaRepository;

    // 访问主界面 如果还没有登录 将被返回到登录界面
    @SneakyThrows
    @GetMapping("/message")
    public String showMain(HttpServletRequest request, Model model) {
        Object flag = request.getSession().getAttribute("login");
        if (null != flag) {
            List<MessageInfor> info = userJpaRepository.findAll();           // 获取持久层的数据
            Table t = new Table(Typechange.listToVector(info));  // 类型转换
            model.addAttribute("table", t);
            return "message";
        }
        else
            return "redirect:/login";
    }

}
