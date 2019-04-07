package com.springinaction.springidol;


/**
 * Created by 强 on 2018/12/11.
 * 注入Bean属性
 */
public class Instrumentalist implements Performer {
    public Instrumentalist () {
    }

    @Override
    public void perform() {
        System.out.print("Playing " + song + " : ");
        instrument.play();
    }

    private String song;
    public void setSong(String song) {
        //注入歌曲
        this.song = song;
    }

    public String getSong() {
        return this.song;
    }

    public String screamSong() {
        return this.song;
    }

    private Instrument instrument;
    public void setInstrument (Instrument instrument) {
        //注入乐器
        this.instrument = instrument;
    }
}
