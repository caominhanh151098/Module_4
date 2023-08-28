//package com.example.billmanagement.controller;
//
//import com.example.billmanagement.model.User;
//import com.example.billmanagement.repository.UserRepository;
//import com.example.billmanagement.service.auth.AuthService;
//import com.example.billmanagement.service.auth.request.RegisterRequest;
//import jakarta.validation.Valid;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.ArrayList;
//
//@Controller
//@AllArgsConstructor
//public class AuthController implements UserDetailsService {
//    private final AuthService authService;
//    private final UserRepository userRepository;
//
//    @GetMapping("/login")
//    public ModelAndView login() {
//        ModelAndView model = new ModelAndView("login");
//        return model;
//    }
//
//    @GetMapping("/register")
//    public ModelAndView showRegistrationForm() {
//        ModelAndView model = new ModelAndView("register");
//        RegisterRequest user = new RegisterRequest();
//        model.addObject("user", user);
//        return model;
//    }
//
//    @PostMapping("/register")
//    public ModelAndView registration (@Valid @ModelAttribute("user") RegisterRequest request, BindingResult result) {
//        ModelAndView model = new ModelAndView("register");
//        if (result.hasErrors() || authService.checkExist(request, result)) {
//            return model;
//        }
//
//        authService.register(request);
//
//        return new ModelAndView("redirect:/register?success");
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsernameIgnoreCaseOrEmailIgnoreCaseOrPhone(username,username,username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not Exist") );
//        var role = new ArrayList<SimpleGrantedAuthority>();
//        role.add(new SimpleGrantedAuthority(user.getRole().toString()));
//
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), role);
//    }
//}
