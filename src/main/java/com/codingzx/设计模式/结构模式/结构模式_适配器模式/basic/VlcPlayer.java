package com.codingzx.设计模式.结构模式.结构模式_适配器模式.basic;

/**
 * @author codingzx
 * @description
 * @date 2021/9/21 12:04
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
