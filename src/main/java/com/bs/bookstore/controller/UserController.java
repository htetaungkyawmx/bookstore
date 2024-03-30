package com.bs.bookstore.controller;

import com.bs.bookstore.entity.User;
import com.bs.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String userForm(Model model) {
        model.addAttribute("user", new User());
        return "user/userForm";
    }

    @PostMapping("/create")
    public String userFormCreate(User user) {
        userService.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/list")
    public String userList(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "user/users";
    }

    @GetMapping("/user/edit/{id}")
    public String updateForm(@PathVariable Integer id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/updateUser";
    }
    @PostMapping("/user/update/{id}")
    public String updateProcess(@PathVariable Integer id, User user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            user.setId(id);
            return "user/updateUser";
        }
        userService.save(user);
        return "redirect:/user/all";
    }

    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        User user= userService.findUserById(id);
        userService.delete(user);
        return "redirect:/user/all";
    }
}
