package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@RestController
public class BadOrGood {

   private final boolean bool = new Random().nextBoolean();

    @GetMapping ("/random")
    public ResponseEntity <String> index(){

        if (bool){
            return ResponseEntity.ok("Sei etero");
        }
        return ResponseEntity.badRequest().body("Sei gay");

    }

}
