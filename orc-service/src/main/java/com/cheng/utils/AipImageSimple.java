package com.cheng.utils;

import com.baidu.aip.imageprocess.AipImageProcess;

/**
 * <h3>SpringBaiduAI</h3>
 *
 * @author cheng
 * @description <p>图像增强</p>
 * @date 2023-04-14 09:56
 */
public class AipImageSimple {

    public static AipImageProcess getAipImage(){
        return new AipImageProcess(App.APP_ID,App.APP_KEY,App.APP_SECRET_ID);
    }
}
