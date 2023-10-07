package br.com.tailorit.user.service;

import br.com.tailorit.user.PasswordUtil;
import br.com.tailorit.user.dto.UserDTO;
import br.com.tailorit.user.entity.User;
import br.com.tailorit.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO saveUser(UserDTO userDto) {
        Optional<User> existingUser = userRepository.findByUsername(userDto.getUsername());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("O usuário com este nome já existe.");
        }

        int strength = PasswordStrengthMeter.calculateStrength(userDto.getPassword());
        userDto.setPassStrength(strength);

        User userEntity = Optional.of(userDto).map(dto -> {
            User user = new User();
            user.setUsername(dto.getUsername());
            user.setPassword(PasswordUtil.hashPassword(dto.getPassword()));

            if (dto.getParentUserId() != null) {
                User parentUser = userRepository.findById(dto.getParentUserId()).orElse(null);
                user.setParentUser(parentUser);
            }

            user.setPassStrength(dto.getPassStrength());
            return user;
        }).orElse(null);

        User savedUser = userRepository.save(userEntity);
        return mapToDTOWithChildren(savedUser);
    }


    public List<UserDTO> findAll() {
        List<User> topLevelUsers = userRepository.findByParentUserIsNull();
        return topLevelUsers.stream().map(this::mapToDTOWithChildren).collect(Collectors.toList());
    }

    private UserDTO mapToDTOWithChildren(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());

        if (user.getParentUser() != null) {
            dto.setParentUserId(user.getParentUser().getId());
        }

        dto.setPassStrength(user.getPassStrength());

        List<User> children = userRepository.findByParentUser(user);
        if (children != null && !children.isEmpty()) {
            dto.setChildren(children.stream().map(this::mapToDTOWithChildren).collect(Collectors.toList()));
        }

        return dto;
    }
}

