package com.cheng.utils;

import com.baidu.aip.speech.AipSpeech;

/**
 * <h3>SpringBaiduAI</h3>
 *
 * @author cheng
 * @description <p>语音技术api</p>
 * @date 2023-04-14 20:18
 */
public class AipSpeechSimple {

    public static AipSpeech getAipSpeech(){
        return new AipSpeech(App.APP_ID,App.APP_KEY,App.APP_SECRET_ID);
    }
}
