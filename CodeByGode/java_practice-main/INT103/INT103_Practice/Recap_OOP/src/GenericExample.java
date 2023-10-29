public class GenericExample {
    public static void main(String[] args) {
        MyList<Ball> Balls = new MyList<>();
        MyList<Table> Tables = new MyList<>();

        Balls.add(new Ball("red"));
        Balls.add(new Ball("blue"));
        Balls.add(new Ball("green"));

        Tables.add(new Table(1));
        Tables.add(new Table(2));
        Tables.add(new Table(3));

        System.out.println( Balls.get(1));
        System.out.println( Tables.get(1));
    }
}

class MyList<T>{
    private T[] items;
    private int size;

    public MyList(){
        this.items = (T[]) new Object[20];
        this.size = 0;
    }

    public void add (T item){
        if(size == items.length){
            System.out.println("Full");
            return ;
        }
        items[size]=item;
        size++;
    }

    public T get(int index){
        if (index < 0){
            System.out.println("error");
            return null;
        }
        if(index >= size){
            System.out.println("error");
            return null;
        }
        return  items[index];
    }


}
class Table{
    private int id;

    public Table(int id) {
        this.id = id;
    }

    public int getTableId() {
        return id;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                '}';
    }
}

class Ball{
    private String color;

    public Ball(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "color='" + color + '\'' +
                '}';
    }
}
