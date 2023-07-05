package com.example.dictionary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    private static Map<String, String> dictionaryMap = new HashMap<>();
    static {
        dictionaryMap.put("hello", "là 'Xin chào!' thằng ngu!");
        dictionaryMap.put("thank", "'Cám ơn nhá' thằng ngu!");
        dictionaryMap.put("bye", "Tạm biệt! bố mày cút nhé!");
        dictionaryMap.put("car", "Là xe đấy, thế cũng đéo biết! Ngu vkl!");
        dictionaryMap.put("home", "Chắc nghĩa là cái nhà!??");
        dictionaryMap.put("fish", "Con cá!!? Chắc thế?");
        dictionaryMap.put("cat", "Tau đố m từ này nghĩa là con mèo hay con heo đấy??!");
    }

    @GetMapping String home() {
        return "index";
    }
    @PostMapping String dictionary(Model model, @RequestParam String key) {
        String keyString = dictionaryMap.get(key.toLowerCase());
        if (keyString == null)
            model.addAttribute("value", "Bố mày cũng đéo biết!!");
        else model.addAttribute("value", keyString);
        return "index";
    }
}
