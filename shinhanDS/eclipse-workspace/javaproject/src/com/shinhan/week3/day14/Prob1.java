package com.shinhan.week3.day14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prob1 {
	public static void main(String[] args) {
		String[] array = { "황남기85점", "조성호89점", "한인성88점", "독고정진77점" };
		printMaxScore(array);
	}

	private static void printMaxScore(String[] array) {
		String regExp = "([ㄱ-ㅎ가-힣]+)([0-90]+)점";
		String maxName = "";
		int maxScore = -1;
		for(String data : array) {
//			System.out.println(data);
			Pattern pattern = Pattern.compile(regExp);
			Matcher matcher = pattern.matcher(data);
			if(matcher.find()) {
				String name = matcher.group(1);
				String score = matcher.group(2);
//				System.out.println(name + "===" + score);
				int iscore = Integer.parseInt(score);
				if(maxScore<iscore) {
					maxScore = iscore;
					maxName = name;
				}
			}
		}
		System.out.println(maxName + "===" + maxScore);
	}

	private static void printMaxScore3(String[] array) {
		String maxName = "";
		int maxScore = -1;
		
		for(String data:array) {
			char[] ch = data.toCharArray();
//			System.out.println(Arrays.toString(ch));
			String name = "", score = "";
			for(char chs : ch) {
//				System.out.println(chs + "===" + Character.isDigit(chs));
				if(Character.isDigit(chs)) name += ch;
				else score += ch;
			}
			if(maxScore < Integer.parseInt(score)) {
				maxScore = Integer.parseInt(score);
				maxName = name.substring(0, name.length()-1);
			}
			System.out.println(maxName + "===" + maxScore);
		}
		
	}

	private static void printMaxScore2(String[] array) {
		// 구현하세요.
		String name = "";
		String score = "";
		for(int i=0 ; i<array.length ; i++) {
			if(array[i].length() == 6) {
				name += array[i].substring(0,2);
				score += array[i].substring(3,6);
			}else {
				name += array[i].substring(0,3);
				score += array[i].substring(4,7);
			}
		
		}
		System.out.printf("최고점수는 %s님 %d점 입니다");
	}
}