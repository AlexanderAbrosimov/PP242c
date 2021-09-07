package pp.DAO;

import org.springframework.stereotype.Repository;
import pp.model.Role;
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
}
