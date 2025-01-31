package com.example.moduleauthsecurityjava.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.moduleauthsecurityjava.models.PhoneNumberRequest;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneNumberController {
    @PostMapping("/phone-number")
    public ResponseEntity<String> phoneNumberSubmit(@ModelAttribute PhoneNumberRequest request) {
        if(isValidPhoneNumber(request)) {
            System.out.println("\033[96mThe user submitted the phone number: " + request.getPhone() + "\033[0m");
            return ResponseEntity.ok("Successful");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Phone Number");
        }

    }

    private boolean isValidPhoneNumber(PhoneNumberRequest request){
        return !request.getPhone().isEmpty() && request.getPhone().length() >= 10 && request.getPhone().length() <= 11;
    }
}
