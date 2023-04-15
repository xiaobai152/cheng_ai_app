package com.cheng.utils;

import com.baidu.aip.nlp.AipNlp;

/**
 * <h3>SpringBaiduAI</h3>
 *
 * @author cheng
 * @description <p>语言技术api</p>
 * @date 2023-04-14 16:27
 */
public class AipNlpSimple {

    public static AipNlp getAipNlp(){
        return new AipNlp(App.APP_ID,App.APP_KEY,App.APP_SECRET_ID);
    }
}
