package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class IndexController {
    
    @GetMapping("/")
    public String index(){
        return "hello";
    }

    @GetMapping("/change")
    public String getMethodName(InputForm inputForm) {
        return "change";
    }

    @PostMapping("/password")
    public String postMethodName(@Validated InputForm inputForm, BindingResult result, Model model) {

        // 入力文字のエスケープはいるか　


        if(result.hasErrors()){
            return "change";
        }

        if(!inputForm.getCurrentPassword().equals("a")){
            result.rejectValue("currentPassword", null, "現在のパスワードが間違っています");
            System.out.println("現在のパスワードが間違っています");
            return "change";
        }

        if(!inputForm.getNewPassword().equals(inputForm.getConfirmPassword())){
            result.rejectValue("newPassword", null, "新しいパスワードと確認用パスワードが一致しません");
            System.out.println("新しいパスワードと確認用パスワードが一致しません");
            System.out.println(inputForm.getNewPassword());
            System.out.println(inputForm.getConfirmPassword());
            return "change";
        }

        // 登録する処理
        /**
         * 
         * 
         * 
         */

        model.addAttribute("message", "パスワードを変更しました");
        
        return "changed";
    }
    
    
}
