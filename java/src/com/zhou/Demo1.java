package com.zhou;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Demo1 {

	private int V;
	private static String letter = "()";
	public static void main(String[] args) {
		int test = Integer.MAX_VALUE;
		int result = Math.min(10, test);
		System.out.println("result is:" + result);
	}

	private static int charAt(String s, int d) {
		if (d < s.length()) return s.charAt(d);
		return -1;
	}

	//判断两个字符串是否由相同的字符组成
	private static boolean isEqual(String s1, String s2) {
		byte[] b1 = s1.getBytes();
		byte[] b2 = s2.getBytes();
		int[] byteCount = new int[256];
		for (int i = 0; i < 256; i++) {
			byteCount[i] = 0;
		}
		for (int i = 0; i < b1.length; i++) {
			byteCount[b1[i] - '0']++;
		}
		for (int i = 0; i < b2.length; i++) {
			byteCount[b2[i] - '0']--;
		}
		for (int i = 0; i < 256; i++) {
			if (byteCount[i] != 0) {
				return false;
			}
		}
		return true;
	}

	private static int searchInsert(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		int start = low, end = high;
		while (low <= high) {
			int mid = (low + high)/2;
			if (nums[mid] > target) high = mid - 1;
			else if (nums[mid] < target)  low = mid + 1;
			else return mid;
			start = high;
			end = low;
		}
		System.out.println("low is:" + start + " high is:" + end);
		return start;
	}

	public static void nextPermutation(int[] nums) {
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i == 0) {
				Arrays.sort(nums);
				break;
			}
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j]) {
					exch(nums, i, j);
					System.out.println("start nums:" + nums);
					for (int index = 0; index < nums.length; index++) {
						System.out.println(nums[index]);
					}
					selectSort(nums, j+1, nums.length -1 );
					System.out.println("end nums:" + nums);
					for (int index = 0; index < nums.length; index++) {
						System.out.println(nums[index]);
					}
					return;
				}
			}
		}
	}

	private static void selectSort(int[] nums, int start, int end) {
		for (int i = start; i <= end; i++) {
			int min = i;
			for (int j = i + 1; j <= end; j++) {
				if (nums[j] < nums[i]) {
					min = j;
				}
			}
			exch(nums, i, min);
		}
	}

	private static void exch(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}


	private static void combination(Map<Integer, String> map, String digits, ArrayList<Character> temp, List<String> result) {
		if (digits.length() == 0) {
			char[] arr = new char[temp.size()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = temp.get(i);
			}
			result.add(String.valueOf(arr));

			System.out.println(String.valueOf(arr));
			return;
		} else {
			Integer cur = Integer.valueOf(digits.substring(0,1));
			String lettes = map.get(cur);
			for (int i = 0; i < lettes.length(); i++) {
				temp.add(lettes.charAt(i));
				combination(map, digits.substring(1), temp, result);
				temp.remove(temp.size() - 1);//将最后一个元素移除
			}
		}
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s == null) {
			return 0;
		}
		int length = s.length();
		int maxLengthString = 0;
		int tempLength = 0;
		boolean flag = false;//用于判断二层循环是否跳出
		for (int i = 0; i < length && i + tempLength < length ; i = i+tempLength) {
			System.out.println("执行第" + i + "次");
			for (int j = i + 1; j < length; j++) {
				for (int k = i; k < j; k++) {
					if (s.charAt(j) == s.charAt(k)) {
						System.out.println("i is " + i + ". j is: " + j);
						tempLength = j - i;
						if (tempLength > maxLengthString) {
							maxLengthString = tempLength;
						}
						flag = true;
						break;
					}
				}
				if (flag) {
					flag = false;
					break;
				}
			}
		}
		return maxLengthString;
	}


}
