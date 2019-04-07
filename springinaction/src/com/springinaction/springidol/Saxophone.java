package com.springinaction.springidol;

/**
 * Created by 强 on 2018/12/13.
 */
public class Saxophone implements Instrument {
    public Saxophone() {}

    @Override
    public void play() {
        System.out.println("TOOT TOOT TOOT");
    }
}
