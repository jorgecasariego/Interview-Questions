# Fibonacci numbers

The Fibonacci numbers are the numbers in the following integer sequence.

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..

In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation

    Fn = Fn-1 + Fn-2



with seed values

   F0 = 0 and F1 = 1.

# Method 1 ( Use recursion ) 

A simple method that is a direct recursive implementation mathematical recurrence relation given above.

```java
//Fibonacci Series using Recursion
class fibonacci
{
    static int fib(int n)
    {
    if (n <= 1)
       return n;
    return fib(n-1) + fib(n-2);
    }
      
    public static void main (String args[])
    {
    int n = 9;
    System.out.println(fib(n));
    }
}
```

Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
We can observe that this implementation does a lot of repeated work (see the following recursion tree). So this is a bad implementation for nth Fibonacci number.

							fib(5)   
                     /                  
               fib(4)                fib(3)   
             /                      /     
         fib(3)      fib(2)         fib(2)    fib(1)
        /             /           /      
  fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
  /    
fib(1) fib(0)

Extra Space: O(n) if we consider the function call stack size, otherwise O(1).

# Method 2 ( Use Dynamic Programming )

We can avoid the repeated work done is the method 1 by storing the Fibonacci numbers calculated so far.

```java
// Fibonacci Series using Dynamic Programming
class fibonacci
{
   static int fib(int n)
    {
        /* Declare an array to store Fibonacci numbers. */
    int f[] = new int[n+1];
    int i;
      
    /* 0th and 1st number of the series are 0 and 1*/
    f[0] = 0;
    f[1] = 1;
     
    for (i = 2; i <= n; i++)
    {
       /* Add the previous 2 numbers in the series
         and store it */
        f[i] = f[i-1] + f[i-2];
    }
      
    return f[n];
    }
      
    public static void main (String args[])
    {
        int n = 9;
        System.out.println(fib(n));
    }
}

```

Time Complexity: O(n)
Extra Space: O(n)

# Method 3 ( Space Optimized Method 2 )

We can optimize the space used in method 2 by storing the previous two numbers only because that is all we need to get the next Fibonacci number in series.

```java
// Java program for Fibonacci Series using Space
// Optimized Method
class fibonacci
{
    static int fib(int n)
    {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
 
    public static void main (String args[])
    {
        int n = 9;
        System.out.println(fib(n));
    }
}
```

Time Complexity: O(n)
Extra Space: O(1)


![alt text](https://github.com/jorgecasariego/Interview-Questions/blob/master/print-binary-tree/del02.bmp)
