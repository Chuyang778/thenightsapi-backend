package com.chuyang.chuyangapiinterface;

import com.chuyang.chuyangapiclientsdk.client.ChuYangapiClient;
import com.chuyang.chuyangapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ChuyangapiInterfaceApplicationTests {

    @Resource
    private ChuYangapiClient chuYangapiClient;

    @Test
    void contextLoads() {
    }

    @Test
    public void testClient(){
        String flowerDance = chuYangapiClient.getNameByGet("FlowerDance");
        System.out.println("Your name is" + flowerDance);
        User user = new User();
        user.setName("sisi");
        String usernameByPost = chuYangapiClient.getUsernameByPost(user);
        System.out.println("Your username is " + usernameByPost);
    }

}
