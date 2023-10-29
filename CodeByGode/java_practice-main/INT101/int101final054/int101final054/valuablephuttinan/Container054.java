package valuablephuttinan;

import java.util.Arrays;

import static utilphuttinan.Tool054.count054;

public class Container054 {
    private final Item054[] item = new Item054[054];

    @Override
    public String toString() {
        return "Container054{" +
                "item=" + count054(item) + Arrays.toString(item) +
                '}';
    }

    public boolean add(Item054 item){
        boolean add = false;
        for (int i =0 ; i < 054 ; i++) {
            if (this.item[i] == null ){
                this.item[i] = item;
                add = true;
                break;
            }
        }
        return add;
    }

    public boolean remove(Item054 item){
        boolean add = false;
        for (int i =0 ; i < 054 ; i++) {
            if (this.item[i].equals(item)){
                this.item[i] = null;
                add = true;
            }
        }
        return add;
    }
}
