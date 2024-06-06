package com.khun.dsa.tree;


public class BinaryTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public void insert(T data) {
        root = insetRec(root, data);
    }

    private TreeNode<T> insetRec(TreeNode<T> root, T data) {
        if (root == null) {
            root = new TreeNode<>(data);
            return root;
        }
        if (data.compareTo(root.data) < 0) {
            root.leftChild = insetRec(root.leftChild, data);
        } else {
            root.rightChild = insetRec(root.rightChild, data);
        }
        return root;
    }

    public void inorder() {
        inOrderRec(root);
    }

    private void inOrderRec(TreeNode<T> root) {
        if (root != null) {
            inOrderRec(root.leftChild);
            System.out.print(root.data + " ");
            inOrderRec(root.rightChild);
        }
    }

    public void preorder() {
        preOrderRec(root);
    }

    private void preOrderRec(TreeNode<T> root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.leftChild);
            preOrderRec(root.rightChild);
        }
    }

    public void postorder() {
        postOrderRec(root);
    }

    private void postOrderRec(TreeNode<T> root) {
        if (root != null) {
            preOrderRec(root.leftChild);
            preOrderRec(root.rightChild);
            System.out.print(root.data + " ");
        }
    }

    public boolean search(T data) {
        return searchRec(root, data);
    }

    private boolean searchRec(TreeNode<T> root, T data) {
        if (root == null) return false;

        if (data.compareTo(root.data) == 0) {
            return true;
        }
        return data.compareTo(root.data) < 0 ? searchRec(root.leftChild, data) : searchRec(root.rightChild, data);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        // Insert elements
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        // Inorder traversal
        System.out.print("Inorder traversal: ");
        tree.inorder();
        System.out.println();

        // Preorder traversal
        System.out.print("Preorder traversal: ");
        tree.preorder();
        System.out.println();

        // Postorder traversal
        System.out.print("Postorder traversal: ");
        tree.postorder();
        System.out.println();

        // Search elements
        System.out.println("Search 40: " + tree.search(40)); // Outputs true
        System.out.println("Search 90: " + tree.search(90)); // Outputs false
    }
}
