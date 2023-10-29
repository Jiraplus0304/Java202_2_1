package sit.int202.web_test.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Accounts {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
}
