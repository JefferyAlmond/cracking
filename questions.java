import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.math.*;

public class questions {

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n3;
		n6.next = n1;
		
		
	}
	
	public static boolean stringUniqueCharacters (String input) {	//Returns true if the input string contains all unique characters. Run time for string of length n is O((n^2)/2)
		if (input.length() == 1) return true;
		else {
			char check = input.charAt(0);
			char[] chars = input.substring(1).toCharArray();
		
			for (char c : chars) {
				if (check == c) return false;
				else  stringUniqueCharacters(input.substring(1));
			}
		}
		return true;
	}
	
	public static boolean stringPermutation (String str1, String str2) {	//Returns true if 256 character ASCII string inputs are permutations of each other. Run time for string of length n is O(3n)
		
		int[] chars = new int[256];
		
		for (int i = 0; i < str1.length(); i++) {
			chars[str1.charAt(i)]++;
		}
		
		for (int i = 0; i < str2.length(); i++) {
			chars[str2.charAt(i)]--;
		}
		
		for (int i : chars) {
			if (i != 0){
				return false;
			}
		}
		
		return true;
	}
	
	public static Character[] spaceReplace (Character[] chars) { //In place, replaces all spaces in a character array with '%20'
		
		/*Character[] s = {'b', 'o', 'r', 'k', ' ', 'b', 'o', 'r', 'k', ' ', 'b', 'o', 'r', 'k'};
		for (char i : s) {
			System.out.print(i);
		}
		System.out.println();
		for (char i : spaceReplace(s)) {
			System.out.print(i);
		}*/
		
		ArrayList<Character> replacedChars = new ArrayList<Character>();	//Use 'Character' class, not 'char' primitive. 
		
		
		for (char c : chars) {
			if (c == ' ') {
				replacedChars.add('%');
				replacedChars.add('2');
				replacedChars.add('0');
			}else {
				replacedChars.add(c);
			}
		}
		
		Character  list2[] = new Character[replacedChars.size()];
		chars = replacedChars.toArray(list2);
		
		return chars;
	}
	
	public static String stringCompression (String toCompress) {
		
		String compressed = "";
		int repeatCount = 1;
		char last = toCompress.charAt(0);
		
		for (int i = 1; i < toCompress.length(); i++) {
			
			if (toCompress.charAt(i) == last) {
				repeatCount++;
			}else{
				compressed += last;
				compressed += repeatCount;
				last = toCompress.charAt(i);
				repeatCount = 1;
			}
		}
		
		compressed += last;
		compressed += repeatCount;
		
		if (compressed.length() >= toCompress.length()) {
			return toCompress;
		}
		
		return compressed;
		
	}
	
	public static boolean[][] imageRotate(boolean[][] image){ //Rotates n*n matrix input ninety degrees counter-clockwise
		
		/*
		 int imageDimension = 10;
		boolean[][] image = new boolean[imageDimension][imageDimension];
		boolean[][] rotatedImage = new boolean[imageDimension][imageDimension];
		
		image [1][1] = true;
		image [1][5] = true;
		image [1][6] = true;
		image [2][0] = true;
		image [2][2] = true;
		image [2][4] = true;
		image [2][7] = true;
		image [3][1] = true;
		image [3][3] = true;
		image [3][8] = true;
		image [4][3] = true;
		image [4][6] = true;
		image [4][9] = true;
		image [5][3] = true;
		image [5][5] = true;
		image [5][7] = true;
		image [5][9] = true;
		image [6][2] = true;
		image [6][5] = true;
		image [6][8] = true;
		image [6][9] = true;
		image [7][1] = true;
		image [7][5] = true;
		image [8][2] = true;
		image [8][3] = true;
		image [8][4] = true;

		for (int y = 0; y < imageDimension; y++) {
			for (int x = 0; x < imageDimension; x++) {
				if (image[x][y]) {
					System.out.print("0 ");
				}else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		
		rotatedImage = imageRotate(image);
		
		for (int y = 0; y < imageDimension; y++) {
			for (int x = 0; x < imageDimension; x++) {
				if (rotatedImage[x][y]) {
					System.out.print("0 ");
				}else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
		 */
		
		boolean[][] rotatedImage = new boolean[image.length][image[0].length];
		
		for (int y = 0; y < image.length; y++) {
			for (int x = 0; x < image.length; x++) {
				if (image[x][y]) {
					rotatedImage[y][image.length-x-1] = true;
				}else {
					rotatedImage[y][image.length-x-1] = false;
				}
			}
			
		}
		
		return rotatedImage;
	}

	public static boolean[][] matrixSetZeroes(boolean [][] matrix){ //For each true element in input matrix, sets entire row and column of that element to 0 
		
		/*
		boolean[][] matrix = new boolean[imageDimension][imageDimension];
		boolean[][] matrixSet = new boolean[imageDimension][imageDimension];
		
		matrix [7][2] = true;
		matrix [2][2] = true;
		matrix [5][4] = true;
		matrix [2][7] = true;


		for (int y = 0; y < matrix[0].length; y++) {
			for (int x = 0; x < matrix.length; x++) {
				if (matrix[x][y]) {
					System.out.print("0 ");
				}else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		
		matrixSet = matrixSetZeroes(matrix);
		
		
		for (int y = 0; y < matrixSet[0].length; y++) {
			for (int x = 0; x < matrixSet.length; x++) {
				if (matrixSet[x][y]) {
					System.out.print("0 ");
				}else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
		 */
		
		boolean[][] matrixSet = new boolean[matrix.length][matrix[0].length];
		
		for (int y = 0; y < matrix[0].length; y++) {
			for (int x = 0; x < matrix.length; x++) {
				if (matrix[x][y]) {
					for (int i = 0; i < matrixSet.length; i++) {
						matrixSet[x][i] = true;
					}
					for (int i = 0; i < matrixSet[0].length; i++) {
						matrixSet[i][y] = true;
					}	
				}
			}
		}
		
		return matrixSet;
	}

	public static boolean isRotation(String s1, String s2) { //Returns true if String s1 is a rotation of String s1 (rotation eg. "waterbottle" to "erbottlewat")
		if (s1.length() != s2.length()) return false;
		String s3 = s2 + s2;
		if (s3.contains(s1)) return true;
		return false;
	}
	
	public static void removeLinkedListDuplicates(Node n){
		
		if (n == null) return;
		Node current = n;
		
		while (current != null) {
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				}else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
		
	}
	
	public static void deleteNode(Node n) { //Delete a linked list node without access to other nodes in the list. Runs in O(n/2) time.
		while (n.next != null) {
			n.data = n.next.data;
			n = n.next;
		}
	}
	
	public static int findKthToLast(Node n, int k) { //Return data k nodes from last from linked list starting with node n. Runs in O(2n-k) time.
		int length = 0;
		Node runner = n;
		
		while (runner != null) {
			length++;
			runner = runner.next;
		}
		
		runner = n;
		
		while ((length - k) != 0) {
			runner = runner.next;
			length--;
		}
		
		return runner.data;
	}
	
	public static void partitionLinkedList(Node n, int x) {
		Node n1 = new Node(0);
		Node n2 = new Node(0);
		
		while (n != null) {
			if (n.data >= x) {
				
			}
		}
	}
	
	public static Node powerAdditionLinkedList(Node n1, Node n2) { //Takes two numbers represented by linked lists with the lowest digit in the head and each digit in a subsequent list element, and returns their sum in the same format
		/*
		 Node n01 = new Node(4);
		Node n02 = new Node(8);
		Node n03 = new Node(5);
		Node n04 = new Node(6);
		
		Node n11 = new Node(8);
		Node n12 = new Node(2);
		Node n13 = new Node(0);
		Node n14 = new Node(3);
		
		n01.next = n02;
		n02.next = n03;
		n03.next = n04;
		
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		
		Node node = powerAdditionLinkedList(n01, n11);
		
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		} 
		 **/
		
		Node answer = new Node(0);
		
		int sum = 0;
		int factor = 0;
		
		while (n1 != null) {
			sum += (n1.data) * (Math.pow(10,  factor));
			factor++;
			n1 = n1.next;
		}
		
		factor = 0;
		
		while (n2 != null) {
			sum += (n2.data) * (Math.pow(10,  factor));
			factor++;
			n2 = n2.next;
		}
		
		int digits = (int) Math.floor(Math.log10(sum))+1;
		factor = (int) Math.floor(Math.log10(sum));
		
		while (factor > -1) {
			
			answer.appendToTail((int) (sum%(Math.pow(10, digits - factor))/(Math.pow(10,  (digits - factor - 1)))));
			sum -= sum%(Math.pow(10, digits - factor));
			factor--;
			
		}
		
		return answer.next;
	}

	public static Node findCircularLinkedListNode(Node n) {//Returns the head of the loop in a looped (corrupt) linked list
		Node n1 = n;
		Node n2 = n1;
		if (n == n.next) return n;
		
		while (n1 != null) {
			n2 = n;
			while (n2 != n1) {
				if ((n1.next == n2.next) && (n1 != n2)) {
					return n2;
				}
				n2 = n2.next;
			}
			n1 = n1.next;
		}
		return null;
	}
}

class Node {
	Node next = null;
	int data;

	public Node(int d) {
		data = d;
	}

	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		 n.next = end;
	}
}

class Stack {
	Node top;

	Object pop() {
		if (top != null) {
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}

	void push(int item) {
		Node t = new Node(item);
		t.next = top;
		top = t;
	}

	Object peek() {
	return top.data;
	}
}

class Queue {
	Node first, last;

	void enqueue(int item) {
		if (first == null) {
			last = new Node(item);
			first = last;
		} else {
			last.next = new Node(item);
			last = last.next;
		}
	}

	Object dequeue() {
		if (first != null) {
			Object item = first.data;
			first = first.next;
			return item;
		}
		return null;
	}
}
