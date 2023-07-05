package com.example.billmanagement.controller;

import com.example.billmanagement.repository.BillRepository;
import com.example.billmanagement.repository.ProductRepository;
import com.example.billmanagement.service.bill.BillService;
import com.example.billmanagement.service.bill.request.BillSaveRequest;
import com.example.billmanagement.service.bill.response.BillSaveResponse;
import com.example.billmanagement.service.bill.response.ProductSaveBillResponse;
import com.example.billmanagement.service.bill.response.ShowBillResponse;
import com.example.billmanagement.util.AppUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/bills")
public class BillController {
    @Autowired
    private BillService billService;
    private final BillRepository billRepository;
    private final ProductRepository productRepository;

    public BillController(ProductRepository productRepository, BillRepository billRepository) {
        this.productRepository = productRepository;
        this.billRepository = billRepository;
    }

    @GetMapping
    public ModelAndView showBills() {
        ModelAndView model = new ModelAndView("bill");
        List<ShowBillResponse> showBills = billService.getAllBill();
        model.addObject("bills", showBills);
        return model;
    }
    @GetMapping("/create")
    public ModelAndView formCreateBill() {
        ModelAndView model = new ModelAndView("create_bill");
        var products = billService.getAllProduct();
        model.addObject("bill", new BillSaveRequest());
        model.addObject("products", products);
        return model;
    }

    @PostMapping("/create")
    public ModelAndView createBill(@Valid @ModelAttribute("bill") BillSaveRequest bill, BindingResult result) {
        ModelAndView model = new ModelAndView("create_bill");
        var products = billService.getAllProduct();
        model.addObject("products", products);
        if (result.hasErrors())
            return model;

        billService.createBill(bill);
        return model;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView formEditBill(@PathVariable int id) {
        ModelAndView model = new ModelAndView("edit_bill");
        var products = billService.getAllProduct();
        BillSaveResponse bill = billService.getBillById(id);
        model.addObject("bill", bill);
        model.addObject("products", products);
        return model;
    }

    @PostMapping("/edit")
    public ModelAndView editBill(@Valid @ModelAttribute("bill") BillSaveResponse bill, BindingResult result) {
        ModelAndView model = new ModelAndView("edit_bill");
        var products = billService.getAllProduct();
        model.addObject("products", products);
        if (result.hasErrors())
            return model;

        billService.editBill(bill);
        return model;
    }
}
