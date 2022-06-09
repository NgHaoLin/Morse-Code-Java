import java.util.*;
import java.io.*;

public class A175838_filename3 {
	int count = 0;

	public class Node{
		String key;
		String key1;
		Node left, right;
		public Node() {
			left = right = null;
			this.key = key;
			this.key1 = key1;
		}
	}
	
	Node root;
	A175838_filename3(){
		root = new Node();
	}
	
	public void insert() {
        Scanner filein = null;
        try {
            filein = new Scanner(new File("A175838_File2.dat"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        while (filein.hasNextLine()) {
            String value = filein.nextLine().trim();
            if (value.length() > 0) {
                insertRec(value.substring(0,1).trim(), value.substring(1).trim());
            }
        }
        filein.close();
    }
	
	public void insertRec(String letter , String morsecode) {
		Node a = root;
		for(int i=0;i<morsecode.length();i++) {
			if(morsecode.substring(i, i+1).equals(".")) {
				if(a.left == null) {
					a.left = new Node();
				}
				a = a.left;
			}
			else if(morsecode.substring(i,i+1).equals("-")) {
				if(a.right == null) {
					a.right = new Node();
				}
				a = a.right;
			}
		}
		a.key = letter;
		a.key1 = morsecode;
	}
	
	public void inorder() {
		inorderRec(root);
	}
	
	public void inorderRec(Node root) {
		if(root == null)
			return;
			inorderRec(root.left);
			if(root.key!=null) {
				System.out.printf("%-1s %-5s \t",root.key,root.key1);
				count++;
				counter(count);
				}
			inorderRec(root.right);
			
	}
	
	public void counter(int count) {
		if(count%5==0) {
			System.out.print("\n");
		}
	}
}
