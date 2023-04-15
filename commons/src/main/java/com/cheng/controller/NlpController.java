package com.cheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <h3>SpringBaiduAI</h3>
 *
 * @author cheng
 * @description <p>自然语音控制器</p>
 * @date 2023-04-14 16:15
 */

@Controller
@RequestMapping("nlp")
public class NlpController {

    @RequestMapping("/sentimentClassify")
    public String sentimentClassify(){
        return "nlp/sentimentClassify";
    }

    @RequestMapping("/address")
    public String address(){
        return "nlp/address";
    }
}
