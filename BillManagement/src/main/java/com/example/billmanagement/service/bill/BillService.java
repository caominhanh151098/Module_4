package com.example.billmanagement.service.bill;

import com.example.billmanagement.model.Bill;
import com.example.billmanagement.model.BillDetail;
import com.example.billmanagement.model.Customer;
import com.example.billmanagement.model.Product;
import com.example.billmanagement.repository.BillDetailRepository;
import com.example.billmanagement.repository.BillRepository;
import com.example.billmanagement.repository.CustomerRepository;
import com.example.billmanagement.repository.ProductRepository;
import com.example.billmanagement.service.bill.request.BillSaveRequest;
import com.example.billmanagement.service.bill.response.BillSaveResponse;
import com.example.billmanagement.service.bill.response.ProductSaveBillResponse;
import com.example.billmanagement.service.bill.response.ShowBillResponse;
import com.example.billmanagement.util.AppUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService {
    private final BillDetailRepository billDetailRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final BillRepository billRepository;

    public BillService(BillDetailRepository billDetailRepository, CustomerRepository customerRepository, ProductRepository productRepository, BillRepository billRepository) {
        this.billDetailRepository = billDetailRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.billRepository = billRepository;
    }

    public void createBill(BillSaveRequest billRequest) {
        Bill bill = AppUtils.mapper.map(billRequest, Bill.class);
        BigDecimal totalPriceBill = BigDecimal.valueOf(0);
        for (BillDetail billDetail : bill.getBillDetails()) {
            Product product = productRepository.findAllById(billDetail.getProduct().getId());
            billDetail.setProduct(product);
            billDetail.setNameProduct(product.getNameProduct());
            billDetail.setPrice(product.getPrice());
            BigDecimal totalPrice = billDetail.getPrice().multiply(new BigDecimal(String.valueOf(billDetail.getQuantity())));
            totalPriceBill = totalPriceBill.add(totalPrice);
            billDetail.setBill(bill);
        }
        bill.setTotalPrice(totalPriceBill);
        bill.setCustomer(checkCustomer(bill.getCustomer()));
        billRepository.save(bill);
    }

    public Customer checkCustomer(Customer customer) {
        Customer findCustomer = customerRepository.findByPhone(customer.getPhone());
        if (findCustomer != null) {
            customer.setId(findCustomer.getId());
        }
        return customerRepository.save(customer);
    }

    public BillSaveResponse getBillById(int id) {
        Bill bill = billRepository.findAllById(id);
        return AppUtils.mapper.map(bill, BillSaveResponse.class);
    }

    public void editBill(BillSaveResponse billRequest) {
        Bill bill = AppUtils.mapper.map(billRequest, Bill.class);
        billDetailRepository.deleteAll(billDetailRepository.findBillDetailByBill_Id(bill.getId()));
        BigDecimal totalPriceBill = BigDecimal.valueOf(0);
        for (BillDetail billDetail : bill.getBillDetails()) {
            Product product = productRepository.findAllById(billDetail.getProduct().getId());
            billDetail.setProduct(product);
            billDetail.setNameProduct(product.getNameProduct());
            billDetail.setPrice(product.getPrice());
            BigDecimal totalPrice = billDetail.getPrice().multiply(new BigDecimal(String.valueOf(billDetail.getQuantity())));
            totalPriceBill = totalPriceBill.add(totalPrice);
            billDetail.setBill(bill);
        }
        bill.setTotalPrice(totalPriceBill);
        bill.setCustomer(checkCustomer(bill.getCustomer()));
        billRepository.save(bill);
    }

    public List<ShowBillResponse> getAllBill() {
        List<Bill> billList = billRepository.findAll();
        List<ShowBillResponse> billResponseList = new ArrayList<>();


        billList.forEach(bill -> {
                    var result = AppUtils.mapper.map(bill, ShowBillResponse.class);
                    result.setNameProduct(bill.getBillDetails().stream() //[{id:1, nameProduct:Hello}, {id:1, nameProduct:Hello}]
                            .map(BillDetail::getNameProduct)// [Hello, Hello]
                            .reduce("", (name, e) -> name + "," + e));//Hello,Hello
                    result.setName(bill.getCustomer().getName());
                    billResponseList.add(result);

                }
        );

        return billResponseList;
    }

    public List<ProductSaveBillResponse> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(e -> AppUtils.mapper.map(e, ProductSaveBillResponse.class))
                .collect(Collectors.toList());
    }
}
