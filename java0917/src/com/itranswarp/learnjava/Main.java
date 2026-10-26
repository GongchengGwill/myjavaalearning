package com.itranswarp.learnjava;

import java.util.logging.Logger;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

public class Main {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Main.class.getName());
		logger.info("Start process...");
		try {
			"".getBytes("invalidCharsetName");
		} catch (UnsupportedEncodingException e) {
			// TODO: 使用logger.severe()打印异常
			logger.severe(e.getMessage());
		}
		logger.info("Process end.");
	}

//	class Solution {
//		public int maxArea(int[] height) {
//			int left = 0, right = height.length - 1;
//			int ans = 0;
//			while(right > left){
//				ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
//				if(height[left] <= height[right]){
//					left++;
//				}else{
//					right--;
//				}
//			}
//			return ans;
//		}
//	}


//	public void moveZeroes(int[] nums) {
//		int first = 0;
//		int second = 0;
//		while(first < nums.length){
//			if(nums[first] != 0){
//				nums[second] = nums[first];
//				second++;
//			}
//			first++;
//		}
//		while(second < nums.length){
//			nums[second] = 0;
//			second++;
//		}
//	}

}

