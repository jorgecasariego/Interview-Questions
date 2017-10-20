# The Trie Data Structure

Implementing the contains() method requires a backing data structure that lets you find
elements efficiently, while isPrefix() method requires us to find the "next greater
element", i.e. we need to keep the vocabulary sorted in some way.

We can easily exclude hash-based sets from our list of candidates: while such a structure
would give us constant-time checking for contains(), it would perform quite poorly on 
isPrefix(), in the worst case requiring that we scan the whole set.

For quite the opposite reason, we can also exclude sorted linked-list, as they require
scanning the list at least up to the first element that is greater than or equal to the
searched word or prefix.

Two valid options are using a sorted array-backed list or a binary tree.

On the sorted array-backed list we can use a binary search to find the current sequence
if present or the next greater element at a cost of O(log2(n)), where n is the number
of words in the dictionary.

We can implement an array-backed vocabulary that always maintains ordering like @ListVocabulary
using standard java.util.ArrayList and java.util.Collections.binarySearch