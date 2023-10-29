import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class HowtoStack {
    public static void main(String[] args) {
        Stack<String> stacks = new Stack<>();
        stacks.push("durian");
        stacks.push("banana");
        stacks.push("orange");
        stacks.push("apple");
        //empty เช็คว่ามีข้อมูลใน stack มั้ย มี False ไม่มี True
        System.out.println(stacks.empty());
        System.out.println(stacks);
        //peek เเสดงตัวสุดท้าย
        System.out.println(stacks.peek());
        System.out.println(stacks);
        //pop ลบตัวสุดท้ายออก
        System.out.println(stacks.pop());
        System.out.println(stacks);
        //search
        System.out.println(stacks.search("banana"));
        System.out.println(stacks.get(2));
        //contains ได้ค่าออกมา True False
        System.out.println(stacks.contains("banana"));
        System.out.println(stacks.contains("awdawdaw"));

    }
}
