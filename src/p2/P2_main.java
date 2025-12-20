package p2;

public class P2_main {
    public static void main(String[] args) {
        String2 strg = new String2("abc");
        strg.addPostfix("!");
        System.out.println(strg.getMainString());
    }
}
