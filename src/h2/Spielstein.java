package h2;

public class Spielstein {
    private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public Spielbrett getBrett() {
        return brett;
    }

    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        setCurrentRow(indexRow);
        setCurrentCol(indexCol);
        setBrett(brett);
    }

    private boolean movesOut() {
        char dir = brett.getBrett()[getCurrentRow()][getCurrentCol()].getDirection();

        if (dir == 'U') {
            return (getCurrentRow() == 0);
        } else if (dir == 'D'){
            return (getCurrentRow() == brett.getDim() - 1);
        } else if (dir == 'L') {
            return (getCurrentCol() == 0);
        } else if (dir == 'R') {
            return (getCurrentCol() == brett.getDim() - 1);
        }
        return false;
    }

    public void go(int n) {
        for (int i = 0; i < n; i++) {
            Feld feld = brett.getBrett()[getCurrentRow()][getCurrentCol()];

            if (movesOut() || feld.isBoese()) {
                break;
            }

            char dir = feld.getDirection();

            if (dir == 'U') {
                setCurrentRow(getCurrentRow() - 1);
            } else if (dir == 'D'){
                setCurrentRow(getCurrentRow() + 1);
            } else if (dir == 'L') {
                setCurrentCol(getCurrentCol() - 1);
            } else if (dir == 'R') {
                setCurrentCol(getCurrentCol() + 1);
            }
        }
    }
}
