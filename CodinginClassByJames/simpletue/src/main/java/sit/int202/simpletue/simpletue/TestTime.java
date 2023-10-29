package sit.int202.simpletue.simpletue;

import java.util.Date;

public class TestTime {
    public static void main(String[] args) {
        Date d1 = new Date(1000);
        System.out.println(d1);
        Date d2 = new Date(1000*60*60*24);//1day
        System.out.println(d2);
        Date today = new Date(System.currentTimeMillis());
        System.out.println(today);

    }
}
