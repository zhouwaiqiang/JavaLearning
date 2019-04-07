package com.springinaction.springidol;

/**
 * Created by 强 on 2018/12/11.
 */
public class Stage {
    private Stage() {
    }

    private static class StageSingletonHolder {
        //延迟加载实例
        static Stage instance = new Stage();
    }

    public static Stage getInstance() {
        //返回实例
        return StageSingletonHolder.instance;
    }
}
