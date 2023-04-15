package com.cheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <h3>SpringBaiduAI</h3>
 *
 * @author cheng
 * @description <p>语音处理控制器</p>
 * @date 2023-04-14 16:15
 */

@Controller
@RequestMapping("speech")
public class SpeechController {

    @RequestMapping("/synthesis")
    public String synthesis(){
        return "speech/synthesis";
    }

    @RequestMapping("/speech_detect")
    public String speech_detect(){
        return "speech/speech";
    }
}
