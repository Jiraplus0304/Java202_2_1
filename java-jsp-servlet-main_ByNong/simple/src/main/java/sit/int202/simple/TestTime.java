package sit.int202.simple;

import java.util.Date;

public class TestTime {
    public static void main(String[] args) {
        Date d1 = new Date(1000 + 60);
        System.out.println(d1);
        System.out.println(System.currentTimeMillis());
        Date d2 = new Date(1693803811056L);
        System.out.println(d2);
    }
}
