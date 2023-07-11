public class OOPs{

    // In class, data members & function is encapsulated
    public static class Person{
        int age;
        String name;
        
        void sayHi(){
            System.out.println(name + "[" + age + "] says hi");
        }
    }

    // p1 & p2 are reference, we can create many references using "Person" class
    // new allocated new space
    // age, name allocated at new spaces are called instances
    public static void main(String[] args){
        // 1st reference & 1st instance
        Person p1 = new Person();
        p1.age = 23;
        p1.name="Nandni";
        p1.sayHi();

        // 2nd reference & 2nd instance
        Person p2 = new Person();
        p2.age = 22;
        p2.name="Rahul";
        p2.sayHi();

        // 3rd reference & 2nd instance
        Person p3 = p1;
        p3.age = 30;
        p3.sayHi();
        p1.sayHi();
    }
}