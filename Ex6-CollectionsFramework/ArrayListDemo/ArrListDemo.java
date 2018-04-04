import java.util.*;

class ArrListDemo{
	public static void main(String[] args){
		ArrayList<String> words = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		int n;
		System.out.println("Enter the number of Strings: ");
		n=s.nextInt();
		for(int i=0;i<n;i++){
			System.out.println("Enter String "+i+": ");
			words.add(s.next());
		}
		System.out.println("The elements of the ArrayList are: ");
		System.out.println(words);
		reverse(words);
		System.out.println("The elements of the ArrayList after reverse are: ");
		System.out.println(words);
		capitalizePlurals(words);
		System.out.println("The elements of the ArrayList after Capitalize Plurals are: ");
		System.out.println(words);
		removePlurals(words);
		System.out.println("The elements of the ArrayList after Remove Plurals are: ");
		System.out.println(words);
	}
	
	static void reverse(ArrayList<String> words){
		Collections.reverse(words);
	}
	static void capitalizePlurals(ArrayList<String> words){
		for(int i = 0;i<words.size();i++){
			if((words.get(i)).endsWith("s")){
				words.set(i,(words.get(i)).toUpperCase());
			}
		}
	}
	static void removePlurals(ArrayList<String> words){
		for(int i=0;i<words.size();i++){
			if((words.get(i)).endsWith("s") || (words.get(i)).endsWith("S")){
				words.remove(i);
			}
		}
	}
}