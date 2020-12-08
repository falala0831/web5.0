package com.lxl.web5.service;

import com.lxl.web5.data.LoginInfor;

public class Checklogin {
    public static boolean Check(LoginInfor infor) {
        if ("lxl".equals(infor.getUsername()) && "123456".equals(infor.getPassword()))
            return true;
        else
            return false;
    }
}
