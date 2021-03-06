package pp.service;

import pp.DAO.UserDao;
import pp.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   public List<User> findAllUsers() {
      return userDao.findAll();
   }

   @Override
   public void save(User user) {
      userDao.save(user);
   }

   @Override
   public User getUserById(Long id) {
      return userDao.getUserById(id);
   }

   @Override
   public User getUserByUsername(String username) {
      return userDao.getUserByUsername(username);
   }


   @Override
   public void update(User user) {
      userDao.update(user);
   }


   @Override
   public void delete(Long id) {
      userDao.delete(id);
   }

}
