// Super มีไว้ให้ SubClassสืบ ทอด
public class SuperAndSubClass {
    public static void main(String[] args) {
        Car car = new Car("Ford","Mustang");
        car.sound();
        Airplane airplane = new Airplane("Air",2000);
        airplane.sound();
    }


}
class Vehicle{
    private String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public void sound(){
        System.out.println("tid tid");
    }
}

class Car extends Vehicle{
    private String model;

    public Car(String brand,String model) {
        super(brand);
        this.model=model;
    }

    @Override
    public void sound(){
        System.out.println("Tud tud");
    }
}

class Airplane extends Vehicle{
    private int year;

    public Airplane(String brand ,int year) {
        super(brand);
        this.year=year;
    }
    @Override
    public void sound(){
        System.out.println("aaaaaa");
    }
}
