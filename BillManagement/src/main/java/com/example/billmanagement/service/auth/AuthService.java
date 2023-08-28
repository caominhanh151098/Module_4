//package com.example.billmanagement.service.auth;
//
//import com.example.billmanagement.model.User;
//import com.example.billmanagement.model.enums.ERole;
//import com.example.billmanagement.repository.UserRepository;
//import com.example.billmanagement.service.auth.request.RegisterRequest;
//import com.example.billmanagement.util.AppUtils;
//import lombok.AllArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.validation.BindingResult;
//
//@Service
//@AllArgsConstructor
//public class AuthService {
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public boolean checkExist(RegisterRequest request, BindingResult result) {
//        boolean check = false;
//        if (userRepository.existsByUsername(request.getUsername())) {
//            result.reject("username", null,
//                    "Tài khoản đã tồn tại!");
//            check = true;
//        }
//        if (userRepository.existsByEmail(request.getEmail())) {
//            result.reject("email", null,
//                    "Email đã tồn tại!");
//            check = true;
//        }
//        if (userRepository.existsByPhone(request.getPhone())) {
//            result.reject("phone", null,
//                    "SỐ ĐT đã tồn tại!");
//            check = true;
//        }
//        return check;
//    }
//
//    public void register(RegisterRequest request) {
//        User user = AppUtils.mapper.map(request, User.class);
//        user.setRole(ERole.ROLE_USER);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//    }
//}
