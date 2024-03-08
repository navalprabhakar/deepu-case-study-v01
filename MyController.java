package com.example.deepucasestudyv01;

import com.example.deepucasestudyv01.casemilestones.CaseMilestones;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class MyController {

    @GetMapping("/hello")
    public ResponseEntity<Object> hello() {
        return ResponseEntity.accepted().body("hello");
    }

    @GetMapping("/input")
    public ResponseEntity<Object> input() throws JsonProcessingException {
        CaseMilestones cm = new CaseMilestones();
        String data = new String(new ObjectMapper().writeValueAsBytes(cm));
        log.info(data);
        return ResponseEntity.accepted().body(data);
    }

}

