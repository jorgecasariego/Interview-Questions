Merge Sort

The Mergesort algorithm can be used to sort a collection of objects. Mergesort is a so called divide and conquer algorithm. Divide and conquer algorithms divide the original data into smaller sets of data to solve the problem.

During the Mergesort process the objects of the collection are divided into two collections. To split a collection, Mergesort will take the middle of the collection and split the collection into its left and its right part.

The resulting collections are again recursively sorted via the Mergesort algorithm.

Once the sorting process of the two collections is finished, the result of the two collections is combined. To combine both collections Mergesort starts in each collection at the beginning. It picks the object which is smaller and inserts this object into the new collection. For this collection it now selects the next elements and selects the smaller element from both collections.

Once all elements from both collections have been inserted in the new collection, Mergesort has successfully sorted the collection.

To avoid the creation of too many collections, typically one new collection is created and the left and right side are treated as different collections.



![alt text](https://github.com/jorgecasariego/Interview-Questions/blob/master/print-binary-tree/Merge-Sort-Tutorial.jpg)



Time Complexity:
Time complexity of Merge Sort is O(nLogn) in all 3 cases (worst, average and best) as merge sort always divides the array in two halves and take linear time to merge two halves.

Auxiliary Space: O(n)

Algorithmic Paradigm: Divide and Conquer

Sorting In Place: No in a typical implementation

Stable: Yes



