package com.le.cameldemo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Person implements Serializable {


	private static final long serialVersionUID = 5660716466964971516L;
	private String name;

	private String age;

	private String gender;
}
