package com.example.goodoog.pattern.bridge;

/**
 * rmvb 视频文件
 */
public class RmvbFile implements VideoFile{

    public void decode(String filename) {
        System.out.println("rmvn视频文件：" + filename);
    }
}
