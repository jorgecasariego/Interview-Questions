Some examples

public static void printFirstItem(int[] items) {
    System.out.println(items[0]);
}

This method runs in O(1)
O(1) time (or "constant time") relative to its input. The input array could be 1 item or 1,000 items, but this method would still just require one "step."

public static void printAllItems(int[] items) {
	for (int item : items) {
	    System.out.println(item);
	}
}

This method runs in O(n)
O(n) time (or "linear time"), where n is the number of items in the array. If the array has 10 items, we have to print 10 times. If it has 1,000 items, we have to print 1,000 times.

public static void printAllPossibleOrderedPairs(int[] items) {
    for (int firstItem : items) {
        for (int secondItem : items) {
            System.out.println(firstItem + ", " + secondItem);
        }
    }
}

Here we're nesting two loops. If our array has n items, our outer loop runs n times and our inner loop runs n times for each iteration of the outer loop, giving us n2 total prints. Thus this method runs in 
O(n2) time (or "quadratic time"). If the array has 10 items, we have to print 100 times. If it has 1,000 items, we have to print 1,000,000 times.