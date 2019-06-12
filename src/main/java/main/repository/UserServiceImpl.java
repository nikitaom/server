package main.repository;

import main.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void saveAll(List<User> users) {
        userRepository.save(users);
    }

    @Override
    public void deleteAll(List<User> users) {
        userRepository.delete(users);
    }


}
