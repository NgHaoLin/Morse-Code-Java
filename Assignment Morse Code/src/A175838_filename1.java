import java.io.*;
import java.util.*;

public class A175838_filename1 extends A175838_filename3{
	public class Node{
		String key;
		String key1;
		Node left, right;
		public Node(String item, String item1){
			key = item;
			key1 = item1;
			left = right = null;
		}
	}
	
	Node root;
	A175838_filename1(){
		super();
		root = null;
	}

	public void insert() {
		super.insert();
	}
	
	public void insertRec(String key,String key1){
		root = insertRec1(root,key,key1);
	}

	Node insertRec1(Node root, String key,String key1) {
		if(root == null){
			root = new Node(key,key1);
			return root;
		}
		if(key.compareTo(root.key)<0)
			root.left = insertRec1(root.left,key,key1);
		else if(key.compareTo(root.key)>0)
			root.right = insertRec1(root.right,key,key1);
		return root;
	}
	
	public String search(String letter) {
		Node a = root;
		boolean exists = false;
		
		while(a!=null) {
			if(a.key.equals(letter) && exists == false) {
				exists =  true;
				return a.key1;
			}
			else if(letter.compareTo(a.key)<0) {
				a = a.left;
			}
			else if(letter.compareTo(a.key)>0) {
				a = a.right;
			}	
		}
		return a.key1;	
	}
	
	public String inputSearch(String letter) {
		String upercase = letter.toUpperCase();
		String anscode ="";
		String delims = "";
		String [] words = upercase.split(delims);
		
		for(String str:words) {
			if(str.equals(" ")) {
				anscode +=" ";
			}
			else if(str.length()>0) {
				String ans = search(str);
				anscode +=ans+" ";
			}
		}
		return anscode.replaceAll("\\s+$", "");
	}
}
