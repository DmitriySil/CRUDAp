package web.controller;

import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;



@Controller
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }
    @GetMapping("/users/{id}")
    public String showUser(@PathVariable("id") long id,Model model) {
        model.addAttribute("user", userService.showUser(id));
        return "user";
    }

    @GetMapping( "/users/add")
    public String addUser(@ModelAttribute("user")User user) {
        return "add";
    }
    @PostMapping("users/add")
    public String add(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }
    @GetMapping("/users/{id}/edit")
    public String edit(Model model,@PathVariable("id") long id) {
        model.addAttribute("user", userService.showUser(id));
        return "edit";
    }
    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
    @PatchMapping("/users/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(user, id);
        return "redirect:/users";
    }



}
