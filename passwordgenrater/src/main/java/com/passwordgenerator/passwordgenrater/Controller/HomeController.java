package com.passwordgenerator.passwordgenrater.Controller;

import java.lang.reflect.Parameter;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.passwordgenerator.Model.Parameters;




@Controller
public class HomeController {
    
    @GetMapping("")
    public String home(Model model) {        
        model.addAttribute("parameters", new Parameters());
        return "index";
    }
    
    @PostMapping("/generate-password")
    public String generatePassword(@ModelAttribute Parameters parameter,Model m){
        int len = parameter.getLength();
        int num = parameter.getNumberCount();
        int specialChar = parameter.getSpecialCharCount();
        String password = "";
        
        
        if(len < 6 || len > 100 || len < num+specialChar){
            m.addAttribute("generatedPassword", "Please Enter Valid length");
            return "index";
        }
        int characters = len-specialChar-num;
        Random random = new Random();
        boolean f = true;
        for(int i = 0;i < specialChar/2; i++){
            int val = 0;
            val = random.nextInt(33,47);
            password += (char)val;
        }

        
        for(int i = 0;i < characters; i++){
            int val = 0;
            if (f) {
                val = random.nextInt(65, 90);
            }else{
                val = random.nextInt(97,122);
            }
            password += (char)(val);
            f = !f;
        }
        
        for(int i = 0;i < specialChar/2; i++){
            int val = 0;
            val = random.nextInt(33,47);
            password += (char)val;
        }

        for(int i = 0;i < num; i++){
            int val = 0;
            val = random.nextInt(48, 57);
            password += (char)val;
        }

        m.addAttribute("generatedPassword", password);
        return "index";
    }
    
}
