package withoutgroup.CRUDonSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import withoutgroup.CRUDonSpringBoot.model.User;
import withoutgroup.CRUDonSpringBoot.repository.UserRepository;

import java.util.List;
@Service
public class UserService {

    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserService() {
    }

    @Transactional
    public void add(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void remove(long id) {
        userRepository.delete(userRepository.findById(id).get());
    }

    @Transactional
    public void update(long id, User user) {
        user.setId(id);
        userRepository.save(user);
    }

    public User getOneUser(long id) {
        return userRepository.findById(id).get();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
