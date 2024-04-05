package sit.int204.classicmodelsservice.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id",nullable = false)
    private Integer userId;
    private String name;
    private String password;

    public User(String anonymous, String s, ArrayList<GrantedAuthority> grantedAuthorities) {
    }
}
