package withoutgroup.CRUDonSpringBoot.dao;


import withoutgroup.CRUDonSpringBoot.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    void remove(long id);

    void update(long id, User user);

    User getOneUser(long id);

    List<User> getAllUsers();
}
