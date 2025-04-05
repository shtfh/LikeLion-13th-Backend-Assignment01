package polyPreac;

class Animal {
    public void  sound() {
        System.out.println("동물 소리");
    }
}

class  Dog extends Animal {
    @Override
    public void  sound() {
        System.out.println("멍멍");
    }
}

class  Cat extends Animal {
    @Override
    public void  sound() {
        System.out.println("냐용");

    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.sound();
        cat.sound();
    }
}
