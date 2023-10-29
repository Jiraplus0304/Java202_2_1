package valuablephuttinan;

import static utilphuttinan.Tool054.isUsable054;

public class Item054 {
    private final String name ;
    private int amount;

    Item054(String name, int amount){
    this.name = name;
    this.amount= amount;
    }

    public static Item054 create(String name , int amount){
        int size = 1 ;
        int count = 0;
        Item054[] create = new Item054[size];
        create[count] = new Item054(name ,amount);
        if (isUsable054(create)){
            size++;
            count++;
            return create[count];
        }else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "(" + name + "," + amount + ")";
    }

    public int add(Item054 item){
        int sum ;
        sum = this.amount + item.amount;
        return sum;
    }
    public boolean isMatched(Item054 item){
        if (this.name == item.name){
            return true;
        }else {
            return false;
        }
    }
}
