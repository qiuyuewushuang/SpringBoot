package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {

    private String username;
    private String password;
    private Date birthday;

}
