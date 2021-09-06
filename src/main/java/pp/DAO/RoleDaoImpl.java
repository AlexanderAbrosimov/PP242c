package pp.DAO;

import org.springframework.stereotype.Repository;
import pp.model.Role;
import pp.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Role role) {
        em.persist(role);
    }

    @Override
    public List<Role> findAll() {
        return em.createQuery("SELECT r FROM Role r", Role.class)
                .getResultList();
    }

    @Override
    public Role getRoleById(Long id) {
        return em.find(Role.class, id);
    }

    @Override
    public Role getDefaultRole() {
        return null;
    }

    @Override
    public Role getRoleByName(String name) {
        return null;
    }
}
