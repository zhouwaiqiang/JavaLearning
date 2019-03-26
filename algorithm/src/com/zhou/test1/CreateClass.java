package com.zhou.test1;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by 强 on 2019/3/19.
 */
public class CreateClass implements Serializable, Cloneable {
    private static final long serializableUID = 1L;
    private String name;

    public CreateClass() {
        System.out.println("CreateClass Constructor Called...");
    }
    public String getName() {
        return name;
    }

    public CreateClass clone() {
        CreateClass clone = null;
        try {
            clone = (CreateClass) super.clone();
        } catch (CloneNotSupportedException e) {

        }
        return clone;
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateClass test = (CreateClass)o;
        return Objects.equals(name, test.name);
    }
}
