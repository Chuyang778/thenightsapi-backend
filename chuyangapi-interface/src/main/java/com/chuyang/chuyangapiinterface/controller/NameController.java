package com.chuyang.chuyangapiinterface.controller;

import cn.hutool.http.HttpRequest;
import com.chuyang.chuyangapiclientsdk.model.User;
import com.chuyang.chuyangapiclientsdk.utils.SignUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @author ChuYang
 * @version 1.0
 */
@RestController
@RequestMapping("/name")
@Slf4j
public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name) {
        return "GET 你的名字是" + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        return "PoST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest httpServletRequest) {
        String accessKey = httpServletRequest.getHeader("accessKey");
        String nonce = httpServletRequest.getHeader("nonce");
        String timestamp = httpServletRequest.getHeader("timestamp");
        String sign = httpServletRequest.getHeader("sign");
        String body = httpServletRequest.getHeader("body");
        if (!accessKey.equals("asdadrf")) {
            throw new RuntimeException("无权限");
        }
        if (Long.parseLong(nonce) > 10000) {
            throw new RuntimeException("无权限");
        }
        if (System.currentTimeMillis() / 1000 - Long.parseLong(timestamp) > 300) {
            throw new RuntimeException("无权限");
        }
        String serversign = SignUtils.getSign(body, "qewqwerq");
        if(!sign.equals(serversign)){
            throw new RuntimeException("无权限!");
        }

        return "POST 用户名字是" + user.getName();
    }

}
