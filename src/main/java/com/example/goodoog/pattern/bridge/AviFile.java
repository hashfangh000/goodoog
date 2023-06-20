package com.example.goodoog.pattern.bridge;

/**
 * avi视频文件 (具体实现化角色)
 */
public class AviFile implements VideoFile{
    public void decode(String filename) {
        System.out.println("avi视频文件：" + filename);
    }
}
