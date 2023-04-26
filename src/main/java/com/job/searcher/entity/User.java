package com.job.searcher.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Table(name ="users")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String lastname;
    private Integer phoneNumber;

    @Column(unique = true)
    private String email;
    private String password;

    @CreatedDate
    private LocalDateTime created_at;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Applied> jobsApplied;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Arrays.asList(new SimpleGrantedAuthority(role.getValue()));

    }

    @Override
    public String getUsername() {
        return email;
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
        return true;
    }
}
