package p1;

public class Betrag {
    private int euro;
    private int cent;

    public int getEuro() {
        return euro;
    }
    public int getCent() {
        return cent;
    }
    public void setEuro(int euro) {
        this.euro = euro;
    }
    public void setCent(int cent) {
        if (cent/100 >= 1) {
            setEuro(this.euro + (int) cent/100);
            this.cent = cent - ((int) cent/100 * 100);
        } else {
            this.cent = cent;
        }
    }
    public Betrag(int euro, int cent) {
        setEuro(euro);
        setCent(cent);
    }
}
