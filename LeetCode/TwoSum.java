import java.util.HashMap;
import java.util.Map;

class Solution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			int remainder = target - nums[i];
			if (map.containsKey(remainder)) {
				return new int[] { map.get(remainder), i };
			} else {
				map.put(nums[i], i);
			}
		}

		throw new IllegalArgumentException("No solution");
	}
}


//Leet Code Question 1

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].


*/