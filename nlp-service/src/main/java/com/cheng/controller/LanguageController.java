package com.cheng.controller;

import com.baidu.aip.nlp.AipNlp;
import com.cheng.utils.AipNlpSimple;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <h3>SpringBaiduAI</h3>
 *
 * @author cheng
 * @description <p>处理自然语言</p>
 * @date 2023-04-14 16:30
 */

@CrossOrigin
@RestController
public class LanguageController {

    @RequestMapping("nlp")
    public String nlp(String text,String action){
        AipNlp aipNlp = AipNlpSimple.getAipNlp();
        if (action.equals("sentiment")) {
            JSONObject jsonObject = aipNlp.sentimentClassify(text, new HashMap<>());
            return jsonObject.toString();
        } else if (action.equals("address")) {
            JSONObject address = aipNlp.address(text, new HashMap<>());
            return address.toString();
        }
        return null;
    }
}
