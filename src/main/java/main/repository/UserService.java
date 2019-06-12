package main.repository;

import main.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void saveAll(List<User> users);

    void deleteAll(List<User> users);
}
