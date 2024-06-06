package com.khun.dsa.tree;

public class TreeNode<T> {
    T data;
    TreeNode<T> leftChild;
    TreeNode<T> rightChild;

    public TreeNode(T data) {
        this.data = data;
    }
}
