/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pathfinder.cw;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String folderPath = "C:\\Users\\DELL\\OneDrive\\Documents\\NetBeansProjects\\Pathfinder cw\\examples";
        String fileName = "maze10_2.txt";
        try {
            Graph graph = TextFile.parseMap(folderPath, fileName);
            List<String> path = ShortestPathFinder.findShortestPath(graph);
            if (path != null) {
                for (int i = 0; i < path.size(); i++) {
                    System.out.println((i + 1) + ". " + path.get(i));
                }
            } else {
                System.out.println("No path exists from start to finish.");
            }
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }
    }
}








