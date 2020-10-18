package com.lyahov.stepa.MyTodoIstBack.web.api.v1;

import com.lyahov.stepa.MyTodoIstBack.web.dto.AuthRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import static com.lyahov.stepa.MyTodoIstBack.web.ApiConstantUtil.AUTH;

@RestController
@RequestMapping(AUTH)
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> authentication(@RequestBody AuthRequestDto requestDto) {
         return null;
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler contextLogoutHandler = new SecurityContextLogoutHandler();
        contextLogoutHandler.logout(request, response, null);
    }

}
