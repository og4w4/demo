package com.example.demo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    @GetMapping("/")
    public String index(){
        return "hello";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

        @GetMapping("/admin")
    public String adminPage() {
        return "admin"; // 管理者ページのテンプレート
    }

    @GetMapping("/user")
    public String userPage() {
        return "user"; // ユーザーページのテンプレート
    }

    @RequestMapping("/profile")
    public String profile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"))) {
            return "adminProfile"; // 管理者のプロフィールページ
        } else if (authentication.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_USER"))) {
            return "userProfile"; // ユーザーのプロフィールページ
        } else {
            return "accessDenied"; // アクセス拒否ページ
        }
    }
}
