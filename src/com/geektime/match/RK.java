package com.geektime.match;

/**
 * RKÀ„∑®
 * @author Flystar
 *
 */
public class RK {
	
	public static void main(String[] args) {
		System.out.println(rk("baddef", "c"));
//		System.out.println("aaaa".substring(0,2));
	}
	
	public static boolean rk(String main,String com) {
		int comHash = com.hashCode();
		int len1 = main.length();
		int len2 = com.length();
		for(int i = 0 ; i < len1 ;i++){
			String mainSub = main.substring(i, i + len2);
			int mainHash = mainSub.hashCode();
			if (comHash == mainHash && com.equals(mainSub)) {
				return true;
			}
		}
		return false;
	}
}
