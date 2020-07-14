package com.atestados.online.AtestadosOnline.Security;


import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.atestados.online.AtestadosOnline.Models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserDetailsImpl implements UserDetails {

	
	private Long id;
    private String name;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean active;

    @JsonIgnore
    private String password;

    public UserDetailsImpl(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        this.password = user.getPassword();
        this.active = user.isActive();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
        return active;
    }

}
