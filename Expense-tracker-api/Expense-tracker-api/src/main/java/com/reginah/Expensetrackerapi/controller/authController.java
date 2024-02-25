package com.reginah.Expensetrackerapi.controller;
import com.reginah.Expensetrackerapi.dto.AuthDto;
import com.reginah.Expensetrackerapi.entity.User;
import com.reginah.Expensetrackerapi.dto.UserDto;
import com.reginah.Expensetrackerapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class authController {
    private final AuthenticationManager authenticationManager;


    @Autowired
    private UserService userService;

    public authController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/login")
    public ResponseEntity<HttpStatus> login(@RequestBody AuthDto authModel) {
        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authModel.getEmail(), authModel.getPassWord()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
//    @PostMapping("/login")
//    public ResponseEntity<String> login() {
//        return new ResponseEntity<String>("user is logged in", HttpStatus.OK);
//    }
    @PostMapping("/register")
    public ResponseEntity<UserDto> add(@Valid @RequestBody UserDto user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
}
