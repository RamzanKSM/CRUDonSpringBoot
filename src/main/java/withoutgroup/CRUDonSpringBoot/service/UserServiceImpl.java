package withoutgroup.CRUDonSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import withoutgroup.CRUDonSpringBoot.dao.UserDao;
import withoutgroup.CRUDonSpringBoot.model.User;

import java.util.List;
@Repository
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

    @Override
    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    @Transactional
    public void remove(long id) {
        userDao.remove(id);
    }

    @Override
    @Transactional
    public void update(long id, User user) {
        userDao.update(id, user);
    }

    @Override
    public User getOneUser(long id) {
        return userDao.getOneUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
