package com.crm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/salesmanager")
public class SalesManagerController {

    @GetMapping("/dashboard")
    public String salesManagerDashboard() {
        return "salesManagerDashboard";
    }
}

