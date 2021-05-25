package net.alterapp.miniproject3.controller;


import com.fasterxml.jackson.annotation.JsonIgnore;
import net.alterapp.miniproject3.domain.AuditModel;

import javax.persistence.*;


@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "users")
@SequenceGenerator(
        name = "seq",
        sequenceName = "s_users",
        initialValue = 1,
        allocationSize = 1
)
public class DAOUser extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    @JsonIgnore
    private String password;
    @Column(name = "role")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
