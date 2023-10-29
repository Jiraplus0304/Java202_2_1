
public class AbstractAndInterface {
    public static void main(String[] args) {
        Greeting g =new Greeting();
        g.sayHi();
        g.sayHello();

        Mobile m = new Mobile();
        m.capture();
        m.call();
        m.hangup();

        RichMobile r = new RichMobile();
        r.track();
        r.capture();
        r.call();
        r.hangup();

        RichMobileByExtend rx = new RichMobileByExtend();
        rx.track();
        rx.capture();
        rx.call();
        rx.hangup();
    }
}
interface Gps{
    void track();
}
interface Camera{
    void capture();
}
interface Phone{
    void call();
    void hangup();
}
class Mobile implements Phone,Camera{

    @Override
    public void capture() {
        System.out.println("capture");
    }

    @Override
    public void call() {
        System.out.println("call");
    }

    @Override
    public void hangup() {
        System.out.println("hangup");
    }
}

class RichMobile implements Gps,Phone,Camera{

    @Override
    public void track() {
        System.out.println("Rich track");
    }

    @Override
    public void capture() {
        System.out.println("Rich capture");
    }

    @Override
    public void call() {
        System.out.println("Rich call");
    }

    @Override
    public void hangup() {
        System.out.println("Rich hangup");
    }
}

class RichMobileByExtend extends Mobile implements Gps{
    @Override
    public void track() {
        System.out.println("RichEx track");
    }
}
abstract class Abstract{
    void sayHello(){
        System.out.println("Hello");
    }
    abstract void sayHi();
}

class Greeting extends Abstract{
    @Override
    void sayHi() {
        System.out.println("Hi");
    }
}