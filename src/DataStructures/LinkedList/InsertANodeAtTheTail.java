package DataStructures.LinkedList;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
 * https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem
 */

public class InsertANodeAtTheTail {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }
      
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) throws IOException {
        while (node != null) {
        	System.out.print(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
            	System.out.print(sep);
            }
        }
    }
    
    // Complete the insertNodeAtTail function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
    	//첫번째 노드 insert
    	if(head == null) {
    		head = new SinglyLinkedListNode(data);
    		System.out.println("첫번째노드");
    	}
    	else {
    		SinglyLinkedListNode node = head; //업데이트된 리스트의 헤드를 반환해야해서 
    		//현재 노드 next가 null이 아니면
    		while (node.next != null) {
    			//현재노드를 다음 노드로 이동 반복
    			node = node.next;  //클래스 주소 참조 하고있으니까 head = head.next
    			System.out.println("현재 노드 data " + node.data);
    		}
    		//현재 노드 next가 null 되면 현재 노드가 마지막 노드
    		node.next = new SinglyLinkedListNode(data);
    		System.out.println(node.data + "의  next 노드 data에 " + data + " insert");
    	}
    	
    	return head; //제일 앞부분 head 노드로 반환
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
          
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

          SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);
          llist.head = llist_head;
        }

        printSinglyLinkedList(llist.head, "\n");

        scanner.close();
    }
}
