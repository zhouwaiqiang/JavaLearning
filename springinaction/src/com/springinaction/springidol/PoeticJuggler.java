package com.springinaction.springidol;

/**
 * Created by 强 on 2018/12/10.
 */
public class PoeticJuggler extends Juggler{
    private Poem poem;

    public PoeticJuggler (Poem poem) {
        super();
        this.poem = poem;
    }

    public PoeticJuggler (int beanBags, Poem poem) {
        super(beanBags);
        this.poem = poem;
    }

    public void perform() {
        super.perform();
        System.out.println("While reciting...");
        poem.recite();
    }
}
