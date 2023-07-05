package com.example.billmanagement.repository;

import com.example.billmanagement.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Integer> {
    void deleteBillDetailsByBillId(int bill_id);

    List<BillDetail> findBillDetailByBill_Id(int bill_id);
}
