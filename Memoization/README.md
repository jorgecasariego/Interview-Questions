Memoization

Memoization ensures that a function doesn't run for the same inputs more than once by keeping a record of the results for the given inputs (usually in a hash map).

We can imagine the recursive calls of this function as a tree, where the two children of a node are the two recursive calls it makes. We can see that the tree quickly branches out of control:

![alt text](https://github.com/jorgecasariego/Interview-Questions/blob/master/Memoization/fibonacci__binary_tree_recursive.svg)

To avoid the duplicate work caused by the branching, we can wrap the function in a class that stores an instance variable, memo, that maps inputs to outputs. Then we simply:

1. Check memo to see if we can avoid computing the answer for any given input, and
2. Save the results of any calculations to memo.

Now in our recurrence tree, no node appears more than twice:

![alt text](https://github.com/jorgecasariego/Interview-Questions/blob/master/Memoization/fibonacci__binary_tree_memoized.svg)


Memoization is a common strategy for dynamic programming problems, which are problems where the solution is composed of solutions to the same problem with smaller inputs (as with the Fibonacci problem, above). The other common strategy for dynamic programming problems is going bottom-up, which is usually cleaner and often more efficient.
