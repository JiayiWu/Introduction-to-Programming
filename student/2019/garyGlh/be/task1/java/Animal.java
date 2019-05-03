public interface Animal{
    public void eat();
}

class Cat implements Animal{
    @Override
    public void eat() {
        System.out.println("Cat eat.");
    }
}

class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("Dog eat.");
    }
}

class Practice{
    public static void main(String[] args){
        Animal animal = new Cat();
        animal.eat();
        animal = new Dog();
        animal.eat();
    }
}