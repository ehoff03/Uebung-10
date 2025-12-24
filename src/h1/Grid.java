package h1;

public class Grid {
    private Cell[][] gridArray;

    public Cell[][] getGridArray() {
        return gridArray;
    }
    public void setGridArray(Cell[][] gridArray) {
        this.gridArray = gridArray;
    }
    public Grid(Cell[] cells, int gridRows, int gridCols) {
        setGridArray(new Cell[gridRows][gridCols]);
        for (int rowIndex = 0; rowIndex < gridRows; rowIndex++) {
            for (int colIndex = 0; colIndex < gridCols; colIndex++) {
                gridArray[rowIndex][colIndex] = new Cell(rowIndex, colIndex, false);
            }
        }
        for (Cell cell : cells) {
            int rowIndex = cell.getIndexRow();
            int colIndex = cell.getIndexCol();
            if ((rowIndex >= 0) && (rowIndex < gridRows) && (colIndex < gridCols) && (colIndex >= 0)) {
                gridArray[rowIndex][colIndex].setAlive(true);
            }
        }
        for (int rowIndex = 0; rowIndex < gridRows; rowIndex++) {
            for (int colIndex = 0; colIndex < gridCols; colIndex++) {
                gridArray[rowIndex][colIndex].countLivingNeighbors(gridArray);
            }
        }
    }
    public void computeNextGen() {
        for (int rowIndex = 0; rowIndex < gridArray.length; rowIndex++) {
            for (int colIndex = 0; colIndex < gridArray[rowIndex].length; colIndex++) {
                gridArray[rowIndex][colIndex].setAlive(gridArray[rowIndex][colIndex].isAliveNextGen());
            }
        }
        for (int rowIndex = 0; rowIndex < gridArray.length; rowIndex++) {
            for (int colIndex = 0; colIndex < gridArray[rowIndex].length; colIndex++) {
                gridArray[rowIndex][colIndex].countLivingNeighbors(gridArray);
            }
        }
    }
    public void computeGeneration(int n) {
        for (int i = 0; i < n; i++) {
            computeNextGen();
        }
    }
}
