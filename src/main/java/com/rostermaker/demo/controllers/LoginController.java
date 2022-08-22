package com.rostermaker.demo.controllers;

import com.rostermaker.demo.models.player.AccountCredentials;
import com.rostermaker.demo.models.player.Player;
import com.rostermaker.demo.repos.PlayerRepo;
import com.rostermaker.demo.security.JwtService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
public class LoginController {

    @Resource
    private JwtService jwtService;

    @Resource
    AuthenticationManager authenticationManager;

    @Resource
    PlayerRepo playerRepo;

    @PostMapping("/login")
    public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {
        UsernamePasswordAuthenticationToken credsToCheck = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());
        Player foundPlayer = null;
        Optional<Player> loggedInPlayer = playerRepo.findByUsername(credentials.getUsername());

        if (loggedInPlayer.isPresent()) {
            foundPlayer = loggedInPlayer.get();
//            System.out.println(foundPlayer.getUsername() + "    " + foundPlayer.getPassword());
        }

        Authentication auth = authenticationManager.authenticate(credsToCheck);

        String jwts = jwtService.getToken(auth.getName());

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwts)
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization")
                .body(foundPlayer);
//                .build();

    }









}
