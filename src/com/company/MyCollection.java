package com.company;

import java.security.KeyException;

class MyCollection <K extends Comparable, V>{
    private BNode head;
    private class BNode {
        V data;
        BNode left;
        BNode right;
        K key;
        BNode(V data, K key) {
            this.data = data;
            this.key = key;
        }
    }

    void put(V data, K... keys) throws KeyException{
        for (K key:keys){
            BNode temp = new BNode(data, key);
            if (head == null){
                head = temp;
            }
            else {
                put(temp, head);
            }
        }
    }

    private void put(BNode temp, BNode root) throws KeyException {
        if (temp.key.compareTo(root.key) == 0) {
            throw new KeyException();
        }
        if (temp.key.compareTo(root.key)<0){
            if (root.left == null){
                root.left = temp;
            }
            else {
                put(temp, root.left);
            }
        }
        else {
            if (root.right == null){
                root.right = temp;
            }
            else {
                put(temp, root.right);
            }
        }
    }

    V get(K key){
        return get(key, head);
    }

    private V get(K key, BNode root){
        if (root == null) return null;
        int cmp = key.compareTo(root.key);
        if (cmp == 0) return root.data;
        else if (cmp < 0) return get(key, root.left);
        else return get(key, root.right);
    }
}
