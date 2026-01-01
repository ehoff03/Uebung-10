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

        for (int r = 0; r < gridRows; r++) {
            for (int c = 0; c < gridCols; c++) {
                gridArray[r][c] = new Cell(r, c, false);
            }
        }

        for (Cell cell : cells) {
            int r = cell.getIndexRow();
            int c = cell.getIndexCol();

            if (r >= 0 && r < gridRows && c < gridCols && c >= 0) {
                gridArray[r][c].setAlive(true);
            }
        }

        for (Cell[] row : gridArray) {
            for (Cell cell: row) {
                cell.countLivingNeighbors(gridArray);
            }
        }
    }

    public void computeNextGen() {
        for (Cell[] row : gridArray) {
            for (Cell cell : row) {
                cell.setAlive(cell.isAliveNextGen());
            }
        }
        for (Cell[] row : gridArray) {
            for (Cell cell: row) {
                cell.countLivingNeighbors(gridArray);
            }
        }
    }

    public void computeGeneration(int n) {
        for (int i = 0; i < n; i++) {
            computeNextGen();
        }
    }
}
