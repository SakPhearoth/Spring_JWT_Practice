package co.practice.roth.springjwtpractice01.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@SecurityRequirement(name = "bearerAuth")
public class ProductController {

    @GetMapping
    public String getAllProducts(){
        return "Get all products successfully!";
    }
}
