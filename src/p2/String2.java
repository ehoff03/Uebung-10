package p2;

public class String2 implements Editable{
    private String mainString;

    public void setMainString(String mainString) {
        this.mainString = mainString;
    }
    public String getMainString() {
        return mainString;
    }

    public String2(String s) {
        setMainString(s);
    }

    public void addPrefix(String s) {
        setMainString(s + mainString);
    }
    public void addPostfix(String s) {
        setMainString(mainString + s);
    }
}
