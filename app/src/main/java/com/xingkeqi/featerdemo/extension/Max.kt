package com.xingkeqi.featerdemo.extension


fun max(vararg nums: Int): Int {
    var maxNum = Int.MIN_VALUE
    for (num in nums) {
        maxNum = kotlin.math.max(maxNum, num)
    }
    return maxNum
}

fun <T : Comparable<T>> max(vararg nums: T): T {
    if (nums.isEmpty()) throw RuntimeException("Params can not be empty!!")
    var maxNum = nums[0]
    for (num in nums) if (num > maxNum) maxNum = num
    return maxNum
}
