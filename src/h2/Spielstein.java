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
        return dir == 'U' || dir == 'D' || dir == 'L' || dir == 'R';
    }

    public void go(int n) {
        for (int i = 0; i < n; i++) {
            Feld feld = brett.getBrett()[getCurrentRow()][getCurrentCol()];

            if (feld.isBoese()) {
                break;
            } else {
                char dir = feld.getDirection();

                int newRow = getCurrentRow();
                int newCol = getCurrentCol();

                if (dir == 'U') {
                    newRow++;
                } else if (dir == 'D') {
                    newRow--;
                } else if (dir == 'L') {
                    newCol--;
                } else if (dir == 'R') {
                    newCol++;
                }

                if (newRow < 0 || newRow >= brett.getDim() ||
                        newCol < 0 || newCol >= brett.getDim()) {
                    break;
                } else {
                    setCurrentRow(newRow);
                    setCurrentCol(newCol);
                }
            }
        }
    }
}
