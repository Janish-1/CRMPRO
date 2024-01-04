package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sales-data")
public class SalesDataController {

    @Autowired
    private SalesDataService salesDataService;

    @GetMapping
    public List<SalesData> getAllSalesData() {
        return salesDataService.getAllSalesData();
    }

    @GetMapping("/{salesId}")
    public Optional<SalesData> getSalesDataById(@PathVariable long salesId) {
        return salesDataService.getSalesDataById(salesId);
    }

    @PostMapping
    public SalesData createSalesData(@RequestBody SalesData salesData) {
        return salesDataService.createSalesData(salesData);
    }

    @PutMapping("/{salesId}")
    public SalesData updateSalesData(@PathVariable long salesId, @RequestBody SalesData updatedSalesData) {
        return salesDataService.updateSalesData(salesId, updatedSalesData);
    }

    @DeleteMapping("/{salesId}")
    public void deleteSalesData(@PathVariable long salesId) {
        salesDataService.deleteSalesData(salesId);
    }
}

