package p1;

public class P1_main {
    public static void main(String[] args) {
        Betrag a = new Betrag(7, 373);
        Betrag b = new Betrag(3,27);

        System.out.println("Euros: " + summe(a, b).getEuro() + ", Cent: " + summe(a, b).getCent());
    }
    public static Betrag summe(Betrag a, Betrag b) {
        Betrag c = new Betrag(0, 0);
        c.setEuro(a.getEuro() + b.getEuro());
        c.setCent(a.getCent() + b.getCent());
        return c;
    }
}
