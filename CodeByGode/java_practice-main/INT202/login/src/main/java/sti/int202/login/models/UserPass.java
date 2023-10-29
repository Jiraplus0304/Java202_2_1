package sti.int202.login.models;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class UserPass {
    private Map<String,String> reg = new HashMap<>();

    public void AddUserPass(String user, String pass) {
        reg.put(user,pass);
    }

    public Boolean getUser(String user){
        if (reg.get(user) == null){
            return false ;
        }
        return true ;
    }
    public String getPass(String user){
        return reg.get(user);
    }
}
