package pp.DAO;


import org.springframework.stereotype.Repository;
import pp.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
   @PersistenceContext
   private EntityManager em;

   @Override
   public User getUserByUsername(String username) {
      Query query = em.createQuery("Select e FROM User e WHERE e.username = :username");
      query.setParameter("username", username);
      return (User) query.getSingleResult();
   }

   @Override
   public void save(User user) {
      em.persist(user);
   }

   @Override
   public List<User> findAll() {
      return em.createQuery("SELECT u FROM User u", User.class)
              .getResultList();
   }

   @Override
   public User getUserById(Long id){
      return em.find(User.class, id);
   }

   @Override
   public void update(User user) {
      em.merge(user);
   }

   @Override
   public void delete(Long id) {
      em.remove(getUserById(id));
   }
}
