package com.chuyang.chuyangapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.chuyang.chuyangapiclientsdk.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import static com.chuyang.chuyangapiclientsdk.utils.SignUtils.getSign;

/**
 * @author ChuYang
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChuYangapiClient {

    private String accessKey;
    private String secretKey;

    public String getNameByGet(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.get("http://localhost:8123/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    public String getNameByPost(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.post("http://localhost:8123/api/name/", paramMap);
        System.out.println(result);
        return result;
    }


    public Map<String, String> getHeaderMap(String body) {
        Map<String, String> getHeaderMap = new HashMap<>();
        getHeaderMap.put("accessKey", accessKey);
        //getHeaderMap.put("secretKey", secretKey);
        getHeaderMap.put("nonce", RandomUtil.randomNumbers(4));
        getHeaderMap.put("body",body);
        getHeaderMap.put("timestamp",String.valueOf(System.currentTimeMillis() / 1000));
        getHeaderMap.put("sign",getSign(body,secretKey));
        return getHeaderMap;
    }


    public String getUsernameByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post("http://localhost:8123/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        int result = httpResponse.getStatus();
        System.out.println(result);
        String result2 = httpResponse.body();
        System.out.println(result2);
        return result2;
    }
}
