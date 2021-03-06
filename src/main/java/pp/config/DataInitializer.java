package pp.config;

import pp.model.Role;
import pp.model.User;
import pp.service.RoleService;
import pp.service.UserService;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;

    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void init() {

        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");
        Set<Role> allRoles = new HashSet<>();
        Set<Role> userRole = new HashSet<>();
        allRoles.add(role1);
        allRoles.add(role2);
        userRole.add(role2);
        User root = new User("root", "1", allRoles);
        User user = new User("user", "1", userRole);

        roleService.save(role1);
        roleService.save(role2);
        userService.save(root);
        userService.save(user);

    }
}
