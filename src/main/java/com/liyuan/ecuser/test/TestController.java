package com.liyuan.ecuser.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by weiyuan on 2019/4/7/007.
 */
@RestController
public class TestController {
    @Value("${server.port}")
    String getPort;
    @Autowired
    private DiscoveryClient client;
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/testclient")
    public String testclient() {
        String tr = restTemplate.getForObject("http://ecsyslogin/tet", String.class);
        System.out.println(tr);
        return "你好";
    }
    @RequestMapping("tet")
    public  String tet() {
        return "11";
    }

    @GetMapping("/testzuul")
    public String testzuul() {
        System.out.println("host:" + getPort+ "   -----port:" );
        return " ------      host:" +getPort;
    }


}
