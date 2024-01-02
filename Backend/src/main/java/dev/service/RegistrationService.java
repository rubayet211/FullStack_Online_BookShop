package dev.service;

import dev.domain.User;
import dev.domain.UserDetail;
import dev.repository.UserDetailRepository;
import dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class RegistrationService {

    private final UserRepository userRepository;
    private final UserDetailRepository userDetailRepository;

    @Autowired
    public RegistrationService(UserRepository userRepository, UserDetailRepository userDetailRepository) {
        this.userRepository = userRepository;
        this.userDetailRepository = userDetailRepository;
    }

    public UserDetail registerUser(User user, UserDetail userDetail) {
        userDetail.setUser(user);
        return userDetailRepository.createDetail(userDetail);
    }
}
