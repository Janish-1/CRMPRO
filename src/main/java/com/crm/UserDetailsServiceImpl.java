package com.crm;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//UserDetailsServiceImpl.java
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

 @Autowired
 private UserRepository userRepository;

 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     User user = userRepository.findByUsername(username);
     if (user == null) {
         throw new UsernameNotFoundException("User not found with username: " + username);
     }
     return new org.springframework.security.core.userdetails.User(
             user.getUsername(),
             user.getPassword(),
             getAuthorities(user)
     );
 }

 private Collection<? extends GrantedAuthority> getAuthorities(User user) {
     Set<GrantedAuthority> authorities = new HashSet<>();
     for (UserRole userRole : user.getUserRoles()) {
         authorities.add(new SimpleGrantedAuthority("ROLE_" + userRole.getRole().getName()));
     }
     return authorities;
 }
}

