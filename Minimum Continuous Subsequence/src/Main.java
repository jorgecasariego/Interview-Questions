import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
		String[] targetList = {"cat", "dog"};
        String[] availableList = {"cat", "get", "dog", "push", "spain"};
        System.out.println(Arrays.toString(indices)); // should be [0,2]

        String[] targetList1 = {"cat", "dog"};
        String[] availableList1 = {"cat", "get", "cat", "dog", "spain"};
        System.out.println(Arrays.toString(indices)); // should be [2,3]

        String[] targetList2 = {"cat1", "dog1"};
        String[] availableList2 = {"cat", "get", "cat", "dog", "spain"};
        System.out.println(Arrays.toString(indices)); // should be [-1]

        String[] targetList3 = {"cat", "dog"};
        String[] availableList3 = {"cat"};
        System.out.println(Arrays.toString(indices)); // should be [0]

        String[] targetList4 = {"cat", "dog"};
        String[] availableList4 = {"cat1"};
        System.out.println(Arrays.toString(indices)); // should be [-1]

        String[] targetList5 = {"cat1", "dog"};
        String[] availableList5 = {"get", "dog","spain"};
        System.out.println(Arrays.toString(indices)); // should be [1]
 * @author jorgecasariego
 *
 */
public class Main {
	
	static String[] words, tags;

	public static void main(String[] args) {
		String[] targetList = {"cat", "dog"};
        String[] availableList = {"cat", "get", "dog", "push", "spain"};
        // should be [0,2]

        // My solution in amazon interview (NOT Working)
        System.out.println("");
        System.out.println("cat - dog");
        List<String> targetList1 = Arrays.asList("cat", "dog");
        List<String>  availableList1 = Arrays.asList("cat", "get", "cat", "dog", "spain");
        System.out.println(getMinimum2(targetList1, availableList1)); // should be [2,3]
        // should be [2,3]
        
        System.out.println("");
        System.out.println("east - in - south");
        targetList1 = Arrays.asList("east", "in", "south");
        availableList1 = Arrays.asList("east", "test", "east", "in", "east", "get", "spain", "south");
        System.out.print(getMinimum2(targetList1, availableList1));
        
        System.out.println("");
        System.out.println("made - in - spain");
        targetList1 = Arrays.asList("made", "in", "spain");
        availableList1 = Arrays.asList("made", "weather", "forecast", "says", "that", "made", "rain", "in", "spain", "stays");
        System.out.print(getMinimum2(targetList1, availableList1));
        
        /*
        String[] targetListString = {"made", "in", "spain"};
        String[] availableListString = {"made", "weather", "forecast", "says", "that", "made", "rain", "in", "spain", "stays"};
        int[] indices = find(targetListString, availableListString);
        System.out.println(Arrays.toString(indices));
        
        String[] targetListString1 = { "east", "in", "south"};
        String[] availableListString1 = {"east", "test", "east", "in", "east", "get", "spain", "south"};
        indices = find(targetListString1, availableListString1);
        System.out.println(Arrays.toString(indices));

        
        String[] targetList2 = {"cat1", "dog1"};
        String[] availableList2 = {"cat", "get", "cat", "dog", "spain"};
        // should be [-1]

        String[] targetList3 = {"cat", "dog"};
        String[] availableList3 = {"cat"};
        // should be [0]

        String[] targetList4 = {"cat", "dog"};
        String[] availableList4 = {"cat1"};
        // should be [-1]

        String[] targetList5 = {"cat1", "dog"};
        String[] availableList5 = {"get", "dog","spain"};
        // should be [1]
         */
        
        // Solution from StackOverflow
        System.out.println("");
        System.out.println("-----");
        words = new String[] { "east", "in", "south" };
        tags = new String[] { "east", "test", "east", "in", "east", "get", "spain", "south" };
        ArrayList<Integer> ans = minSubSequence();
        for (int i = 0; i < ans.size(); ++i) {
            System.out.print(ans.get(i) + " ");
        }
        
        System.out.println("");
        
        // My new solution
        List<String> targetList2 = Arrays.asList("cat", "dog");
        List<String>  availableList2 = Arrays.asList("cat", "get", "cat", "dog", "spain");
        System.out.println(getMinimum2(targetList2, availableList2)); // should be [2,3]
        // should be [2,3]
        
        System.out.println("");
        // My new solution
        targetList2 = Arrays.asList("east", "in", "south");
        availableList2 = Arrays.asList("east", "test", "east", "in", "east", "get", "spain", "south");
        System.out.println(getMinimum2(targetList2, availableList2));
        // should be [2,7]
	}
	
