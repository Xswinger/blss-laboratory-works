package com.github.Xswinger.blsslaboratorywork1.controllers;

import io.swagger.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.Xswinger.blsslaboratorywork1.security.service.UserService;

@RestController
@RequestMapping("/demo")
public class DemonstrationController {
    private final UserService service;

    public DemonstrationController(UserService service) {
        this.service = service;
    }

    @GetMapping("/get-admin")
    @Operation(summary = "Получить роль ADMIN (для демонстрации)")
    public void getAdmin() {
        service.getAdmin();
    }
}
