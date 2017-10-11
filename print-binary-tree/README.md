Given a binary tree, print all root-to-leaf paths

For the below example tree, all root-to-leaf paths are: 
10 –> 8 –> 3
10 –> 8 –> 5
10 –> 2 –> 2

![alt text](https://github.com/jorgecasariego/Interview-Questions/blob/master/print-binary-tree/tree.gif)

Tree terminology:

 - The depth of a node is the number of edges from the root to the node.
 - The height of a node is the number of edges from the node to the deepest leaf.
 - The height of a tree is a height of the root.
 - A full binary tree.is a binary tree in which each node has exactly zero or two children.
 - A complete binary tree is a binary tree, which is completely filled, with the possible exception of the bottom level, which is filled from left to right.

 ![alt text](https://github.com/jorgecasariego/Interview-Questions/blob/master/print-binary-tree/full_complete.bmp)

 A complete binary tree is very special tree, it provides the best possible ratio between the number of nodes and the height. The height h of a complete binary tree with N nodes is at most O(log N). We can easily prove this by counting nodes on each level, starting with the root, assuming that each level has the maximum number of nodes:

  ![alt text](https://github.com/jorgecasariego/Interview-Questions/blob/master/print-binary-tree/number_nodes.png)

Solving this with respect to h, we obtain

 > h = O(log n)

 Advantages of trees

 Trees are so useful and frequently used, because they have some very serious advantages:

 - Trees reflect structural relationships in the data
 - Trees are used to represent hierarchies
 - Trees provide an efficient insertion and searching
 - Trees are very flexible data, allowing to move subtrees around with minumum effort

 Traversals

A traversal is a process that visits all the nodes in the tree. Since a tree is a nonlinear data structure, there is no unique traversal. We will consider several traversal algorithms with we group in the following two kinds

 - depth-first traversal
 - breadth-first traversal

 There are three different types of depth-first traversals, :

 - PreOrder traversal - visit the parent first and then left and right children;
 - InOrder traversal - visit the left child, then the parent and the right child;
 - PostOrder traversal - visit left child, then the right child and then the parent;

There is only one kind of breadth-first traversal--the level order traversal. This traversal visits nodes by levels from top to bottom and from left to right.

![alt text](https://github.com/jorgecasariego/Interview-Questions/blob/master/print-binary-tree/tree1.bmp)

As an example consider the following tree and its four traversals: 

 - PreOrder - 8, 5, 9, 7, 1, 12, 2, 4, 11, 3 
 - InOrder - 9, 5, 1, 7, 2, 12, 8, 4, 3, 11 
 - PostOrder - 9, 1, 2, 12, 7, 5, 3, 11, 4, 8 
 - LevelOrder - 8, 5, 4, 9, 7, 11, 1, 12, 3, 2

 Binary Search Trees

We consider a particular kind of a binary tree called a Binary Search Tree (BST). The basic idea behind this data structure is to have such a storing repository that provides the efficient way of data sorting, searching and retriving.

A BST is a binary tree where nodes are ordered in the following way:
 - each node contains one key (also known as data)
- the keys in the left subtree are less then the key in its parent node, in short L < P;
- the keys in the right subtree are greater the key in its parent node, in short P < R;
- duplicate keys are not allowed.

In the following tree all nodes in the left subtree of 10 have keys < 10 while all nodes in the right subtree > 10. Because both the left and right subtrees of a BST are again search trees; the above definition is recursively applied to all internal nodes:

![alt text](https://github.com/jorgecasariego/Interview-Questions/blob/master/print-binary-tree/pix03.bmp)

Insertion

The insertion procedure is quite similar to searching. We start at the root and recursively go down the tree searching for a location in a BST to insert a new node. If the element to be inserted is already in the tree, we are done (we do not insert duplicates). The new node will always replace a NULL reference.


![alt text](https://github.com/jorgecasariego/Interview-Questions/blob/master/print-binary-tree/insert.bmp)

Deletion

Deletion is somewhat more tricky than insertion. There are several cases to consider. A node to be deleted (let us call it as toDelete)

 - is not in a tree;
- is a leaf;
- has only one child;
- has two children.

If toDelete is not in the tree, there is nothing to delete. If toDelete node has only one child the procedure of deletion is identical to deleting a node from a linked list - we just bypass that node being deleted

![alt text](https://github.com/jorgecasariego/Interview-Questions/blob/master/print-binary-tree/del01.bmp)

Deletion of an internal node with two children is less straightforward. If we delete such a node, we split a tree into two subtrees and therefore, some children of the internal node won't be accessible after deletion. In the picture below we delete 8:

![alt text](https://github.com/jorgecasariego/Interview-Questions/blob/master/print-binary-tree/del02.bmp)

Deletion starategy is the following: replace the node being deleted with the largest node in the left subtree and then delete that largest node. By symmetry, the node being deleted can be swapped with the smallest node is the right subtree.







