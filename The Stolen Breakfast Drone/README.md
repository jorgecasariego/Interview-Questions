# The Stolen Breakfast Drone

### Your company delivers breakfast via autonomous quadcopter drones. And something mysterious has happened.

Each breakfast delivery is assigned a unique ID, a positive integer. When one of the company's 100 drones takes off with a delivery, the delivery's ID is added to an array, deliveryIdConfirmations. When the drone comes back and lands, the ID is again added to the same array.

After breakfast this morning there were only 99 drones on the tarmac. One of the drones never made it back from a delivery. **We suspect a secret agent from Amazon placed an order and stole one of our patented drones.** To track them down, we need to find their delivery ID.

**Given the array of IDs, which contains many duplicate integers and one unique integer, find the unique integer.**

*The IDs are not guaranteed to be sorted or sequential. Orders aren't always fulfilled in the order they were received, and some deliveries get cancelled before takeoff.*

- We can do this in O(n) time.

- No matter how many integers are in our input array, we can always find the unique ID in O(1) space!

## Better Solution

If so, we could start with a variable uniqueDeliveryId set to 0 and run some bitwise operation with that variable and each number in our array. If duplicate integers cancel each other out, then we’d only be left with the unique integer at the end!

### Solution
We XOR ↴ all the integers in the array. We start with a variable uniqueDeliveryId set to 0. Every time we XOR with a new ID, it will change the bits. When we XOR with the same ID again, it will cancel out the earlier change.

> In the end, we'll be left with the ID that appeared once!
> 
> Complexity O(n) time, and O(1) space!!!!






