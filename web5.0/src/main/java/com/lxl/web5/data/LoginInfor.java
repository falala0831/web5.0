package com.lxl.web5.data;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginInfor implements Serializable {
    private String username;

    private String password;

    private String message;

}
