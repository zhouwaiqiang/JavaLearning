package com.springinaction.springidol;

/**
 * Created by 强 on 2018/12/13.
 */
public class Piano implements Instrument {
    public Piano() {
    }

    @Override
    public void play() {
        System.out.println("PLINK  PLINK PLINK");
    }
}
