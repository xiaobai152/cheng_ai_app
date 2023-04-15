package com.cheng.controller;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.cheng.utils.AipFaceSimple;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/**
 * <h3>SpringBaiduAI</h3>
 *
 * @author cheng
 * @description <p>处理人脸技术</p>
 * @date 2023-04-14 14:15
 */

@CrossOrigin
@RestController
public class FaceController {

    @PostMapping("face")
    public String face(MultipartFile file, @RequestParam String action) throws IOException {
        AipFace aipFace = AipFaceSimple.getAipFace();
        HashMap<String, Object> hashMap = new HashMap<>();
        Base64 encode = new Base64();
        if (action.equals("faceDetect")) {
            hashMap.put("max_face_num", "10");
            hashMap.put("liveness_control", "LOW");
            hashMap.put("face_field", "age,beauty,emotion,gender");
            String encodeAsString = encode.encodeAsString(file.getBytes());
            JSONObject base64 = aipFace.detect(encodeAsString, "BASE64", hashMap);
            System.out.println(base64);
            return base64.toString();
        }
        return null;
    }

    @PostMapping("face_match")
    public String face_match(@RequestParam MultipartFile file,@RequestParam MultipartFile file1, String action) throws IOException {
        AipFace aipFace = AipFaceSimple.getAipFace();
        Base64 base64 = new Base64();
        if (action.equals("match")) {
            ArrayList<MatchRequest> requests = new ArrayList<>();
            requests.add(new MatchRequest(base64.encodeAsString(file.getBytes()), "BASE64"));
            requests.add(new MatchRequest(base64.encodeAsString(file1.getBytes()), "BASE64"));
            JSONObject match = aipFace.match(requests);
            return match.toString();
        }
        return null;
    }
}
