package com.springinaction.springidol;

/**
 * Created by 强 on 2018/12/11.
 */
public class Sonnet29 implements Poem {
    private static String[] LINES = {
            "I miss you",
            "I miss you",
            "随风奔跑自由是方向",
            "追逐雷和闪电的力量",
            "把浩瀚的海洋装进我的胸膛",
    };

    public Sonnet29() {}

    @Override
    public void recite() {
        for (int i = 0; i < LINES.length; i++) {
            System.out.println(LINES[i]);
        }
    }
}
