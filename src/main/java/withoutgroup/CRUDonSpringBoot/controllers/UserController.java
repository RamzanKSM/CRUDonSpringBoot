package withoutgroup.CRUDonSpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import withoutgroup.CRUDonSpringBoot.model.User;
import withoutgroup.CRUDonSpringBoot.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String startPage (Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "views/start";
    }

    @GetMapping("/{id}")
    public String getUserById (@PathVariable("id") long id, Model model) {
        model.addAttribute("someUser", userService.getOneUser(id));
        return "views/someUser";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "views/new";
    }

    @PostMapping
    public String createNewUser (@ModelAttribute ("user") User user) {
        userService.add(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String editUser (@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getOneUser(id));
        return "views/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(id, user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable("id") long id) {
        userService.remove(id);
        return "redirect:/user";
    }
}
