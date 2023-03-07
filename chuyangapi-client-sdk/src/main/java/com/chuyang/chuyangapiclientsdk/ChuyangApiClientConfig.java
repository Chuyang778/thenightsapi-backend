package com.chuyang.chuyangapiclientsdk;

import com.chuyang.chuyangapiclientsdk.client.ChuYangapiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ChuYang
 * @version 1.0
 */

@Configuration
@ConfigurationProperties("chuyangapi.client")
@Data
@ComponentScan
public class ChuyangApiClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public ChuYangapiClient chuYangapiClient(){
        return new ChuYangapiClient(accessKey,secretKey);
    }
}
