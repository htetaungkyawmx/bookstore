package com.bs.bookstore.controller;

import com.bs.bookstore.entity.Role;
import com.bs.bookstore.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public String roleForm(Model model) {
        model.addAttribute("role", new Role());
        return "role/roleForm";
    }

    @PostMapping("/create")
    public String roleFormCreate(Role role){
        roleService.save(role);
        return "redirect:/role/list";
    }

    @GetMapping("/list")
    public String roleList(Model model){
        model.addAttribute("roleList", roleService.findAll());
        return "role/roles";
    }
}
