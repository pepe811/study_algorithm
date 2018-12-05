package DataStructures.LinkedList;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MergeTwoSortedLinkedLists {

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
		System.out.println();
	}

	// Complete the mergeLists function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		
		if (head1 == null && head2 == null)
			return null;
		else if (head1 == null) {
			System.out.println("head1 is null, return head2:"+head2.data);
			return head2;
		}
		else if (head2 == null) {
			System.out.println("head2 is null, return head1:"+head1.data);
			return head1;
		}
		
		System.out.println("head1:" + head1.data + " head2:" + head2.data + "비교");

		//2가 1보다 크면 1의 포인터를 순방향으로 한 위치 씩 이동
		if (head1.data <= head2.data) {
			System.out.println("정렬 없음");
			head1.next = mergeLists(head1.next, head2);
			System.out.println("head1("+ head1.data + ")의 next:" + head1.next.data);
		}	
		//2가 1보다 작으면 2의 데이터를 1의 앞으로 넣기
		else {
			SinglyLinkedListNode temp = head2;
			
			head2 = head2.next;//2의 포인터 한 위치 뒤로  이동
			temp.next = head1;
			head1 = temp;
			
			System.out.print("정렬 후 head1:");
			printSinglyLinkedList(head1," ");
			System.out.print("정렬 후 head2:");
			printSinglyLinkedList(head2," ");
			
			head1.next = mergeLists(head1.next, head2);
			System.out.println("head1("+ head1.data + ")의 next:" + head1.next.data);
		}
		
		 
		System.out.println("return head1:" + head1.data);
		return head1;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		SinglyLinkedList llist1 = new SinglyLinkedList();

		int llist1Count = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < llist1Count; i++) {
			int llist1Item = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			llist1.insertNode(llist1Item);
		}

		SinglyLinkedList llist2 = new SinglyLinkedList();

		int llist2Count = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < llist2Count; i++) {
			int llist2Item = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			llist2.insertNode(llist2Item);
		}

		SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

		printSinglyLinkedList(llist3, " ");

		scanner.close();
	}
}