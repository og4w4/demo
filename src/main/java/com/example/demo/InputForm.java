package com.example.demo;

import lombok.Data;

@Data
public class InputForm {
    
    /** 現在のパスワード */
    private String currentPassword;

    /** 新しいパスワード */
    private String newPassword;

    /** 新しいパスワード（確認用） */
    private String confirmPassword;
}
