package com.vaibhav.snippets.miscellaneous;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

public class LRUCacheImpl {

    class LinkedListNode {
        int key;
        int data;

        public LinkedListNode(int key, int data) {
            this.key = key;
            this.data = data;
        }
    }

    int capacity;

    //LinkedListNode holds key and value pairs
    Set<Integer> cache;
    LinkedList<LinkedListNode> cache_vals;
    public LRUCacheImpl(int capacity) {
        this.capacity = capacity;
        cache = new HashSet<Integer>(capacity);
        cache_vals = new LinkedList<LinkedListNode>();
    }

    LinkedListNode get(int key) {
        if(!cache.contains(key)){

            return null;
        }
        else {

            ListIterator<LinkedListNode> iterator1 = cache_vals.listIterator(0);
            while(iterator1.hasNext()){
                LinkedListNode node = iterator1.next();
                if (node.key == key){
                    return node;
                }
            }
            return null;
        }
    }

    void set(int key, int value) {
        LinkedListNode node = get(key);

        if(node == null){
            evict_if_needed();
            node = new LinkedListNode(key, value);
            cache_vals.addLast(node);
            cache.add(key);
        }
        else {
            cache_vals.remove(node);
            cache_vals.addLast(node);
        }
    }

    void evict_if_needed(){
        if(cache_vals.size() >= capacity) {
            LinkedListNode node = cache_vals.remove();
            cache.remove(node.key);

        }
    }

    void print() {
        ListIterator<LinkedListNode> iterator = cache_vals.listIterator(0);
        while(iterator.hasNext()){
            LinkedListNode node = iterator.next();
            System.out.print(node.key + ":" +node.data + ", ");
        }
        System.out.println("");
    }
    public static void main(String[] args){
        LRUCacheImpl cache = new LRUCacheImpl(4);

        cache.set(10, 50);
        cache.print();

        cache.set(15, 25);
        cache.print();

        cache.set(20, 30);
        cache.print();

        cache.set(25, 35);
        cache.print();

        cache.set(20, 30);
        cache.print();

        cache.set(40, 50);
        cache.print();

        cache.set(25, 35);
        cache.print();
    }
}
