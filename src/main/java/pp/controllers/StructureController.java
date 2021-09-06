package pp.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pp.model.User;
import pp.service.RoleService;
import pp.service.UserService;


@Controller
@RequestMapping("/")
public class StructureController {

    private final UserService userService;
    private final RoleService roleService;

    public StructureController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @GetMapping("/user")
    public String userPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user", userService.getUserByUsername(auth.getName()));
        return "user";
    }

    @GetMapping("/admin")
    public String index(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "admin";
    }

//    @GetMapping("user/{id}")
//    public String show(@PathVariable("id") Long id, ModelMap model){
//        model.addAttribute("user", userService.getUserById(id));
//        return "show";
//    }

    @GetMapping("/admin/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.findAll());
        return "new";
    }

    @PostMapping("/admin/new")
    public String create(@ModelAttribute("user") User user,
                         @RequestParam("rolesSelected") Long[] rolesId) {
        for(Long roleId: rolesId) {
            user.setRole(roleService.getRoleById(roleId));
        }
        userService.save(user);
        userService.findAllUsers();
        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("allRoles", roleService.findAll());
        return "edit";
    }

    @PatchMapping("/admin/{id}")
    public String update(@ModelAttribute("user") User user,
                         @RequestParam("rolesSelected") Long[] rolesId){
        for(Long roleId: rolesId) {
            user.setRole(roleService.getRoleById(roleId));
        }
        userService.update(user);
        userService.findAllUsers();
        return "redirect:/admin";
    }

    @DeleteMapping("/admin/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/admin";
    }

}
