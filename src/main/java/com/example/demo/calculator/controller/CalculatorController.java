package com.example.demo.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

@Controller
public class CalculatorController {
	private final CalculatorService calculatorService;

	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@GetMapping("calculator")
	public String calculatorMain() {
		return "calculator.html";
	}

	@PostMapping("calculatorResult")
	public String calculatorResult(@RequestParam("num1") int num1,
			@RequestParam("operation") String operation,
			@RequestParam("num2") int num2, Model model) {
		try {
			int result = calculatorService.calculator(num1, operation, num2);
			model.addAttribute("result", result);
		} catch (ArithmeticException e) {
			model.addAttribute("error", "ゼロ徐算はできません");
		}

		return "calculator.html";
	}
}
