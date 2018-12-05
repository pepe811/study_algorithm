package DataStructures.LinkedList;

import java.util.*;

import DataStructures.LinkedList.InsertANodeAtTheTail.SinglyLinkedListNode;

public class InsertAnodeAtAspecificPosition {
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
    
    // Complete the insertNodeAtPosition function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
    	int nodeIdx = 0;
    	
    	SinglyLinkedListNode node = head; //업데이트된 리스트의 헤드를 반환해야해서 
    	
    	SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

    	//맨앞에 insert 할 경우
    	if(position == 0) {
    		newNode.next = head;
    		return newNode;
    	}
    	
    	while (node.next != null && nodeIdx < position-1) {   		
    		node = node.next;
    		nodeIdx++;
    	}
    	System.out.println("current node idx = " + nodeIdx);
    	
    	//끼어놓을 인덱스의 이전 인덱스 노드(position-1) 도착하면
    	
		SinglyLinkedListNode temp = node.next;
		node.next = newNode; //다음 노드에 새노드 끼어놓고
		newNode.next = temp; //원래 다음노드는 새 노드의 next에 넣기
		
    	return head;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
      
        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        int data = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int position = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);

        printSinglyLinkedList(llist_head, " ");

        scanner.close();
    }
}
