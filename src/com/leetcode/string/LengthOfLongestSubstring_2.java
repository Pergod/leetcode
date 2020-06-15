package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring_2 {
	
	 public static int lengthOfLongestSubstring(String s) {
		 int longest = 0;
		 int index = 0;
		 int len = s.length();
		 // map的key存储字符，value存储字符的位置
		 Map<Character, Integer> map = new HashMap<Character, Integer>();
		 while (index < len) {
			 // 如果之前不存在该字符，则往map里面put
			if (!map.containsKey(s.charAt(index))) {
				map.put(s.charAt(index), index);
				if (map.size() > longest) {
					longest = map.size();
				}
				index ++;
			}else {
				// 如果字符已存在,找出原先字符的位置
				int start = map.get(s.charAt(index));
				// 此时的非重复字符串的长度为，与当前字符匹配的位置之差
				int currentLong = index - start - 1;
				if (currentLong > longest) {
					longest = currentLong;
				}
				// 清空map
				map.clear();
				// 此时的index需归到匹配字符的下一个位置
				// 例如字符串dvcad,此时需跳到v的位置
				index = start + 1;
			}
		}
		return longest;
	 }
	 
	 public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
}
