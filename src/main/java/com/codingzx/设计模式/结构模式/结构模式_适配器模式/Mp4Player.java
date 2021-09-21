package com.codingzx.设计模式.结构模式.结构模式_适配器模式;

/**
 * @author codingzx
 * @description
 * @date 2021/9/21 12:05
 */
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}