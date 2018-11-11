package com.finelite.blog.web.controller;

import com.finelite.blog.entity.response.DataResponse;
import com.finelite.blog.service.token.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    TokenService tokenService;
    @PostMapping("/login")
    public DataResponse<String> login(String userName, String password){

        LOGGER.info("---login : userName = " + userName + ", password = " + password);
        return    tokenService.login(userName,password);
    }

}
