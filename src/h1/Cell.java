package h1;

public class Cell {
    private int indexRow;
    private int indexCol;
    private boolean alive;
    private int numLivingNeighbors;
    private boolean isAliveNextGen;

    public void setIndexRow(int indexRow) {
        this.indexRow = indexRow;
    }

    public void setIndexCol(int indexCol) {
        this.indexCol = indexCol;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setNumLivingNeighbors(int numLivingNeighbors) {
        this.numLivingNeighbors = numLivingNeighbors;
    }

    public void setAliveNextGen(boolean aliveNextGen) {
        isAliveNextGen = aliveNextGen;
    }

    public int getIndexRow() {
        return indexRow;
    }

    public int getIndexCol() {
        return indexCol;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getNumLivingNeighbors() {
        return numLivingNeighbors;
    }

    public boolean isAliveNextGen() {
        return isAliveNextGen;
    }

    public Cell(int indexRow, int indexCol, boolean alive) {
        setIndexRow(indexRow);
        setIndexCol(indexCol);
        setAlive(alive);
    }
    public Cell(int indexRow, int indexCol) {
        setIndexRow(indexRow);
        setIndexCol(indexCol);
    }

    public void countLivingNeighbors(Cell[][] gridArray) {
        int counter = 0;

        for (int r = getIndexRow() - 1; r <= getIndexRow() + 1; r++) {
            for (int c = getIndexCol() - 1; c <= getIndexCol() + 1; c++) {
                if (r < 0 || c < 0 || r >= gridArray.length || c >= gridArray[r].length) {
                    continue;
                }
                if (r == getIndexRow() && c == getIndexCol()) {
                    continue;
                }
                if (gridArray[r][c].isAlive()) {
                    counter++;
                }
            }
        }
        setNumLivingNeighbors(counter);
        decideNextStatus();
    }

    private void decideNextStatus() {
        if (isAlive()) {
            setAliveNextGen(getNumLivingNeighbors() == 2 || getNumLivingNeighbors() == 3);
        } else {
            setAliveNextGen(getNumLivingNeighbors() == 3);
        }
    }
}