	// No funciona
	public static int[] getMinimum(List<String> target, List<String> available) {
		
		// Add to the Map
		Map<String, List<Integer>> listMap = new HashMap<>();
		int counter = 0;
		
		// TEST: {"cat", "get", "cat", "dog", "spain"}
		//                                       ^          
		// counter = 4
		// listMap = <{cat,[0,2]}, {get, [1]}, {dog, [3]}, {spain, [4]} >
		// temp = {4}
		
		for(String availableItem: available) {
			if (listMap.containsKey(availableItem)) {
				listMap.get(availableItem).add(counter);
			} else {
				List<Integer> temp = new ArrayList<>();
				temp.add(counter);
				listMap.put(availableItem, temp);
			}
			counter++;
		}
		
		// TEST: target = {"cat", "dog"};
		//                          ^
		// listMap = <{cat,[0,2]}, {get, [1]}, {dog, [3]}, {spain, [4]} >
		//
		// resultList = {2}
		// k = 1
		// count = 0
		// listLength = 1
		// l = [3]
		//      ^
		List<Integer> resultList = new ArrayList<>();
		int k = 0;
		for (String targetItem: target) {
			if (listMap.get(targetItem) == null) {
				break;
			} else {
				int count = 0;
				//int listLength = resultList.size();
				List<Integer> l = listMap.get(targetItem);
				
				while(count < l.size()) {
					int listLength = resultList.size();
					//if you see an element getting inserted which is less that the 
					//last element remove one element from the front
					if (listLength > 0 && l.get(count) < resultList.get(listLength - 1)) {
						resultList.remove(k++);
					}
					
					// Add otherwise
					resultList.add(l.get(count));
					count++;
				}
			}
		}
		
		
		int left = resultList.get(0);
		int right = resultList.get(resultList.size()-1);
		return new int[] {left, right};
	}
	
    
    // Version 2
 	public static ArrayList<Integer> getMinimum2(List<String> target, List<String> available) {
 		
 		// Add to the Map
 		Map<String, ArrayList<Integer>> listMap = new HashMap<>();
 		int counter = 0;
 		
 		// TEST: {"cat", "get", "cat", "dog", "spain"}
 		//                                       ^          
 		// counter = 4
 		// listMap = <{cat,[0,2]}, {get, [1]}, {dog, [3]}, {spain, [4]} >
 		// temp = {4}
 		
 		for(String availableItem: available) {
 			if (listMap.containsKey(availableItem)) {
 				listMap.get(availableItem).add(counter);
 			} else {
 				ArrayList<Integer> temp = new ArrayList<>();
 				temp.add(counter);
 				listMap.put(availableItem, temp);
 			}
 			counter++;
 		}
 		
 		int ans = Integer.MAX_VALUE;
         int s1 = 0, e1 = 0;
         
         // TEST: <{cat,[0,2]}
         ArrayList<Integer> initialTarget = listMap.get(target.get(0));
         
         for (int i = 0; i < initialTarget.size(); ++i) {
             int start = initialTarget.get(i);
             boolean poss = true;
             int next = 0;
             // targets: "cat", {dog, [3]}
             //                   ^
             for (int j = 1; j < target.size(); ++j) {
                 next = getNextGreater(start, listMap.get(target.get(j)));
                 if (next == -1) {
                     poss = false;
                     break;
                 }
             }
             if (poss && ans > next - start) {
                 s1 = start;
                 e1 = next;
                 ans = next - start;
             }

         }
         
         ArrayList<Integer> solu = new ArrayList<Integer>();

         if (ans == Integer.MAX_VALUE) {
             solu.add(0);
             return solu;
         }

         solu.add(s1);
         solu.add(e1);

         return solu;
 	}
 	
 	static int getNextGreater(int x, ArrayList<Integer> arr) {
        int start = 0;
        int end = arr.size() - 1;
        int ans = -1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr.get(mid) <= x) {// go right
                start = mid + 1;
            } else {
                ans = arr.get(mid);
                end = mid;
            }

        }
        if (start == end && arr.get(start) > x)
            return arr.get(start);
        return ans;
    }
 	
 	/**
	 Get the position of each word from TargetList in the AvailableTagsList
	 (Note that they will be sorted) for example if my target list and available list are : 
	 - TargetList = {"east", "in", "south"} 
	 - AvailableTagsList = {"east", "test", "east", "in", "east", "get", "spain", "south"} 
	 
	 So after this step I would have:
	 - east : 0,2,4 
	 - in : 3 
	 - south: 7
	
	 Now: I know that I can have 3 possible start right? 
	 For the first position of my start word p0, can I find a position p1 for word (i+1) 
	 such that p1 > p0 ?? 
	 if yes, can I have a position p2 for word(i+2) such that p2 > p1 and so on till I find 
	 all my target list. 
	 
	 How can I do that ? 
	 If I know position p1 , I need to find the first p2 such that p2 > p1 ? 
	 Can I use binary search to do that ? yes because all the arrays are sorted . So here is the code
	 * @return
	 */
	static ArrayList<Integer> minSubSequence() {
       ArrayList<Integer>[] occur = new ArrayList[words.length];
       for (int i = 0; i < words.length; ++i)
           occur[i] = new ArrayList<Integer>();
       HashMap<String, Integer> indices = new HashMap<String, Integer>();
       for (int i = 0; i < words.length; ++i) {
           indices.put(words[i], i);
       }
       for (int i = 0; i < tags.length; ++i) {
           String tag = tags[i];
           if (indices.containsKey(tag)) {
               int wordI = indices.get(tag);
               occur[wordI].add(i);
           }
       }
       // till now comp is o(n)
       // loop throught all the starts that we have
       int ans = Integer.MAX_VALUE;
       int s1 = 0, e1 = 0;
       for (int i = 0; i < occur[0].size(); ++i) {
           int start = occur[0].get(i);
           boolean poss = true;
           int next = 0;
           for (int j = 1; j < words.length; ++j) {
               next = getNextGreater(start, occur[j]);
               if (next == -1) {
                   poss = false;
                   break;
               }
           }
           if (poss && ans > next - start) {
               s1 = start;
               e1 = next;
               ans = next - start;
           }

       }
       ArrayList<Integer> solu = new ArrayList<Integer>();

       if (ans == Integer.MAX_VALUE) {
           solu.add(0);
           return solu;
       }

       solu.add(s1);
       solu.add(e1);

       return solu;
   }
}
