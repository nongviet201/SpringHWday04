package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WebController {
    private List<Integer> numbers = List.of(10, 5, 3, 12, 6, 7, 5, 3);
    public List<Integer> out;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("numbers", numbers);
        return "index";
    }

    @GetMapping("/{id}")
    public String getAnswer(Model model, @PathVariable int id) {
        switch (id) {
            case 2:
                out = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
                break;
            case 3:
                out =  numbers.stream().filter(n -> n > 5).collect(Collectors.toList());
                break;
            case 4:
                out = Collections.singletonList(numbers.stream().max(Integer::compareTo).orElse(0));
                break;
            case 5:
                out = Collections.singletonList(numbers.stream().min(Integer::compareTo).orElse(0));
                break;
            case 6:
                out = Collections.singletonList(numbers.stream().mapToInt(Integer::intValue).sum());
                break;
            case 7:
                out = numbers.stream().distinct().collect(Collectors.toList());
                break;
            case 8:
                out =  numbers.stream().limit(5).collect(Collectors.toList());
                break;
            case 9:
                out =  numbers.stream().skip(2).limit(3).collect(Collectors.toList());
                break;
            case 10:
                out =  numbers.stream().filter(n -> n > 5).findFirst().stream().collect(Collectors.toList());
                break;
            default:
                Collections.emptyList();
                break;
        }
        model.addAttribute("out", out);

        // Chuyển hướng đến view hiển thị kết quả
        return "result";
    }
}

