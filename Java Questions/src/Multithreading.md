1) Can we make array volatile in Java?
This is one of the tricky Java multi-threading questions you will see in senior Java developer Interview. Yes, you can make an array volatile in Java but only the reference which is pointing to an array, not the whole array. What I mean, if one thread changes the reference variable to points to another array, that will provide a volatile guarantee, but if multiple threads are changing individual array elements they won't be having happens before guarantee provided by the volatile modifier.

What is a volatile modifier in Java?

The volatile is a modifier in Java which only applies to member variables, both instance and class variables and both primitive and reference type. It provides the happens-before guarantee which ensures that a write to a volatile variable will happen before any reading. This ensures that any modification to volatile object or primitive type will be visible to all threads i.e. it provides the visibility guarantee.


The volatile modifier also provides ordering guarantee because the compiler cannot re-order any code or operation which involves volatile variables (primitive and objects), but what is perhaps more important to know and remember is that volatile variable doesn't provide atomicity (except for write to the volatile double variable) and mutual exclusion, which is also the main difference between volatile and synchronized keyword.

There are certain restrictions with volatile keyword e.g. you cannot make a member variable both final and volatile at the same time, but you can make a static variable volatile in Java.

If you want to learn more about the volatile variable in Java, I suggest reading Java Concurrency in Practice, which provides more thorough and complete introduction and application of volatile modifier in Java.

2) What is volatile variable in Java and when to use  the volatile variable in Java
The volatile keyword in Java is used as an indicator to Java compiler and Thread that do not cache value of this variable and always read it from main memory. 

So if you want to share any variable in which read and write operation is atomic by implementation e.g. read and write in an int or a boolean variable then  you can declare them as volatile variable.

The Java volatile keyword cannot be used with method or class and it can only be used with a variable. Java volatile keyword also guarantees visibility and ordering

3) What is an immutable object? How do you create an Immutable object in Java?
Immutable objects are those whose state cannot be changed once created. Any modification will result in a new object e.g. String, Integer, and other wrapper class. 