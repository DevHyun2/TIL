package com.shinhan.week3.day10.제네릭;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Applicant<T> {

	private T kind;
}
