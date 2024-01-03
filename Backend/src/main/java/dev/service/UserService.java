package dev.service;

import dev.domain.User;
import dev.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        userRepository.create(user);
    }

    public void update(int id, User updatedUser) {
        userRepository.edit(id, updatedUser);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User get(int id) {
        return userRepository.get(id);
    }
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    public User signIn(User user) {
        User userFound = getByEmail(user.getEmail());

        if (userFound != null && Objects.equals(user.getPassword(), userFound.getPassword())) {
            return userFound;
        } else {
            throw new RuntimeException("User not found or invalid credentials");
        }
    }

    public void delete(int id) {
        userRepository.delete(id);
    }
}
