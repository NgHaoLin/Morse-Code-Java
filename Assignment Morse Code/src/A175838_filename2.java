public class A175838_filename2 extends A175838_filename3{
	public A175838_filename2() {
		super();
	}
	
	public String search(String morsecode) {
		super.insert();
		Node a = root;
		boolean exists = true;
		
		while(a!=null) {
			for(int i=0;(i<morsecode.length() && exists);i++) {
				if(morsecode.substring(i, i+1).equals(".")) {
					if(a.left == null) {
						exists =  false;
					}
					a = a.left;
				}
				else if(morsecode.substring(i, i+1).equals("-")) {
					if(a.right == null) {
						exists =  false;
					}
					a = a.right;
				}
			}
			if(exists) {
				if(a.key==null) {
					return " ";
				}
				else {
					return a.key;
				}
			}
		}
		return null;
	}
	
	
	public String inputSearch(String morsecode) {
		String anscode ="";
		String ans="";
		String passage = morsecode;
		String delims = " ";
		String [] words = passage.split(delims);
		
		for(String str:words) {
			ans = search(str);
			anscode +=ans;
		}
		return anscode;
	}
}