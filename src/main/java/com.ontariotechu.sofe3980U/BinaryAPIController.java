package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BinaryAPIController {

    @GetMapping("/add")
    public String add(@RequestParam String operand1, @RequestParam String operand2) {
        Binary op1 = new Binary(operand1);
        Binary op2 = new Binary(operand2);
        Binary result = Binary.add(op1, op2);
        return result.getValue();
    }

    @GetMapping("/add_json")
    public BinaryAPIResult addJson(@RequestParam String operand1, @RequestParam String operand2) {
        Binary op1 = new Binary(operand1);
        Binary op2 = new Binary(operand2);
        Binary result = Binary.add(op1, op2);
        return new BinaryAPIResult(op1.getValue(), op2.getValue(), result.getValue());
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam String operand1, @RequestParam String operand2) {
        Binary op1 = new Binary(operand1);
        Binary op2 = new Binary(operand2);
        Binary result = Binary.multiply(op1, op2);
        return result.getValue();
    }

    @GetMapping("/and")
    public String and(@RequestParam String operand1, @RequestParam String operand2) {
        Binary op1 = new Binary(operand1);
        Binary op2 = new Binary(operand2);
        Binary result = Binary.and(op1, op2);
        return result.getValue();
    }

    @GetMapping("/or")
    public String or(@RequestParam String operand1, @RequestParam String operand2) {
        Binary op1 = new Binary(operand1);
        Binary op2 = new Binary(operand2);
        Binary result = Binary.or(op1, op2);
        return result.getValue();
    }
}
