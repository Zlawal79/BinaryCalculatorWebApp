package com.ontariotechu.sofe3980U; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.RestController; 
@RestController 
public class HelloAPIController { 
@GetMapping("/helloAPI") 
public String helloAPI(@RequestParam(name="name", required=false, defaultValue="World") String name) { 
return "Hello " + name + "!"; 
} 
} 
