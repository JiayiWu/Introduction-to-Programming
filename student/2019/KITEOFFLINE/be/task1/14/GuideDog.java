public class GuideDog extends Dog implements Guide, Help{
    void bark(){
        System.out.println("Wolf!!Wolf!!");
    }
    void eat(){
        System.out.println("The guide dog is eating.");
    }
    public void guide(){
        System.out.println("The guide dog can guide the blind.");
    }
    public void help(){
        System.out.println("The guide dog help the blind.");
    }

    public static void main(String[] args) {
        GuideDog doggy = new GuideDog();
        doggy.eat();
        doggy.bark();
        doggy.guide();
        doggy.help();
    }
}
