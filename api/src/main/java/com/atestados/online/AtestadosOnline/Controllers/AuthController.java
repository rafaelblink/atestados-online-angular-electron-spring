package com.atestados.online.AtestadosOnline.Controllers;


import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atestados.online.AtestadosOnline.Payload.JwtAuthResponse;
import com.atestados.online.AtestadosOnline.Payload.SignInRequest;
import com.atestados.online.AtestadosOnline.Security.JwtCreator;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/auth")
@Api(tags = {"Autenticação"})
@CrossOrigin
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtCreator jwtCreator;

    public AuthController(AuthenticationManager authenticationManager, JwtCreator jwtCreator) {
        this.authenticationManager = authenticationManager;
        this.jwtCreator = jwtCreator;
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> authenticate(@Valid @RequestBody SignInRequest signInRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtCreator.create(authentication);
        return ResponseEntity.ok(new JwtAuthResponse(jwt));
    }

}
