package com.cheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <h3>SpringBaiduAI</h3>
 *
 * @author cheng
 * @description <p>人脸页面</p>
 * @date 2023-04-14 13:58
 */

@Controller
@RequestMapping("face")
public class FaceController {

    @RequestMapping("/detect")
    public String detect(){
        return "face/detect";
    }

    @RequestMapping("/face_match")
    public String match(){
        return "face/face_match";
    }

}
