package com.vaibhav.snippets.data_structures;

public class Heap {

    public static void main(String[] args) throws Exception {
        MinHeap h = new MinHeap(10);
        h.add(7);
        System.out.println("added 7");
        h.printHeap();
        h.add(10);
        System.out.println("added 10");
        h.printHeap();
        h.add(5);
        System.out.println("added 5");
        h.printHeap();
        h.add(2);
        System.out.println("added 2");
        h.printHeap();
        System.out.println("see min value: "+h.peek());
        System.out.println("Extract min value: "+h.extractMin());
        System.out.println("see min value: "+h.peek());
    }
}

class MinHeap {
    private int[] bucket;
    private Integer size;
    private int maxSize;

    MinHeap(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
        bucket = new int[maxSize];
    }

    private int getParent(int index) {
        return index/2;
    }

    private int getLeftChild(int index) {
        return index*2;
    }

    private int getRightChild(int index) {
        return index*2 + 1;
    }

    private void swap(int index1, int index2) {
        int temp = bucket[index1];
        bucket[index1] = bucket[index2];
        bucket[index2] = temp;
    }

    public void add(int value) throws Exception {
        if (size + 2 > maxSize) {
            throw new Exception("Maximum capacity reached");
        }
        bucket[size++] = value;
        heapifyUp(size-1);
    }

    private void heapifyUp(int index) throws Exception {
        if (index > maxSize) {
            throw new Exception("Cannot perform heapify, overflow");
        }
        while(bucket[getParent(index)] > bucket[index]) {
            swap(index, getParent(index));
            index = getParent(index);
        }
    }

    public int extractMin() throws Exception {
        if (size == 0 ){
            throw new Exception("Heap is empty");
        }
        int result = bucket[0];
        bucket[0] = bucket[size-1];
        size--;
        heapifyDown();
        return result;
    }

    public int peek() throws Exception {
        if (size == 0){
            throw new Exception("Heap is empty");
        }
        return bucket[0];
    }

    private void heapifyDown() {
        int index = 0;
        while((getLeftChild(index) < size && bucket[index] > bucket[getLeftChild(index)])
                || (getRightChild(index) < size && bucket[index] >  bucket[getRightChild(index)])) {
            if (getLeftChild(index) < size && bucket[index] > bucket[getLeftChild(index)]) {
                swap(index, getLeftChild(index));
                index = getLeftChild(index);
            } else {
                swap(index, getRightChild(index));
                index = getLeftChild(index);
            }
        }
    }

    public void printHeap() {
        System.out.print("heap is : ");
        for(int i = 0 ; i< size ; i++) {
            System.out.print(bucket[i] + " ");
        }
        System.out.println();
    }
}
