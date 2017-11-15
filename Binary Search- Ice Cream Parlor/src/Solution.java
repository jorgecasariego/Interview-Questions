import java.util.Arrays;

public class Solution {

	// flavors: 1 4 5 3 2
    // value = 1    index = 0
    // value = 2    index = 4
    public static int indexByValue(int[] flavors, int value, int differentToThis) {
        for(int i = 0; i < flavors.length; i++){
            if(flavors[i] == value && i != differentToThis){
                return i;
            }
        }
        
        return -1;
    }
    
    // firstPosition = 0    - secondPosition = 2
    public static int[] findIndexs(int[] orderedFlavors, int[] flavors, int firstPosition, int secondPosition) {
        int[] realIndexs = new int[2];
        int index1 = indexByValue(flavors, orderedFlavors[firstPosition], -1);
        int index2 = indexByValue(flavors, orderedFlavors[secondPosition], index1);
        
        realIndexs[0] = Math.min(index1, index2) + 1;
        realIndexs[1] = Math.max(index1, index2) + 1;
        
        return realIndexs;
    }
    
    // TEST
    // Flovors: 1 4 5 3 2
    // Money:   4
    // 1) order
    // 1 2 3 4 5
    // ^            
    // i = 0    - complement = 3    - position = 2
    public static int[] findNumbers(int[] flavors, int money) {
        // I need to create a copy of flavors and then order
        int[] orderedFlavors = flavors.clone();
        Arrays.sort(orderedFlavors);
        
        int[] indexs = new int[2];
        
        for(int i = 0; i < orderedFlavors.length; i++) {
            int complement = money - orderedFlavors[i]; 
            int position = Arrays.binarySearch(orderedFlavors, i + 1, orderedFlavors.length, complement);   // 2 3 4 5
            
            if(position >= 0 && position < orderedFlavors.length && orderedFlavors[position] == complement) {
                indexs = findIndexs(orderedFlavors, flavors, i, position);
            }
        }
        
        return indexs;

    }
    

    public static void main(String[] args) {
    	int[] flavors = {1, 4, 5, 3, 2};
    	int money = 4;
    	
    	int[] ids = findNumbers(flavors, money);
    	
        System.out.println(ids[0] + " " + ids[1]);
    }
}
