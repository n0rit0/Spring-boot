package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public double calculate(double num1, double num2, String operator) {
		switch (operator) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		case "/":
			if (num2 == 0) {
				throw new ArithmeticException("ゼロ除算はできません");
			}
			return num1 / num2;
		default:
			return 0;
		}
	}
}
