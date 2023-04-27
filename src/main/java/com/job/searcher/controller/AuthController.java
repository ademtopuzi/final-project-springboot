package com.job.searcher.controller;

import com.job.searcher.dto.JobCategoryDto;
import com.job.searcher.dto.UserDto;
import com.job.searcher.dto.auth.AuthRequest;
import com.job.searcher.dto.auth.TokenDto;
import com.job.searcher.entity.User;
import com.job.searcher.service.JobService;
import com.job.searcher.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.Instant;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor @Validated
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final JwtEncoder jwtEncoder;
  private final UserService userService;

  private final JobService jobService;

  @PostMapping("/login")
  public ResponseEntity<TokenDto> login(@RequestBody @Valid AuthRequest request) {
    try {
      Authentication authentication =
              authenticationManager.authenticate(
                      new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

      User user = (User) authentication.getPrincipal();

      Instant now = Instant.now();
      Long expiry = 3600L;

      String scope =
              authentication.getAuthorities().stream()
                      .map(GrantedAuthority::getAuthority)
                      .collect(Collectors.joining(" "));

      JwtClaimsSet claims =
              JwtClaimsSet.builder()
                      .issuer("searcher")
                      .issuedAt(now)
                      .expiresAt(now.plusSeconds(expiry))
                      .subject(user.getUsername())
                      .claim("roles", scope)
                      .audience(Arrays.asList("Audienca"))
                      .build();

      String token = this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

      return ResponseEntity.ok()
              .header(HttpHeaders.AUTHORIZATION, "Bearer ".concat(token))
              .body(new TokenDto("Bearer ".concat(token)));
    } catch (BadCredentialsException ex) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
  }

  @PostMapping("/register")
  public ResponseEntity<UserDto> registerUser(@RequestBody @Valid UserDto u){
    return ResponseEntity.ok(userService.registerUser(u,"ADMIN"));
  }

  @PostMapping("/category")
  public ResponseEntity<JobCategoryDto> addCategory(@RequestBody JobCategoryDto req){

    return ResponseEntity.ok(jobService.addCategory(req));
  }

}
