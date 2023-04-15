package com.cheng.utils;

import com.baidu.aip.imageclassify.AipImageClassify;

/**
 * <h3>SpringBaiduAI</h3>
 *
 * @author cheng
 * @description <p>图像识别</p>
 * @date 2023-04-14 10:38
 */

public class AipClassifySimple {

    public static AipImageClassify getAipClassify(){
        return new AipImageClassify(App.APP_ID,App.APP_KEY,App.APP_SECRET_ID);
    }
}
