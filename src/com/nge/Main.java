package com.nge;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
	
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		
		if(findNums.length == 0) {
			return new int[0];
		}
		
        //initializing variables
		Map<Integer, Integer> nextGreaterElement = new LinkedHashMap();
		Stack<Integer> stack = new Stack<>();
		
		//creating HashMap for findNums
		for(int num : findNums) {
			nextGreaterElement.put(num, -1);
		}
		
		// finding next greater element
		stack.push(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			while((!stack.isEmpty()) && (num > stack.peek())) {
				nextGreaterElement.put(stack.pop(), num);
			}
			stack.push(num);
		}
		
		// generating the output
		int[] output = new int[findNums.length];
		for (int i = 0; i < findNums.length; i++) {
			int num = findNums[i];
			output[i] = nextGreaterElement.get(num);
		}
		
		return output;
    }

	public static void main(String[] args) {
		//int[] nums1 = new int[] {4,1,2};
		//int[] nums2 = new int[] {1,3,4,2};
		int[] nums1 = new int[] {2,4};
		int[] nums2 = new int[] {1,2,3,4};
		
		Main obj = new Main();
		int[] output = obj.nextGreaterElement(nums1, nums2);
		for(int num : output) {
			System.out.println(num);
		}
	}

}
