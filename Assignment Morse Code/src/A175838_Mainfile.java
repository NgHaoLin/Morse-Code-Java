import java.io.*;
import java.util.*;

public class A175838_Mainfile {
	public static void main(String[] args) {
		A175838_filename1 tree1 = new A175838_filename1();
		A175838_filename2 tree2 = new A175838_filename2();
		A175838_filename3 tree3 = new A175838_filename3();
		Scanner sc= new Scanner(System.in);
		
		tree3.insert();
		tree1.insert();
		menu();
		int x = sc.nextInt();
		String a = sc.nextLine();
		
		while(x!=4) {
			if(x<4 && x>=1) {
				int countline = 0;
				int countword = 0;
				int countcharacter = 0;
				int countsymbol = 0;
				int countnumber = 0;
				if(x == 1) {
					a = sc.nextLine();
					if(!a.equals("VV")) {
						System.out.println("Wrong Input! Please Start with VV!\n");
					}
					else {
						while(!a.equals("EOM")) {
							System.out.println(tree1.inputSearch(a));
							a = sc.nextLine();
							countline++;
							countword+=wordcount(a);
							countcharacter+=charactercount(a);
							countsymbol+=symbolcount(a);
							countnumber+=numbercount(a);
						}
						System.out.println(". --- --");
						System.out.println(tree1.inputSearch(String.valueOf(countline+1)));
						System.out.println(tree1.inputSearch(String.valueOf(countword+1)));
						System.out.println(tree1.inputSearch(String.valueOf(countcharacter+2)));
						System.out.println(tree1.inputSearch(String.valueOf(countsymbol)));
						System.out.println(tree1.inputSearch(String.valueOf(countnumber)));
						System.out.println(". --- -\n");
					}
				}
				else if(x==2) {
					int countlinedecode = 0;
					int countworddecode = 0;
					int countchardecode = 0;
					int countsymbdecode = 0;
					int countnumbdecode = 0;
					String compare1 = "";
					String compare2 = "";
					a = sc.nextLine();
					if(!a.equals("...- ...-")) {
						System.out.println("Wrong Input! Please Start with '...- ...-'!\n");
					}
					else {
						while(!a.equals(". --- --")) {
							String output = tree2.inputSearch(a);
							System.out.println(output);
							countworddecode+=wordcount(output);
							countchardecode+=charactercount(output);
							countsymbdecode+=symbolcount(output);
							countnumbdecode+=numbercount(output);
							countlinedecode++;
							a = sc.nextLine();
						}
						while(!a.equals(". --- -")) {
							String output1 = tree2.inputSearch(a);
							if(!output1.equals("EOM")) {
								compare1+=output1+" ";
							}
							System.out.println(output1);
							a = sc.nextLine();
						}
						compare2 = Integer.toString((countlinedecode+1))+" "+Integer.toString((countworddecode+1))+" "+
								Integer.toString((countchardecode+3))+" "+Integer.toString(countsymbdecode)+" "+Integer.toString(countnumbdecode)+" ";
						
						System.out.println("EOT\n");
						System.out.println((countlinedecode+1)+" "+(countworddecode+1)+" "+(countchardecode+3)+" "
						+(countsymbdecode)+" "+(countnumbdecode));
						
						if(compare1.equals(compare2)) {
							System.out.println("Result: Consistent Summary\n");
						}
						else {
							System.out.println("Result: Inconsistent Summary\n");
						}
					}
				}
				else if(x==3) {
					tree3.inorder();
					System.out.println("\n");
				}
				menu();
				x = sc.nextInt();
				a = sc.nextLine();
			}
			
			else if(x>4 || x<1) {
				System.out.println("Invalid code, Enter code 1-4:");
				System.out.println();
				menu();
				x = sc.nextInt();
				a = sc.nextLine();
			}
		}
		
		if(x==4) {
			System.out.println("Bye dits-dahs..");
		}
	}
	public static void menu() {
		System.out.println("Menu:");
		System.out.println("	1. Send Morse Message");
		System.out.println("	2. Receive Morse Message");
		System.out.println("	3. Print Letters and Morse Code");
		System.out.println("	4. Exit");
		System.out.println();
		System.out.println("Input code:");
	}
	
	public static int wordcount(String word){  
      int count=0;  
      char character[]= new char[word.length()];     
      for(int i=0;i<word.length();i++){  
    	  character[i]= word.charAt(i);  
    	  if( ((i>0)&&(character[i]!=' ')&&(character[i-1]==' ')) || ((character[0]!=' ')&&(i==0)) )  
    		  count++;  
      }  
      return count;  
    } 
	
	public static int charactercount(String letter) {
		int count1 = 0;
		String character = letter;
		
		for(int i=0;i<character.length();i++) {
			if(character.charAt(i) !=' ')
				count1++;
		}
		return count1;
	}
	
	public static int symbolcount(String letter) {
		int count2 = 0;
		String character = letter;
		
		for(int i=0;i<character.length();i++) {
			if(character.charAt(i) == '.'||character.charAt(i) == ','||character.charAt(i) == ':'||
				character.charAt(i) == '"'||character.charAt(i) == '\''||character.charAt(i) == '!'||
				character.charAt(i) == '?'||character.charAt(i) == '@'||character.charAt(i) == '-'||
				character.charAt(i) == ';'||character.charAt(i) == '('||character.charAt(i) == ')'||
				character.charAt(i) == '=') 
				count2++;
		}
		return count2;
	}
	
	public static int numbercount(String letter) {
		int count3 = 0;
		String character = letter;
		
		for(int i=0;i<character.length();i++) {
			if(Character.isDigit(character.charAt(i))) {
				count3++;
			}
		}
		return count3;
	}
}
