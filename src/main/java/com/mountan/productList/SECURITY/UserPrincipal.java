//package com.mountan.productList.SECURITY;
//
//import com.mountan.productList.Entity.User;
//import org.jspecify.annotations.Nullable;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//
//public class UserPrincipal implements UserDetails {
//
//    // Holds the actual user entity from the database
//    private User user;
//
//    // Constructor to inject the User object
//    public UserPrincipal(User user) {
//        this.user = user;
//    }
//
//    // Returns the roles/authorities granted to this user
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // Hardcoded role for now: ROLE_SELLER
//        // Later you can replace this with user.getRole() or a dynamic role list
//        return List.of(new SimpleGrantedAuthority("ROLE_SELLER"));
////        return List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
//    }
//
//    // Returns the username used for login
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    // Returns the encoded password for authentication
//    @Override
//    public @Nullable String getPassword() {
//        return user.getPassword();
//    }
//}