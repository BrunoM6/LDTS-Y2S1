package com.aor.minesweeper.model.game.board;

import com.aor.minesweeper.model.game.elements.Cell;
import com.aor.minesweeper.model.game.elements.ClockModel;

public class Board {
    private Cell[][] grid;
    private ClockModel clock;
    private int width;
    private int height;
    private int numMines;
    private int current_col;
    private int current_row;
    private boolean first_time;

    public Board(int width, int height, int numMines,ClockModel clock) {
        this.width = width;
        this.height = height;
        this.numMines = numMines;
        this.grid = new Cell[height][width];
        this.current_col = 0;
        this.current_row = 0;
        this.clock = clock;
        this.first_time = true;
        initializeBoard();
    }
    public int getCurrent_col(){
        return current_col;
    }
    public int getCurrent_row(){
        return current_row;
    }
    public void setCurrent_col(int col){
        this.current_col = col;
    }
    public void setCurrent_row(int row){
        this.current_row = row;
    }
    public boolean isSelected(int col, int row){
        if(current_row == row & current_col == col)return true;
        return false;
    }
    public Cell getCurrentCell() {
        if (isValidPosition(current_row, current_col)) {
            return grid[current_row][current_col];
        } else {
            // Return null or handle out-of-bounds case according to your logic
            return null;
        }
    }
    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < height && col >= 0 && col < width;
    }
    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void initializeBoard() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                grid[row][col] = new Cell(); // Initialize with default Cell
            }
        }
    }

    public void placeMines() {
        int minesPlaced = 0;
        while (minesPlaced < numMines) {
            int row = (int) (Math.random() * height);
            int col = (int) (Math.random() * width);
            if (!grid[row][col].isMine()) {
                if(grid[row][col] == getCurrentCell())continue;
                grid[row][col].setMine(true);
                minesPlaced++;
            }
        }
    }

    public void calculateAdjacentMines() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (!grid[row][col].isMine()) {
                    int count = countAdjacentMines(row, col);
                    grid[row][col].setAdjacentMines(count);
                }
            }
        }
    }
    public boolean isFirst_time(){
        return first_time;
    }
    public void setFirst_time(boolean first_time) {
        this.first_time = first_time;
    }
    public int countFlags(){
        int count = 0;
        for(int row = 0;row < height;row++){
            for(int col = 0; col < width; col++){
                if(grid[row][col].isFlagged())count++;
            }
        }
        return count;
    }

    public int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (isWithinGrid(row + i, col + j) && grid[row + i][col + j].isMine()) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isWithinGrid(int row, int col) {
        return row >= 0 && row < height && col >= 0 && col < width;
    }
    public Cell getCell(int row, int col) {
        return grid[row][col];
    }
    public void setCell(int row, int col, Cell cell){grid[row][col] = cell;}
    public int getNumMines(){
        return numMines;
    }
    public ClockModel getClock(){
        return clock;
    }

}