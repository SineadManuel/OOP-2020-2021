package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {
    // board size
    int size = 100;

    // width & height of each cell on screen
    float cellSize;

    // 2D array - [rows][col]
    boolean[][] board = new boolean[size][size];

    public int countCellsAround(int row, int col) {
        int count = 0;

        // Use getCell here!
        for(int r = row - 1; r <= row + 1; r++) {
            for(int c = col - 1; c <= col + 1; c++) {
                if(r != row  && c != col) {
                    if(getCell(board, r, c)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    // set cell at position row and col
    public void setCell(boolean[][] board, int row, int col, boolean b) {

        // ensures row and col are within the bounds of the array
        if(row > 0 && row < size - 1 && col > 0 && col < size - 1) {
            board[row][col] = b;
        }
    } // end setCell

    // return cell at position row and col
    public boolean getCell(boolean[][] board, int row, int col) {
        if(row > 0 && row < size - 1 && col > 0 && col < size - 1) {
            return board[row][col];
        }
        else {
            return false;
        }
    } // end getCell

    public void drawBoard(boolean[][] board) {
        // Use a nested loop
        // Use map to calculate x and y
        // Rect draw the cell
        // Use the cell size variable
        // Use some colours!
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                // height of cell
                float x = map(col, 0, size, 0, width);

                // width of cell
                float y = map(row, 0, size, 0, height);
                
                // Without using maps
                // float x = col * cellSize;
                // float y = row * cellSize;

                if(board[row][col]) {
                    rect(x, y, cellSize, cellSize);
                }
                
            }
        }
    } // end drawBoard

    private void printBoard(boolean[][] board) {
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                print(board[row][col] ? 1 : 0);
            }

            println();
        }
    }

    public void randomized() {
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                float dice = random(0.0f, 1.0f); // (low, high)

                if(dice < 0.5) {
                    board[row][col] = true;
                }
                else {
                    board[row][col] = false;
                }

                // In-line if statment:
                board[row][col] = (dice < 0.5f) ? true : false;
            } // end for col
        } // end for row
    } // end randomized

    // Size of window
    public void settings() {
        size(500, 500);
    }
    
    int mode = 0;
    public void keyPressed() {
        // the value of mode will be the number of the
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    // Initialises variables
    public void setup() {
        colorMode(RGB);
        //randomized();
        board[0][1] = true;
        board[1][2] = true;
        board[3][2] = true;
        printBoard(board);

        println(countCellsAround(0, 2));
        
        // Size of each individual cell
        cellSize =  width / size;
    }


    public void draw() {
        background(0);
        drawBoard(board);
    }
}
