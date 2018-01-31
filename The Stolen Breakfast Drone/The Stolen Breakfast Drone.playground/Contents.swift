//: Playground - noun: a place where people can play

import UIKit

//************************************************************
//Brute Force
// A brute force approach would use two nested loops to go through every ID and check every other ID to see if there's a duplicate. This would take O(n^2) time and O(1) space. Can we bring that runtime down?

// 1. Well, we know every integer appears twice, except for one integer, which appears once. Can we just track how many times each integer appears?

// We could iterate through the array and store each integer in a dictionary, where the keys are the integers and the values are the number of times we’ve seen that integer so far. At the end, we’d just need to return the integer we saw one time.

func findUniqueDeliveryId(in deliveryIds: [Int]) -> Int? {
    var idsToOcurrences: [Int: Int] = [:]
    var uniqueId: Int? = nil
    
    for deliveryId in deliveryIds {
        if let value = idsToOcurrences[deliveryId] {
            idsToOcurrences[deliveryId] = value + 1
        } else {
            idsToOcurrences[deliveryId] = 1
        }
    }
    
    for (key, value) in idsToOcurrences {
        if value == 1 {
            uniqueId = key
        }
    }
    
    return uniqueId
}

let deliveryIds:[Int] = [1, 2, 3, 4, 5, 4, 3, 2, 1]
findUniqueDeliveryId(in: deliveryIds)


// Result: we got our runtime down to O(n). and O(n) space for our dictionary.
// Well, we could use booleans ↴ as our values, instead of integers. If we see an integer, we'll add it as a key in our dictionary with a boolean value of true. If we see it again, we'll change its value to false. At the end, our non-repeated order ID will be the one integer with a value of true.

// How much space does this save us? Depends how our language stores booleans vs integers. Often booleans take up just as much space as integers.

// And even if each boolean were just 1 bit, that'd still be O(n) space overall.

// So using booleans probably doesn't save us much space here

//************************************************************
// Better way of Resolve: If so, we could start with a variable uniqueDeliveryId set to and run some bitwise operation with that variable and each number in our array. If duplicate integers cancel each other out, then we’d only be left with the unique integer at the end!

func findUniqueDeliveryId2(in deliveryIds: [Int]) -> Int {
    var uniqueDeliveryId = 0
    
    for deliveryId in deliveryIds {
        uniqueDeliveryId ^= deliveryId
    }
    
    return uniqueDeliveryId
}

findUniqueDeliveryId2(in: deliveryIds)

// Complexity O(n) time, and O(1) space!!!!
