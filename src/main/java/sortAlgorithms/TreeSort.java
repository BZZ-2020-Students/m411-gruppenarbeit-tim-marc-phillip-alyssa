package sortAlgorithms;

import util.Measurement;
import util.Time;

/**
 * TreeSort implementation to sort an array of ints
 *
 * @author Tim Irmler
 * @version 1.0
 * @since 04-01-2022
 */
public class TreeSort implements Sorter {
    Node root;
    int index = 0;
    Measurement measure = new Measurement();

    public TreeSort() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        measure.increaseIterations();
        measure.increaseComparisons();
        if (root == null) {
            root = new Node(key);
            return root;
        }

        measure.increaseComparisons();
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    private void putInOrder(Node root, int[] sortedArray) {
        measure.increaseIterations();
        measure.increaseComparisons();
        if (root != null) {
            putInOrder(root.left, sortedArray);
            sortedArray[index++] = root.key;
//            System.out.print(root.key + " ");
            putInOrder(root.right, sortedArray);
        }
    }

    void insertEverything(int[] arr) {
        for (int j : arr) {
            insert(j);
        }
    }

    @Override
    public Measurement sort(int[] array) {

        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long time = Time.currentTime();

        insertEverything(array);
        putInOrder(this.root, array);

        measure.setTimeInNs(Time.calculateElapsed(time));
        measure.setMemory((runtime.totalMemory() - runtime.freeMemory()) - usedMemoryBefore);

        return measure;
    }

    private static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
}
