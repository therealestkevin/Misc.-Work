public class Question4 {

    public static void main(String[] args) {

       TestClass class1 = new TestClass();

       TestClass class2 = new TestClass("class2");

       System.out.println("a: " + class2.getVar1() + " " + class2.getVar2());

 

       class1.Fee();

       class2.Fum();

       System.out.println("b: " + class1.getVar1() + " " + class1.getVar2());

 

    class2.Fi(2);

    class1.Foe();

    System.out.println("c: " + class2.getVar1() + " " + class2.getVar2());

 

    new TestClass();

    class1.Fum();

    System.out.println("d: " + class1.getVar1() + " " + class2.getVar2());

    }

}