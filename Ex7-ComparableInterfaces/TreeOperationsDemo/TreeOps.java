import java.util.*;

public class TreeOps{
	static TreeSet<String> reverse(TreeSet<String> a){
		TreeSet<String> set = new TreeSet<String>();
		for(Iterator<String> i = a.iterator(); i.hasNext();){
			String temp = i.next();
			char[] tmp = temp.toCharArray();
			for(int j = 0; j < (temp.length()/2); j++){
				char tch = tmp[j];
				tmp[j] = tmp[temp.length() - 1 - j];
				tmp[temp.length() - 1 - j] = tch;
			}
			set.add(new String(tmp));
		}
		return set;
	}
	static TreeSet<String> removePlurals(TreeSet<String> a){
		TreeSet<String> set = new TreeSet<String>();
		for(Iterator<String> i = a.iterator(); i.hasNext();){
			String temp = i.next();
			if(!temp.toLowerCase().endsWith("s")){
				set.add(temp);
			}
		}
		return set;
	}
	static TreeSet<String> capitalizePlurals(TreeSet<String> a){
		TreeSet<String> set = new TreeSet<String>();
		for(Iterator<String> i = a.iterator(); i.hasNext();){
			String temp = i.next();
			if(temp.endsWith("s")){
				temp = temp.toUpperCase();
			}
			set.add(temp);
		}
		return set;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		TreeSet<String> set = new TreeSet<String>();
		for(int i = 0; i < 5; i++){
			set.add(in.next());
		}
		System.out.println("Processes :\n");
		System.out.println("Reverse :");
		System.out.println(reverse(set));
		System.out.println("Remove Plurals :");
		System.out.println(removePlurals(set));
		System.out.println("Capitalize Plurals :");
		System.out.println(capitalizePlurals(set));
		System.out.println("\nSet :");
		System.out.println(set);
	}
}
