package com.crm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hrmanager")
public class HRManagerController {

    @GetMapping("/dashboard")
    public String hrManagerDashboard() {
        return "hrManagerDashboard";
    }
}
