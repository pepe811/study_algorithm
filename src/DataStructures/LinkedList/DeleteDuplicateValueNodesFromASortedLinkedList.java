package DataStructures.LinkedList;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DeleteDuplicateValueNodesFromASortedLinkedList {

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
    
    // Complete the removeDuplicates function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
    	  if ( head == null ) return null;
    	  System.out.println("head: " + head.data);
    	  SinglyLinkedListNode nextItem = head.next;
    	  while ( nextItem != null && head.data == nextItem.data ) {
    	    nextItem = nextItem.next;
    	  }
    	  head.next = removeDuplicates( nextItem );
    	  System.out.println("-- head: " + head.data);
    	  if ( head.next != null ) 
    		  System.out.println("-- head.next: " + head.next.data);
    	  else
    		  System.out.println("-- head.next: null");
    	 
    	  return head;

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

        SinglyLinkedListNode llist1 = removeDuplicates(llist.head);

        printSinglyLinkedList(llist1, " ");

        scanner.close();
    }
}
