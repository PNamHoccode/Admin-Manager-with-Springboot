package com.project.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    
    @GetMapping("/403")
    public String error403() {
        return "403"; // Trả về tên file 403.html
    }
}