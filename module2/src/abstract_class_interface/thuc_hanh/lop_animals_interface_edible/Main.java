package abstract_class_interface.thuc_hanh.lop_animals_interface_edible;

public class Main {
    public static void main(String[] args) {
        Animal[] animals=new Animal[2];
        animals[0]= new Tiger();
        animals[1]= new Chicken();
        for (Animal element:animals){
            System.out.println(element.makeSound());
            if (element instanceof Chicken) {
                Edible edibler = (Chicken) element;
                System.out.println(edibler.howToEat());
            }
        }
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }


}
