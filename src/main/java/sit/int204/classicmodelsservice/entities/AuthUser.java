package sit.int204.classicmodelsservice.entities;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import  org.springframework.security.core.userdetails.User;

public class AuthUser extends  User implements Serializable {
    public  AuthUser(){
        super("anonymous","",new ArrayList<GrantedAuthority>());
    }
    public  AuthUser(String userName,String password){
        super(userName,password,new ArrayList<GrantedAuthority>());
    }

    public  AuthUser(String userName, String password, Collection<? extends GrantedAuthority> authorities){
        super(userName,password,new ArrayList<GrantedAuthority>());
    }
}
