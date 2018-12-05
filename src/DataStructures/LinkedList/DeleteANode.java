package DataStructures.LinkedList;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DeleteANode {

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

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) throws IOException {
        while (node != null) {
            System.out.print(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
            	System.out.print(sep);
            }
        }
    }
    
    // Complete the deleteNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
    	SinglyLinkedListNode node = head; //업데이트된 리스트의 헤드를 반환해야해서 
    	
    	int nodeIndex = 0;
    	
    	//맨앞에 insert 할 경우
    	if(position == 0) {
    		head = node.next;
    		return head;
    	}
    	
    	while(node.next != null && nodeIndex < position - 1) {
    		node = node.next;
    		nodeIndex++;
    	}
    	System.out.println("current nodeIndex:"+ nodeIndex);
    	//현재 노드가 position 노드의 전 노드까지 오면
    	SinglyLinkedListNode positionNextNode = node.next.next; //position이 마지막이면 null
    	node.next = positionNextNode;
    	
    	return head;
    	
    	/*
    	 * 재귀호출 방법
    	 * 삭제할 노드 위치 왔을때 deleteNode 호출 안하고 그 다음 노드를 반환
    	 * ex) 4 / 0 1 2 3 / 2 이면 0,2  1,1  2,0 됐을때  1,1 의 head.next에 2의 next인 3노드를 리턴,
    	 * 나머진 head 리턴
           
    	System.out.println(head.data+" "+position);
    	if (position == 0){ return head.next; }
        head.next = deleteNode(head.next, position-1);
        return head;
        
    	*/
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        int position = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SinglyLinkedListNode llist1 = deleteNode(llist.head, position);

        printSinglyLinkedList(llist1, " ");

        scanner.close();
    }
}