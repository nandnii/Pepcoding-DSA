public class Constructors{

    // In class, data members & function is encapsulated
    public static class Person{
        int age;
        String name;
        
        void sayHi(){
            System.out.println(name + "[" + age + "] says hi");
        }

        //if we forget to mention this, java provides our class default constructor of same name as class
        // Constructor is  that function that gets made when object of a class of a class is getting created
        Person(){
            // default contructor
        }

        Person(int age, String name){
            // parameterized contructor
            this.age = age;
            this.name = name;
        }
    }

    // p1 & p2 are reference, we can create many references using "Person" class
    // new allocated new space
    // age, name allocated at new spaces are called instances
    public static void main(String[] args){
        // By default constructor
        Person p1 = new Person(); // asa Person() is hit, space gets allocated (4k) with default values, here 0, null
        p1.age = 23;
        p1.name="Nandni";
        p1.sayHi();

        // By parameterized constructor
        // asa Person() is hit, space gets allocated (5k)
        // this.age = 5k wala age
        // age (22) gets passed to parameterized constructor
        Person p2 = new Person(22, "Rahul");
        p2.sayHi();
    }
}