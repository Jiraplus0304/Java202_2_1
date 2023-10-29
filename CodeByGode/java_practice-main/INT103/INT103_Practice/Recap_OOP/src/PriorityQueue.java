import java.util.LinkedList;
import java.util.Queue;

public class PriorityQueue {
    // FIFO , FCFS
    public static void main(String[] args) {
        Queue<String> queues = new LinkedList<>();
        queues.offer("1");
        queues.offer("2");
        queues.offer("3");
        queues.offer("4");

        System.out.println(queues);

        //peek ใส่ข้อมูลตัวเเรก จะเเสดงอันนั้น
        System.out.println(queues.peek());
        //poll ลบ อันเเรกออก
        System.out.println(queues.poll());
        System.out.println(queues);
        //remove ที่เลือก
        System.out.println(queues.remove("3"));
        System.out.println(queues);

    }
}
