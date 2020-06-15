package com.leetcode.hash;

public class TwoSum_1 {
	
	public static int[] twoSum(int[] nums, int target) {
		int[] index = new int[2];
		int len= nums.length;
		for(int i = 0; i < len ; i++){
			for(int j = i + 1;j < len ; j++){
				if (nums[i] + nums[j] == target) {
					index[0] = i;
					index[1] = j;
					break;
				}
			}
		}
        return index;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{2, 7, 11, 15};
		int target = 9;
		int[] result = twoSum(nums, target);
		for(int i = 0 ;i < result.length ;i++){
			System.out.println(result[i]);
		}
	}
}
