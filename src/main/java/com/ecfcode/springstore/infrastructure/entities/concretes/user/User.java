package com.ecfcode.springstore.infrastructure.entities.concretes.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "_user")
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails, Principal {

    @Id
    @GeneratedValue()
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    @Column(unique = true)
    private String email;
    private String password;
    private boolean accountLocked;
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;

    @Override
    public String getName() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map((Role role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    public String fullName() {
        return getFirstName() + " " + getLastName();
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

}
