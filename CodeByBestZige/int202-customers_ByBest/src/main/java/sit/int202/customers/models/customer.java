package sit.int202.customers.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class customer {
    private static int autoIncrementId = 1; //id เริ่มต้น = 1
    private int id;
    private String name;
    private String phone;

    public customer(String name, String phone){
        this.id = autoIncrementId++;
        this.name = name;
        this.phone = phone;
    }
}
