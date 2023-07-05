package com.example.convert;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private static final double ratio = 22500;
    @GetMapping
    public String index(Model model) {
        return "index";
    }

    @PostMapping
    public String convertMoney(Model model, @RequestParam String vnd, @RequestParam String usd) {
        double moneyVND = 0;
        double moneyUSD = 0;
        if (!vnd.equals(""))
            moneyVND = Double.parseDouble(vnd);
        if (!usd.equals(""))
            moneyUSD = Double.parseDouble(usd);
        if (moneyVND != 0)
            moneyUSD = moneyVND / ratio;
        if (moneyUSD != 0)
            moneyVND = moneyUSD * ratio;
        model.addAttribute("vnd",moneyVND);
        model.addAttribute("usd",moneyUSD);
        return "index";
    }
}
