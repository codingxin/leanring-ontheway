package com.codingzx.设计模式.结构模式.结构模式_适配器模式.basic2;

import com.codingzx.设计模式.结构模式.结构模式_适配器模式.basic.AdvancedMediaPlayer;
import com.codingzx.设计模式.结构模式.结构模式_适配器模式.basic.Mp4Player;
import com.codingzx.设计模式.结构模式.结构模式_适配器模式.basic.VlcPlayer;
import com.codingzx.设计模式.结构模式.结构模式_适配器模式.basic2.MediaPlayer;

/**
 * @author codingzx
 * @description
 *
 * 适配器 根据当前传入的type分别实例化
 *
 * @date 2021/9/21 12:05
 */
public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}