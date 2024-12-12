package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public int calculator(int num1, String operation, int num2) throws ArithmeticException {
		int result = 0;

		if (operation.equals("+")) {
			result = num1 + num2;
		} else if (operation.equals("-")) {
			result = num1 - num2;
		} else if (operation.equals("×")) {
			result = num1 * num2;
		} else if (operation.equals("÷")) {
			result = num1 / num2;
		}

		return result;
	}

}
