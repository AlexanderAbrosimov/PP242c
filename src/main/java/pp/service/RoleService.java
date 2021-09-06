package pp.service;

import pp.model.Role;

import java.util.List;

public interface RoleService {

    void save(Role role);
    List<Role> findAll();
    Role getRoleById(Long id);
}
