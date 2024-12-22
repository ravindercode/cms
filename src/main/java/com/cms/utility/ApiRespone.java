package com.cms.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiRespone {

    public static ResponseEntity<?> OK(Object body) {
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    public static ResponseEntity<?> NOT_FOUND(Object body) {
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<?> INTERNAL_SERVER_ERROR(Object body) {
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<?> BAD_REQUEST(Object body) {
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<?> UNAUTHORIZED(Object body) {
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }
}
