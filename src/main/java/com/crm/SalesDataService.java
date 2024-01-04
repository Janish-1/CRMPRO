package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesDataService {

    @Autowired
    private SalesDataRepo salesDataRepository;

    public List<SalesData> getAllSalesData() {
        return salesDataRepository.findAll();
    }

    public Optional<SalesData> getSalesDataById(long salesId) {
        return salesDataRepository.findById(salesId);
    }

    public SalesData createSalesData(SalesData salesData) {
        // In a real application, you might add validation or other business logic
        return salesDataRepository.save(salesData);
    }

    public SalesData updateSalesData(long salesId, SalesData updatedSalesData) {
        Optional<SalesData> optionalSalesData = salesDataRepository.findById(salesId);
        if (optionalSalesData.isPresent()) {
            SalesData salesData = optionalSalesData.get();
            salesData.setSalesDate(updatedSalesData.getSalesDate());
            salesData.setCustomerId(updatedSalesData.getCustomerId());
            salesData.setServiceName(updatedSalesData.getServiceName());
            salesData.setAmount(updatedSalesData.getAmount());
            return salesDataRepository.save(salesData);
        }
        return null; // Handle not found scenario
    }

    public void deleteSalesData(long salesId) {
        salesDataRepository.deleteById(salesId);
    }
}

