package access_modifier_static_proprety_static_method.thuc_hanh;
class Car {

    private String name;

    private String engine;

    public static int numberOfCars = 0;

    public Car(String name, String engine) {

        this.name = name;

        this.engine = engine;

        numberOfCars++;

    }
}

    public class StaticProperty {
        public static void main(String[] args) {
            Car car1 = new Car("Mazda 3", "Skyactiv 3");
            Car car2 = new Car("Mazda 6", "Skyactiv 6");

            System.out.println(Car.numberOfCars);

        }
    }
