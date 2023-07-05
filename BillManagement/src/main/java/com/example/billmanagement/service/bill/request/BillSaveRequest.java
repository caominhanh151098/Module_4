package com.example.billmanagement.service.bill.request;

import com.example.billmanagement.service.bill_detail.request.BillDetailSaveRequest;
import com.example.billmanagement.service.customer.request.CustomerSaveRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

public class BillSaveRequest {
    @NotBlank
    private String dateBought;
    private @Valid CustomerSaveRequest customer;

    private List<@Valid BillDetailSaveRequest> billDetails;

    public BillSaveRequest() {
        this.billDetails = new ArrayList<>();
        this.billDetails.add(new BillDetailSaveRequest());
    }

    public String getDateBought() {
        return dateBought;
    }

    public void setDateBought(String dateBought) {
        this.dateBought = dateBought;
    }

    public CustomerSaveRequest getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerSaveRequest customer) {
        this.customer = customer;
    }

    public List<BillDetailSaveRequest> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetailSaveRequest> billDetails) {
        this.billDetails = billDetails;
    }
}
