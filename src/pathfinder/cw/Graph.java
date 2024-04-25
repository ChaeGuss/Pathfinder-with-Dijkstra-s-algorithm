/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pathfinder.cw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    char[][] grid; 
    int width; 
    int height;
    Square start;
    Square finish;
    List<Square> rocks;
    
    public Graph(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new char[height][width];
        rocks = new ArrayList<>();
    }
    
    public void setSquare(int x, int y, char type) {
        System.out.println("x: " + x + ", y: " + y + ", width: " + width + ", height: " + height); // Debug statement
        grid[y][x] = type; // Error occurs here
        switch (type) {
            case 'S':
                start = new Square(type, x, y);
                break;
            case 'F':
                finish = new Square(type, x, y);
                break;
            case '0':
                rocks.add(new Square(type, x, y));
                break;
            default:
                break;
        }
    }
    
    public List<Square> getNeighbors(Square square) {
        List<Square> neighbors = new ArrayList<>();

        int x = square.x;
        int y = square.y;

        // Check if neighboring squares are within bounds and are not rocks
        if (x > 0 && grid[y][x - 1] != '0') { // Left
            neighbors.add(new Square(grid[y][x - 1], x - 1, y));
        }
        if (x < width - 1 && grid[y][x + 1] != '0') { // Right
            neighbors.add(new Square(grid[y][x + 1], x + 1, y));
        }
        if (y > 0 && grid[y - 1][x] != '0') { // Up
            neighbors.add(new Square(grid[y - 1][x], x, y - 1));
        }
        if (y < height - 1 && grid[y + 1][x] != '0') { // Down
            neighbors.add(new Square(grid[y + 1][x], x, y + 1));
        }

        return neighbors;
    }
}


