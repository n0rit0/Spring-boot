package com.example.demo.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.calculator.service.CalculatorService;

@Controller
public class CalculatorController {

	@Autowired
	private CalculatorService calculatorService;

	@GetMapping("/calculate")
	public String showCalculator() {
		return "calculator";
	}

	@PostMapping("/calculate")
	public String calculate(double num1, double num2, String operator, Model model) {
		try {
			double result = calculatorService.calculate(num1, num2, operator);

			String formattedResult;
			if (result == Math.floor(result)) {
				formattedResult = String.valueOf((int) result);
			} else {
				formattedResult = String.valueOf(result);
			}

			model.addAttribute("result", formattedResult);
		} catch (ArithmeticException e) {
			model.addAttribute("error", e.getMessage());
		}
		return "calculator";
	}
}
