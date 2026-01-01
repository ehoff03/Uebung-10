package h1;

public class H1_main {

    public static void main(String[] args) {

        // Startzellen (Blinker-Muster)
        Cell[] startCells = {
                new Cell(0, 0, true),
                new Cell(1, 1, true),
                new Cell(2, 2, true),
                new Cell(3, 3, true),
                new Cell(4, 4, true)
        };

        // Grid erstellen (5x5)
        Grid grid = new Grid(startCells, 5, 5);

        System.out.println("Generation 0:");
        printGrid(grid);

        // Nächste Generation
        grid.computeNextGen();
        System.out.println("\nGeneration 1:");
        printGrid(grid);

        // Noch eine Generation
        grid.computeNextGen();
        System.out.println("\nGeneration 2:");
        printGrid(grid);

        // Noch eine Generation
        grid.computeNextGen();
        System.out.println("\nGeneration 3:");
        printGrid(grid);
    }

    // Hilfsmethode zum Anzeigen des Grids
    private static void printGrid(Grid grid) {
        Cell[][] array = grid.getGridArray();

        for (Cell[] row : array) {
            for (Cell cell : row) {
                System.out.print(cell.isAlive() ? "X " : ". ");
            }
            System.out.println();
        }
    }
}
