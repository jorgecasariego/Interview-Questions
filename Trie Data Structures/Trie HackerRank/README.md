# Tries: Contacts

We're going to make our own Contacts application! The application must perform two types of operations:

    1. add name, where name is a string denoting a contact name. This must store name as a new contact in the application.
    2. find partial, where partial is a string denoting a partial name to search the application for. It must count the number of contacts starting with partial and print the count on a new line.

Given n sequential add and find operations, perform each operation in order.

# Input Format

The first line contains a single integer, , denoting the number of operations to perform. 
Each line  of the  subsequent lines contains an operation in one of the two forms defined above.

# Sample Input

4
add hack
add hackerrank
find hac
find hak

# Sample Output

2
0