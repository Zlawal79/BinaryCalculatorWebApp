package com.ontariotechu.sofe3980U;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BinaryController {

    @GetMapping("/")
    public String showCalculator() {
        return "calculator";
    }

    @PostMapping("/")
    public String calculate(
            @RequestParam String operand1,
            @RequestParam String operator,
            @RequestParam String operand2,
            Model model) {

        Binary op1 = new Binary(operand1);
        Binary op2 = new Binary(operand2);
        Binary result;

        switch (operator) {
            case "+":
                result = Binary.add(op1, op2);
                break;
            case "*":
                result = Binary.multiply(op1, op2);
                break;
            case "&":
                result = Binary.and(op1, op2);
                break;
            case "|":
                result = Binary.or(op1, op2);
                break;
            default:
                return "error";
        }

        model.addAttribute("result", result.getValue());
        return "result";
    }
}
