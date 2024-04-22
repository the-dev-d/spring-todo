package com.app.todo.service;


import com.app.todo.dto.UserDto;
import com.app.todo.model.User;
import com.app.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    final PasswordEncoder passwordEncoder;
    final UserRepository userRepository;

    public UserDto addUser(UserDto userDto) {
        try {
            User user = new User(userDto);
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            return new UserDto(userRepository.save(user));
        }catch (Exception e) {
            return null;
        }
    }
}
