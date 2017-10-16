
public class Permutation {

	public static void permute(String text, int l, int r){
		if( l == r){
			System.out.println(text);
		} else {
			for(int i=l; i<=r; i++){
				text = swap(text, l, i);
				permute(text, l+1, r);
				text = swap(text, l, i);
			}
			
		}
	}
	
	public static String swap(String a, int i, int j){
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		
		return String.valueOf(charArray);
	}
	
	public static void main(String[] args){
		String text = "ABC";
		
		permute(text, 0, text.length()-1);
	}
}
