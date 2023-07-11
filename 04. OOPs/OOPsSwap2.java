public class OOPsSwap2 {

    public static class Person{
        int age;
        String name;
        
        void sayHi(){
            System.out.println(name + "[" + age + "] says hi");
        }
    }

    public static void main(String[] args){
        // 1st reference & 1st instance
        Person p1 = new Person();
        p1.age = 23;
        p1.name="Nandni";
        // p1.sayHi();

        // 2nd reference & 2nd instance
        Person p2 = new Person();
        p2.age = 22;
        p2.name="Rahul";
        // p2.sayHi();

        p1.sayHi();
        p2.sayHi();
        swap2(p1, p2);
        p1.sayHi();
        p2.sayHi();
    }

    public static void swap2(Person psn1, Person psn2){
        int age = psn1.age;
        psn1.age = psn2.age;
        psn2.age = age;

        String name = psn1.name;
        psn1.name = psn2.name;
        psn2.name = name;
    }
}

// Change happens cause these changes are happening in heap so their bubble (specific) value is changing