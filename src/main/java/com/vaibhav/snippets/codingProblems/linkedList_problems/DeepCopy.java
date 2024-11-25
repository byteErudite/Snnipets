package com.vaibhav.snippets.codingProblems.linkedList_problems;

import java.util.HashMap;

/**
 * Definition for singly-linked list with a random pointer.
 */ class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  }
public class DeepCopy {

     /*
     A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.

Return a deep copy of the list.

Example

Given list

   1 -> 2 -> 3
with random pointers going from

  1 -> 3
  2 -> 1
  3 -> 1
You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the returned list should not link to any node in the original input list.
      */

    /*
    There are 2 approaches to solving this problem.

Approach 1 : Using hashmap.
Use a hashmap to store the mapping from oldListNode to the newListNode. Whenever you encounter a new node in the oldListNode (either via random pointer or through the next pointer ), create the newListNode, store the mapping. and update the next and random pointers of the newListNode using the mapping from the hashmap.

Approach 2 : Using 2 traversals of the list.
Step 1: create a new node for each existing node and join them together eg: A->B->C will be A->A’->B->B’->C->C’

Step2: copy the random links: for each new node n’, n’.random = n.random.next

Step3: detach the list: basically n.next = n.next.next; n’.next = n’.next.next
     */


    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(10);
        RandomListNode first = new RandomListNode(20);
        RandomListNode second = new RandomListNode(30);
        head.next = first;
        first.next = second;
        second.next = null;
        head.random= second;
        first.random = null;
        second.random = first;
        Integer[] arr = {3, 30, 34, 5, 9};
        System.out.println(copyRandomListMySolution(head));
    }

    // Hashmap Solution
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) return head;
        HashMap<RandomListNode,RandomListNode> map=new HashMap();
        RandomListNode curr=head;
        while(curr!=null){
            map.put(curr,new RandomListNode(curr.label));
            curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            RandomListNode node=map.get(curr);
            node.next=map.get(curr.next);
            node.random=map.get(curr.random);
            curr=curr.next;
        }

        return map.get(head);

    }

    public static RandomListNode copyRandomListMySolution(RandomListNode head) {
        RandomListNode trev = head;
        RandomListNode resultHead = null;
        RandomListNode resultEnd = null;
        int index = 0;
        while(trev != null) {
            RandomListNode newNode = new RandomListNode(trev.label);
            newNode.next = null;
            if (resultHead == null) {
                resultEnd = newNode;
                resultHead = newNode;
            } else {
                resultEnd.next = newNode;
                resultEnd = newNode;
            }
            trev.label = index;
            trev = trev.next;
            index++;
        }
        resultEnd.next = null;
        trev = head;
        RandomListNode trevResult = resultHead;
        while(trev != null && trevResult != null) {
            RandomListNode randomNode = trev.random;
            if (randomNode == null) {
                trevResult.random = null;
            } else {
                trevResult.random = findIndex(randomNode.label, resultHead);
            }
            trev = trev.next;
            trevResult = trevResult.next;
        }
        return resultHead;
    }

    private static RandomListNode findIndex(int label, RandomListNode head) {
        RandomListNode trev = head;
        int index = 0;
        while(trev != null && label!= index) {
            index++;
            trev = trev.next;
        }
        return trev;
    }
}
