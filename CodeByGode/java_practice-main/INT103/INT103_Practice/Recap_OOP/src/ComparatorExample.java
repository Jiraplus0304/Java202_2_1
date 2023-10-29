import java.util.*;

//Comparator ตัสที่เปลี่ยบเทียบ Comparable บอกมันว่าสามารถเปรียบเทียบได้
public class ComparatorExample {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Water","Drinks",10f,100));
        items.add(new Item("Lays","Snacks",22.5f,20));
        items.add(new Item("Chocolate","Snacks",55.5f,50));
        items.add(new Item("Pencil","Tool",13.25f,1000));
        items.add(new Item("Paper","Tool",2.5f,10000));
        items.add(new Item("Coke","Drinks",18f,20));

        Collections.sort(items);

//        items.sort(new Comparator<Item>() {
//            @Override
//            public int compare(Item o1, Item o2) {
//                //เรียงด้วยชื่อ น้อยไปมาก ใส่ - มากไปน้อย
//                return o1.getName().compareTo(o2.getName()) ;
//            }
//        });

        for (Item item: items) {
            System.out.printf("Name: %s, Category: %s, Price: %.2f, Stocks: %d%n",
                    item.getName(),item.getCategory(),item.getPrice(),item.getStocks());
        }
    }
}


class Item implements Comparable<Item>{
    private String name;
    private String category;
    private float price;
    private int stocks;

    public Item(String name, String category, float price, int stocks) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stocks = stocks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    @Override
    public int compareTo(Item o) {
        // sort by category first then sort by name
        if (this.getCategory().equalsIgnoreCase(o.getCategory())){
            return this.getName().compareToIgnoreCase(o.getName());
        }
        return this.getCategory().compareToIgnoreCase(o.getCategory());
    }
}
