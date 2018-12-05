package DataStructures.LinkedList;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ReverseALinkedList {

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
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
            	System.out.print(sep);
            }
        }
    }
    
    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
    	System.out.println("head: " + head.data);
    	if(head == null || head.next == null) {
    		System.out.println("return head: " + head.data);
    		//마지막 노드 리턴
    		return head;
    	}
    	SinglyLinkedListNode newNode = reverse(head.next);
    	System.out.println("-- head: " + head.data + ", new node: " + newNode.data);
    	head.next.next = head; //ex) 1 2 3 4 면 / 3의 다음 다음에 (4의 다음) 3을 넣고 / 2의 다음 다음에 (3의 다음) 2을 넣고 
    	System.out.println("-- head.next.next: " + head.next.next.data);
    	head.next = null;    	// 3을 마지막 노드로 끊기 / 2을 마지막 노드로 끊기

    	printSinglyLinkedList(newNode," ");
    	System.out.println();
    	System.out.println("return newnode: " + newNode.data);
    	return newNode;
    	
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            
        for (int i = 0; i < llistCount; i++) {
        	int llistItem = scanner.nextInt();
        	scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            llist.insertNode(llistItem);
        }
            
        SinglyLinkedListNode llist1 = reverse(llist.head);

        printSinglyLinkedList(llist1, " ");
        

        scanner.close();
    }
}
