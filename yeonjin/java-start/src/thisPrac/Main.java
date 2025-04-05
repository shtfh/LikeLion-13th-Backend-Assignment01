package thisPrac;

class Animal {
    String name;
    int leg;

    //생성자
    public Animal(String name, int leg) {
        this.name = name;
        this.leg = leg;
    }
}
class Main{
    public static void main(String[] args) {
        Animal animal = new Animal("강아지", 2);

        animal.leg = 4;
        System.out.println("animal 이름: " + animal.name+ ",animal 다리수 : " + animal.leg);

    }

}
