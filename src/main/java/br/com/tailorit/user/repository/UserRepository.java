package br.com.tailorit.user.repository;

import br.com.tailorit.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByParentUserIsNull();

    List<User> findByParentUser(User user);

    Optional<User> findByUsername(String username);
}
