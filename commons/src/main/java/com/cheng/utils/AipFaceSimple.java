package com.cheng.utils;

import com.baidu.aip.face.AipFace;

/**
 * <h3>SpringBaiduAI</h3>
 *
 * @author cheng
 * @description <p>人脸技术</p>
 * @date 2023-04-14 14:09
 */
public class AipFaceSimple {

    public static AipFace getAipFace(){
        return new AipFace(App.APP_ID,App.APP_KEY,App.APP_SECRET_ID);
    }
}
