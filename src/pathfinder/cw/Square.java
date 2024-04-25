/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pathfinder.cw;

public class Square {
    char type; 
    int x; 
    int y;
    
    boolean playerPosition;
    int distance;
    Square previous; // New field to store the previous square
    
    public Square(char type, int x, int y){
        this.type = type;
        this.x = x;
        this.y = y;
        this.playerPosition = false;
        this.previous = null; // Initialize previous square to null
    }
    
    public char getType() {
        return type;
    }
    
    public boolean isPlayerPosition() {
        return playerPosition;
    }
    
    public void setPlayerPosition(boolean playerPosition) {
        this.playerPosition = playerPosition;
    }
    
    @Override
    public String toString() {
        if (playerPosition) {
            return "@";
        } else {
            return String.valueOf(type);
        }
    }
}
