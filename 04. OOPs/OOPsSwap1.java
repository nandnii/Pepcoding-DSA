public class OOPsSwap1 {

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
        swap1(p1, p2);
        p1.sayHi();
        p2.sayHi();
    }

    public static void swap1(Person psn1, Person psn2){
        Person temp = psn1;
        psn1 = psn2;
        psn2 = temp;
    }
}

// p1 & p2 didn't get swapped.
// psn1 & psn2 got swapped and that got wiped off as soon swap1 function ended
// it wasn't communicated back to p1 & p2 or main so changes weren't reflected.