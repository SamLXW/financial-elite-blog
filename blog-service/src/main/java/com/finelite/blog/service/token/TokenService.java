package com.finelite.blog.service.token;

import com.finelite.blog.entity.response.DataResponse;
import org.springframework.stereotype.Service;


public interface TokenService {

    boolean checkToken(String token);

    DataResponse<String> login(String username, String password);
}
