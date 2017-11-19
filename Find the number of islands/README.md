# Find the number of islands

Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 5 islands

```
Input : 		  {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1} 
Output : 5
```

This is an variation of the standard problem: “Counting number of connected components in a undirected graph”.

Before we go to the problem, let us understand what is a connected component. A connected component of an undirected graph is a subgraph in which every two vertices are connected to each other by a path(s), and which is connected to no other vertices outside the subgraph.

A graph where all vertices are connected with each other, has exactly one connected component, consisting of the whole graph. Such graph with only one connected component is called as **Strongly Connected Graph.**

The problem can be easily solved by applying **DFS()** on each component. In each DFS() call, a component or a sub-graph is visited. We will call DFS on the next un-visited component. The number of calls to DFS() gives the number of connected components. **BFS** can also be used.

/*
 * 
 * What is an island?
 * ******************
 * A group of connected 1s forms an island. For example, the below matrix contains 5 islands
 * 
 *			{1, 1,   0,   0, 0},
 *          {0, 1,   0,   0, 1},
 *          	   \ ^ /
 *          {1, 0, < 0 >, 1, 1},
 *          	   / ˅ \
 *          {0, 0,   0,   0, 0},
 *          {1, 0,   1,   0, 1}
 * 
 * 	What we know?
 *  **************
 *  - A cell in 2D matrix can be connected to 8 neighbors.
 *  - In DFS we call recursively all adjacent vertices
 *  - In this example, we have 8 neighbors
 *  	=> So, unlike standard DFS(), where we recursively call for
 *  		adjacent vertices, here we can recursive call for 8 
 *  		neighbors only.
 *  	=> We keep track of the visited 1s so that they are not visited
 *  		again. 
 * 
 */