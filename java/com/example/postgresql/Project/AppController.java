package com.example.postgresql.Project;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

   @Autowired
   private UserRepository userRepo;
  
    
   @GetMapping("/landing")
   public String viewHomePage() {
       return "landing";
   }
   @GetMapping("/loginPage")
   public String viewLoginPage() {
       return "loginPage";
   }


   @GetMapping("/register")
   public String showRegistrationForm(Model model) {
       model.addAttribute("user", new User());
       return "register";
   }
   @GetMapping("/process_register")
   public String processRegister(User user) {
       BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
       String encodedPassword = passwordEncoder.encode(user.getPassword());
       user.setPassword(encodedPassword);
       userRepo.save(user);
       return "registeredSuccess";
   }
   @GetMapping("/users")
   public String listUsers(Model model) {
       List<User> listUsers = userRepo.findAll();
       model.addAttribute("listUsers", listUsers);
       return "users";
   }
   
   
}
