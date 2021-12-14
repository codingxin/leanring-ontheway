package com.codingzx.并发编程实战;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author codingzx
 * @description
 * @date 2021/12/14 21:28
 */
@Controller
@Slf4j
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

}
