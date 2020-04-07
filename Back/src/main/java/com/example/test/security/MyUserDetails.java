package com.example.test.security;
import com.example.test.model.User;
import com.example.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

@Service
public class MyUserDetails implements UserDetailsService {
  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final User user = userRepository.findByUsername(username)
            .orElseThrow(() ->
            new UsernameNotFoundException("User not found with username or email : " + username)
            );
            
    return UserPrincipal.create(user);
  }
  @Transactional
  public UserDetails loadUserById(Long id) {
      User user = userRepository.findById(id).orElseThrow(
              () -> new UsernameNotFoundException("User not found")
                );

 

      return UserPrincipal.create(user);
  }
 
}
