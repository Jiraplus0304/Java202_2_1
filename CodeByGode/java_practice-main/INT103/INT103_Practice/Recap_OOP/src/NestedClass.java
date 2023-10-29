public class NestedClass {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner();
        inner.sayHello();

        Animal animal = new Animal();
        animal.sound();

        Animal giant = new Animal(){
            @Override
            public void sound(){
                System.out.println("-----*-");
            }
        };
        giant.sound();
    }
}

class Animal{
    public void sound(){
        System.out.println("Meow Meow");
    }
}
class Outer{
    static class Inner{
        public void sayHello(){
            System.out.println("Hello");
        }
    }
}