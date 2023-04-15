package com.cheng.controller;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.imageprocess.AipImageProcess;
import com.baidu.aip.ocr.AipOcr;
import com.cheng.utils.AipClassifySimple;
import com.cheng.utils.AipImageSimple;
import com.cheng.utils.AipOcrSimple;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

/**
 * <h3>SpringBaiduAI</h3>
 *
 * @author cheng
 * @description <p>文字识别控制器</p>
 * @date 2023-04-14 09:31
 */

@CrossOrigin
@RestController
public class OcrController {


    private final static String[] option = {"cartoon","pencil","color_pencil","warm","wave","lavender","mononoke","scream","gothic"};

    @PostMapping("text")
    public String text(MultipartFile file, @RequestParam(name = "action") String action) throws IOException {
        AipOcr aipOcr = AipOcrSimple.getAipOcr();
        HashMap<String,String> hashMap = new HashMap<>();
        if (action.equals("card")) {
            JSONObject front = aipOcr.idcard(file.getBytes(), "front", hashMap);
            return front.toString();
        } else if (action.equals("detect")) {
            hashMap.put("language_type","CHN_ENG");
            hashMap.put("detect_direction","true");
            hashMap.put("detect_language","true");
            hashMap.put("probability","true");
            JSONObject jsonObject = aipOcr.basicGeneral(file.getBytes(), hashMap);
            return jsonObject.toString();
        }
        return null;
    }

    @PostMapping("imageProcess")
    public String image(MultipartFile file, @RequestParam(name = "action") String action) throws IOException {
        AipImageProcess aipImage = AipImageSimple.getAipImage();
        switch (action) {
            case "self": {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("type", "anime");
                JSONObject jsonObject = aipImage.selfieAnime(file.getBytes(), hashMap);
                return jsonObject.toString();
            }
            case "black": {
                JSONObject jsonObject = aipImage.colourize(file.getBytes(), new HashMap<>());
                return jsonObject.toString();
            }
            case "style": {
                HashMap<String, String> hashMap = new HashMap<>();
                //随机一种风格
                hashMap.put("option", option[new Random().nextInt(option.length)]);
                JSONObject jsonObject = aipImage.styleTrans(file.getBytes(), hashMap);
                return jsonObject.toString();
            }
        }
        return null;
    }

    @PostMapping("detect")
    public String detect(MultipartFile file, @RequestParam(name = "action") String action) throws IOException {
        AipImageClassify aipClassify = AipClassifySimple.getAipClassify();
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("baike_num","1");
        if (action.equals("other")){
            JSONObject jsonObject = aipClassify.advancedGeneral(file.getBytes(), hashMap);
            return jsonObject.toString();
        } else if (action.equals("animal")) {
            JSONObject jsonObject = aipClassify.animalDetect(file.getBytes(), hashMap);
            return jsonObject.toString();
        }
        return null;
    }
}
