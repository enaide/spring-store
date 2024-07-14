package com.ecfcode.springstore.infrastructure.abstracts;

import com.ecfcode.springstore.infrastructure.entities.concretes.user.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByToken(String token);
}
