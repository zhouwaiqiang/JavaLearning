package com.zhou.tree;

/**
 * Created by 强 on 2018/9/13.
 */
public class SequentialSearchST<Key, Value> {
    private Node first;
    private class Node {
        Key key;
        Value value;
        Node next;
        public Node (Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node () {

        }

    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key == key) return x.value;
        }
        return null;
    }

    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) x.value = value;//update
        }
        Node first = new Node();
    }
}
