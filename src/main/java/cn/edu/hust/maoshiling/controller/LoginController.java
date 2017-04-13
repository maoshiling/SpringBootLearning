package cn.edu.hust.maoshiling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 15352 on 2017/4/12.
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
