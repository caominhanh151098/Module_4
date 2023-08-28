package com.example.billmanagement.service.auth.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "ĐÉO được để trống!")
    private String username;
    @NotBlank(message = "ĐÉO được để trống!")
    private String password;
    @NotBlank(message = "ĐÉO được để trống!")
    private String email;
    @NotBlank(message = "ĐÉO được để trống!")
    private String fullName;
    @NotBlank(message = "ĐÉO được để trống!")
    private String phone;
}
