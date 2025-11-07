package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "안녕하세요 박준서입니다.";
    }

    @GetMapping("/introduce")
    public String hello2(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "introduce";
    }

    @GetMapping("/json")
    @ResponseBody
    public jsonc getJsonDate(){
        return new jsonc(26, "허준기");
    }

    public static class jsonc{
        private int age;
        private String name;

        public jsonc(int age, String name){
            this.age=age;
            this.name=name;
        }
        public int getAge(){
            return age;
        }
        public String getName(){
            return name;
        }
    }

}