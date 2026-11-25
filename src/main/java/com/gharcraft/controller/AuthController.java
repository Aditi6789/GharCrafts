package com.gharcraft.controller;

import com.gharcraft.dto.*;
import com.gharcraft.model.AppUser;
import com.gharcraft.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserRepository users; private final PasswordEncoder encoder;
    public AuthController(UserRepository users, PasswordEncoder encoder){this.users=users;this.encoder=encoder;}

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String,Object> register(@Valid @RequestBody AuthRequest request, HttpSession session){
        if(users.existsByEmailIgnoreCase(request.email())) throw new IllegalArgumentException("An account with this email already exists.");
        AppUser user=users.save(new AppUser(request.name().trim(),request.email().trim().toLowerCase(),encoder.encode(request.password())));
        session.setAttribute("USER_ID",user.getId());
        return Map.of("id",user.getId(),"name",user.getName(),"email",user.getEmail());
    }
    @PostMapping("/login")
    public Map<String,Object> login(@Valid @RequestBody LoginRequest request, HttpSession session){
        AppUser user=users.findByEmailIgnoreCase(request.email()).orElseThrow(()->new IllegalArgumentException("Invalid email or password."));
        if(!encoder.matches(request.password(),user.getPasswordHash())) throw new IllegalArgumentException("Invalid email or password.");
        session.setAttribute("USER_ID",user.getId());
        return Map.of("id",user.getId(),"name",user.getName(),"email",user.getEmail());
    }
    @GetMapping("/me")
    public Map<String,Object> me(HttpSession session){
        Object id=session.getAttribute("USER_ID");
        if(id==null) return Map.of("authenticated",false);
        AppUser user=users.findById((Long)id).orElse(null);
        if(user==null) return Map.of("authenticated",false);
        return Map.of("authenticated",true,"id",user.getId(),"name",user.getName(),"email",user.getEmail());
    }
    @PostMapping("/logout")
    public Map<String,String> logout(HttpSession session){session.invalidate();return Map.of("message","Logged out successfully.");}
}
