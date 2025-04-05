package encapsulationPrac;

class Animal {
    private String name;
    private int leg;
    
    
    public Animal(String name, int leg) {
        this.name = name;
        this.leg = leg;
    }
    
    public String getName() {
        return name;
    }
    public int getLeg() {
        return leg;
    }
    public void setLeg(int leg) {
        if (validataleg(leg))
            this.leg = leg;
    }
    
    private boolean validataleg(int leg) { //외부에서 이 매소드는 알빠임? 매소드닌깐 프라이드로 가리는거임
        return  leg > 0;
    }
}


class main {
    public static void main(String[] args) {
        Animal animal = new Animal("강아지", 2);
        System.out.println(animal.getName());
        System.out.println(animal.getLeg());
        
        animal.setLeg(4);
        System.out.println(animal.getLeg());
    }
}
