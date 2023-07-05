package com.example.billmanagement.service.bill_detail;

import com.example.billmanagement.repository.BillDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class BillDetailService {
    private BillDetailRepository billDetailRepository;

    public void removeBillDetailByBillId(int billId) {
        billDetailRepository.deleteBillDetailsByBillId(billId);
    }
}
