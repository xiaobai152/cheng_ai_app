package com.cheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <h3>SpringBaiduAI</h3>
 *
 * @author cheng
 * @description <p>跳转图像技术页面</p>
 * @date 2023-04-13 22:10
 */

@Controller
@RequestMapping("ocr")
public class ORC_Controller {

    @RequestMapping("/id_card")
    public String card(){
        return "ocr/id_card";
    }

    @RequestMapping("text_detect")
    public String detect(){
        return "ocr/text_detect";
    }

    @RequestMapping("/self")
    public String self(){
        return "ocr/self";
    }

    @RequestMapping("/black_white")
    public String black(){
        return "ocr/black_white";
    }

    @RequestMapping("/styleTrans")
    public String style(){
        return "ocr/styleTrans";
    }

    @RequestMapping("/body")
    public String body(){return "ocr/body";}

    @RequestMapping("/animal")
    public String animal(){
        return "ocr/animal";
    }
}
