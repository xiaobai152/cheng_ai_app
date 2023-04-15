package com.cheng.utils;


import com.baidu.aip.ocr.AipOcr;

/**
 * <h3>SpringBaiduAI</h3>
 *
 * @author cheng
 * @description <p>百度api</p>
 * @date 2023-04-13 23:32
 */
public class AipOcrSimple {

    public static AipOcr getAipOcr() {
        return new AipOcr(App.APP_ID,App.APP_KEY,App.APP_SECRET_ID);
    }
}
