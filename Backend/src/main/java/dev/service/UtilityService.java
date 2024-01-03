package dev.service;

import dev.domain.User;
import dev.repository.BookRepository;
import dev.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Transactional
public class UtilityService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public UtilityService(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public Map<String, Integer> count() {
        int customers = userRepository.count();
        int books = bookRepository.count();

        Map<String, Integer> countsMap = new HashMap<>();
        countsMap.put("customers", customers);
        countsMap.put("books", books);

        return countsMap;
    }


}
