package com.springinaction.springidol;

/**
 * Created by 强 on 2018/12/10.
 */
public class Juggler implements Performer {
    private int beanBags = 3;
    public Juggler () {
    }

    public Juggler (int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public void perform() {
        System.out.println("JUGGLING" + beanBags + " BEANBAGS");
    }
}
