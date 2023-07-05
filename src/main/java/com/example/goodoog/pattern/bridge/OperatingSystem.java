package com.example.goodoog.pattern.bridge;


/**
 * 抽象的操作系统 抽象话角色
 */
public abstract class OperatingSystem {

    protected VideoFile videoFile;

    public OperatingSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public abstract void play (String fileName);
}
