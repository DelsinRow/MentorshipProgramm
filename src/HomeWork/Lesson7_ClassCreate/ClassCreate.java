package HomeWork.Lesson7_ClassCreate;

/**
 * Реализовать класс:
 * как минимум с одним статическим полем,
 * как минимум с одним статическим методом,
 * как минимум один метод должен быть перегружен,
 * как минимум один метод на каждый тип (int,String,boolean,массив),
 * должен быть реализовано как минимум два конструктора.
 */
public class Guest {
    public static void main(String[] args) {
        Student owner = new Student();
        owner.greeting();
        System.out.println();
        Latecomer guest1 = new Latecomer("Marty", 17);
        guest1.greeting();
        Latecomer guest2 = new Latecomer("Dr. Emmett Brown");
        guest2.greeting();
        Latecomer guest3 = new Latecomer();
        guest3.greeting();
        System.out.println();

        Student.howManyGuest(Student.count);
        guest2.beComeAfterMidnight(false);
        Student.passWord("cookie");
        Student.passCode(new int[] {3, 2, 1});
    }
}

class Student {
    public String name;
    int age;
    static int count;

    public void greeting() {
        System.out.println("Welcome! I'm hostel's owner. Identify yourself and say password or passcode");
    }

    public static int oneMoreVisitor() {
        return count++;
    }

    //method with int-type
    public static void howManyGuest(int count) {
        System.out.println(count + " students came hostel after 12 a.m.");
    }

    //method with boolean-type
    public void beComeAfterMidnight(boolean isOwner) {
        if (!isOwner) {
            System.out.println(name + " - won't get through, of course");
        } else {
            System.out.println(name + " - can get through");
        }
    }

    //method with String-type
    public static void passWord(String pass) {
        System.out.println("PassWord is \"" + pass + "\"");
    }

    //method with int[]-type
    public static void passCode(int[] array) {
        System.out.println("PassCode is " + printArray(array) + ". Yes, so easy.");
    }

    public static StringBuilder printArray (int[] array){
        StringBuilder stringArray = new StringBuilder("[");
        for (int i = 0; i < array.length; i++){
            if (i != 0){
                stringArray.append(" ");
            }
            stringArray.append(array[i]);
        }
        stringArray.append("]");
        return stringArray;
    }
}

class Latecomer extends Student{

    //Constructor
    public Latecomer(){
        name = "unnamed person";
        oneMoreVisitor();
    }
    public Latecomer(String name){
        this.name = name;
        oneMoreVisitor();
    }
    public Latecomer(String name, int age){
        this.name = name;
        this.age = age;
        oneMoreVisitor();
    }
    @Override
    public void greeting(){
        System.out.println("Hi! I'm " + name);
    }

}
