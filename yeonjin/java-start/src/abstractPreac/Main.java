package abstractPreac;

abstract class Animal {
    String name;

    public void  sleep() {
        System.out.println( name+ "이 자고 있습니다. ");
    }

    public abstract void sound();

}

class Dog extends Animal {
    Dog(String name) {
        this.name = name;
    }
    @Override
    public  void  sound() {
        System.out.println( name + "가 머멈 소리를 냅니다,");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("강아지");
        dog.sound();
        dog.sleep();
    }
}
