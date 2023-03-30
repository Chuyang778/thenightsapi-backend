package com.yupi.project.utils;

import cn.hutool.json.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author ChuYang
 * @version 1.0
 */
@Component
@Slf4j
public class BasicPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Environment env;

    public void sendMsg(String message){
        if(!StringUtils.isNotBlank(message)){
        }
    }

}
