package pp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pp.DAO.RoleDao;
import pp.model.Role;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }
}
