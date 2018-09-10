package com.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @RequestMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String addNum(
            @PathVariable int num1,
            @PathVariable int num2
    ) {
        String message = "";
        message += "The 2 numbers added together is: " + (num1 + num2);
        return message;

    }

    @RequestMapping ("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtractNum(
            @PathVariable int num1,
            @PathVariable int num2
    ) {
        String message = "";
        message += "The 2 numbers subtracted from each other is: " + (num2 - num1);
        return message;

    }

    @GetMapping ("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiplyNum(
            @PathVariable int num1,
            @PathVariable int num2
    ) {
        String message = "";
        message += "The 2 numbers multiplied by each other is: " + (num1 * num2);
        return message;

    }

    @GetMapping ("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divideNum(
            @PathVariable int num1,
            @PathVariable int num2
    ) {
        String message = "";
        message += num1 + " divided by " + num2 + " is: " + (num1 / num2);
        return message;

    }
}
