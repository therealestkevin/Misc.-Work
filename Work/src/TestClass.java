public class TestClass {

    private String var1 = "none";

    private static String var2 = "empty";

 

    public TestClass() {

        var1 = "start";

        var2 = "begin";

    }

 

    public TestClass(String var1) {

        var1 = var1;

        var2 = var1;

    }

 

    public String getVar1() {

        return var1;

    }

 

    public String getVar2() {

        return var2;

    }

    public void Fee() {

        var1 = "fee";

    }

 

    public void Fi(int n) {

        if (n == 1) {

          var1 = "fi";

        } else {

          var2 = "fi";

        }

    }

 

    public void Foe() {

        var2 = "foe";

    }

 

    public void Fum() {

        var1 = var2;

        var2 = "fum";

    }

}