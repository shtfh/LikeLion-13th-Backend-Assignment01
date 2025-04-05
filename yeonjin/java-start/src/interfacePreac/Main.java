package interfacePreac;

interface Animal {
    void sound();
    void move();
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("멍멍");
    }

    @Override
    public void move() {
        System.out.println("강아지가 뛰어요");
    }
}

 class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();
        dog.move();
    }
}
