package com.cms.controller;

import com.cms.utility.ApiRespone;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("util")
public class UtilityController {

    @GetMapping("health")
    public ResponseEntity<?> health() {
        return ApiRespone.OK("Working");
    }

}
