package br.com.thomasdacosta.controller;

import br.com.thomasdacosta.dto.Hello;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<Hello> hello() {
        Hello hello = new Hello();
        hello.setMessage("Hello World!");
        return ResponseEntity.ok(hello);
    }

}
