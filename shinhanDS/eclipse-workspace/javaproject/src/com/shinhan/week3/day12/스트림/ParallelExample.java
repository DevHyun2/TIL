package com.shinhan.week3.day12.스트림;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ParallelExample {
	public static void main(String[] args) {
		Random random = new Random();

		List<Integer> scores = new ArrayList<>();
		for (int i = 0; i < 100000000; i++) {
			scores.add(random.nextInt(101));
		}

		double avg = 0.0;
		long startTime = 0;
		long endTime = 0;
		long time = 0;

		Stream<Integer> stream = scores.stream();
		startTime = System.nanoTime();
		avg = stream.mapToInt(i -> i.intValue()).average().getAsDouble();
		endTime = System.nanoTime();
		
		time = endTime - startTime; //두개의 시간 차이
		System.out.println("avg: " + avg + ", 일반 스트림 처리 시간: " + time + "ns");

		int a = Runtime.getRuntime().availableProcessors();
		System.out.println("물리아님, 하이퍼쓰레딩(코어수) 코어2배:" + a);

		Stream<Integer> parallelStream = scores.parallelStream();
		startTime = System.nanoTime();
		avg = parallelStream.mapToInt(i -> i.intValue()).average().getAsDouble();
		endTime = System.nanoTime();
		
		time = endTime - startTime; //두개의 시간 차이
		System.out.println("avg: " + avg + ", 병렬 스트림 처리 시간: " + time + "ns");
	}
}