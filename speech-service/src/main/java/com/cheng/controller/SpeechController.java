package com.cheng.controller;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.cheng.utils.AipSpeechSimple;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

/**
 * <h3>SpringBaiduAI</h3>
 *
 * @author cheng
 * @description <p>语音技术控制器</p>
 * @date 2023-04-14 20:20
 */

@CrossOrigin
@RestController
public class SpeechController {

    @RequestMapping("speech")
    public String speech(String text, String action, Integer per, Integer spd, Integer pit) {
        AipSpeech aipSpeech = AipSpeechSimple.getAipSpeech();
        HashMap<String, Object> hashMap = new HashMap<>();
        Base64 base64 = new Base64();
        if (action.equals("synthesis")) {
            hashMap.put("per", per);
            hashMap.put("spd", spd);
            hashMap.put("pit", pit);
            TtsResponse synthesis = aipSpeech.synthesis(text, "zh", 1, hashMap);
            return base64.encodeAsString(synthesis.getData());
        }
        return null;
    }

    @PostMapping("listen")
    public String listen(MultipartFile file) throws IOException {
        AipSpeech aipSpeech = AipSpeechSimple.getAipSpeech();
        JSONObject asr = aipSpeech.asr(file.getBytes(), "pcm", 16000, null);
        return asr.toString();


    }
}
