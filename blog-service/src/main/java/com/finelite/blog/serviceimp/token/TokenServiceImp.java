package com.finelite.blog.serviceimp.token;

import com.finelite.blog.dao.redis.BaseRedisDao;
import com.finelite.blog.entity.response.DataResponse;
import com.finelite.blog.service.token.TokenService;
import com.finelite.blog.utils.jwt.JavaWebToken;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TokenServiceImp implements TokenService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenServiceImp.class);


    @Autowired
    BaseRedisDao baseRedisDao;

    @Override
    public boolean checkToken(String token) {

        String toeknRe=(String)baseRedisDao.get(token);
        if(StringUtils.isNotBlank(toeknRe)&&token.equals(toeknRe)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public DataResponse<String> login(String username, String password) {
        DataResponse<String> response =new  DataResponse<String>();

        String pass = (String)baseRedisDao.get(username);

        if(StringUtils.isNotBlank(pass)&&pass.equals(password)){
            LOGGER.info("login success"+username);
            Map map=new HashMap<>();
            map.put("id",1);
            String token= JavaWebToken.createJavaWebToken(map);
            baseRedisDao.set(token,token);
            response.setValue(token);
        }else{
            LOGGER.info("login error");
        }
        return response;
    }
}
