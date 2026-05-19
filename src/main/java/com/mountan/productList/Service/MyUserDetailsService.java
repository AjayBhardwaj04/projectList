//package com.mountan.productList.Service;
//
//import com.mountan.productList.Entity.User;
//import com.mountan.productList.Repository.UserRepository;
////import com.mountan.productList.SECURITY.UserPrincipal;
//
//import org.jspecify.annotations.NonNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.Optional;
//
//@Service
//public class MyUserDetailsService /*implements UserDetailsService */ {
//
//
//
////    @Override
////    public UserDetails loadUserByUsername( String username) throws UsernameNotFoundException {
////        Optional<User> user = userRepository.findByUsername(username);
////        if(user.isEmpty()){
////            throw new UsernameNotFoundException("User not found : ");
////
////        }
////        return new UserPrincipal(user.get());
////    }
//
//    @Autowired
//    private UserRepository userRepository;
//    public User createUser(@RequestBody User user){
//        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
//        return userRepository.save(user);
//    }
//
//}
