package com.lyahov.stepa.MyTodoIstBack.web.api.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.lyahov.stepa.MyTodoIstBack.web.ApiConstantUtil.AUTH;

@Controller
@RequiredArgsConstructor
@RequestMapping(AUTH)
public class AuthController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/success")
    public String getSuccessPage() {
        return "success";
    }
}
