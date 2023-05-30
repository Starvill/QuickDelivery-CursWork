package com.example.demo.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User implements UserDetails{
    @Id
    @NotEmpty(message = "Логин не может быть пустым")
    @Pattern(regexp = "^[a-zA-Z0-9]{5,100}$", message = "Не менее 5 и более 100 символов")
    private String username;

    @NotEmpty(message = "Пароль не может быть пустым")
    private String password;

    @Column(updatable = false, insertable = false)
    @NotEmpty(message = "Пароль не совпадает")
    private String repeated;

    private String name;

    private String address;

    private String phone;

    @Pattern(regexp = ".{100}$", message = "Не более 50 символов")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

