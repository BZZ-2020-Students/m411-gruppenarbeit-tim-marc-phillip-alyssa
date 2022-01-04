package sortAlgorithms;

import util.Measurement;

import java.util.Arrays;

public class TreeSort implements Sorter {
    // Root of BST
    Node root;

    // Constructor
    public TreeSort() {
        root = null;
    }

    // This method mainly
    // calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to
    insert a new key in BST */
    private Node insertRec(Node root, int key) {
        /* If the tree is empty,
        return a new node */
        measure.increaseIterations();
        measure.increaseComparisons();
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur
        down the tree */
        measure.increaseComparisons();
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        /* return the root */
        return root;
    }

    // A function to do
    // inorder traversal of BST
    private void inorderRec(Node root, int[] sortedArray, int index) {
        measure.increaseIterations();
        measure.increaseComparisons();
        if (root != null) {
            inorderRec(root.left, sortedArray, index);
            sortedArray[index++] = root.key;
            inorderRec(root.right, sortedArray, index);
        }
    }

    void treeins(int[] arr) {
        for (int j : arr) {
            insert(j);
        }
    }

    @Override
    public Measurement sort(int[] array) {
        long time = System.currentTimeMillis();
        treeins(array);
        inorderRec(this.root, new int[array.length], 0);
        measure.setTime(System.currentTimeMillis() - time);
        System.out.println("array = " + Arrays.toString(array));
        return measure;
    }

    // Class containing left and
    // right child of current
    // node and key value
    private static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
}
