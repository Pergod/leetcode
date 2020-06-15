package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring_2 {
	
	 public static int lengthOfLongestSubstring(String s) {
		 int longest = 0;
		 int index = 0;
		 int len = s.length();
		 // map��key�洢�ַ���value�洢�ַ���λ��
		 Map<Character, Integer> map = new HashMap<Character, Integer>();
		 while (index < len) {
			 // ���֮ǰ�����ڸ��ַ�������map����put
			if (!map.containsKey(s.charAt(index))) {
				map.put(s.charAt(index), index);
				if (map.size() > longest) {
					longest = map.size();
				}
				index ++;
			}else {
				// ����ַ��Ѵ���,�ҳ�ԭ���ַ���λ��
				int start = map.get(s.charAt(index));
				// ��ʱ�ķ��ظ��ַ����ĳ���Ϊ���뵱ǰ�ַ�ƥ���λ��֮��
				int currentLong = index - start - 1;
				if (currentLong > longest) {
					longest = currentLong;
				}
				// ���map
				map.clear();
				// ��ʱ��index��鵽ƥ���ַ�����һ��λ��
				// �����ַ���dvcad,��ʱ������v��λ��
				index = start + 1;
			}
		}
		return longest;
	 }
	 
	 public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
}
