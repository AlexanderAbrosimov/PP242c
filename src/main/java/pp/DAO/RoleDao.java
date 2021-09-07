package pp.DAO;

import pp.model.Role;

import java.util.List;

public interface RoleDao {
    void save(Role role);
    List<Role> findAll();
    Role getRoleById(Long id);
}
