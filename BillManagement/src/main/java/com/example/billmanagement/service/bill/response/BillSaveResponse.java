package com.example.billmanagement.service.bill.response;

import com.example.billmanagement.service.bill_detail.request.BillDetailSaveRequest;
import com.example.billmanagement.service.bill_detail.response.BillDetailSaveResponse;
import com.example.billmanagement.service.customer.request.CustomerSaveRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

public class BillSaveResponse {
    private String id;
    @NotBlank
    private String dateBought;
    private @Valid CustomerSaveRequest customer;

    private List<@Valid BillDetailSaveResponse> billDetails;

    public BillSaveResponse() {
        this.billDetails = new ArrayList<>();
        this.billDetails.add(new BillDetailSaveResponse());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<BillDetailSaveResponse> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetailSaveResponse> billDetails) {
        this.billDetails = billDetails;
    }
}
