/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pathfinder.cw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFile {
    public static Graph parseMap(String folderPath, String fileName) throws IOException {
        String filePath = folderPath + "\\" + fileName;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int width = 0;
        List<String> lines = new ArrayList<>(); // Store lines of the input file
        Graph graph = null;

        // Read lines of the input file and store them in the list
        while ((line = reader.readLine()) != null) {
            lines.add(line);
            // Update width if not set
            if (width == 0) {
                width = line.length();
                System.out.println("Width: " + width); // Debug statement
            }
        }
        reader.close();

        // Create the graph using the width and the number of lines
        graph = new Graph(width, lines.size());

        // Iterate over the lines to set squares in the graph
        for (int y = 0; y < lines.size(); y++) {
            line = lines.get(y);
            for (int x = 0; x < width; x++) {
                char type = line.charAt(x);
                graph.setSquare(x, y, type);
                
                if (type == 'S' || type == 'F' || type == '0') {
                    System.out.println("Location of " + type + ": x = " + x + ", y = " + y);
                }
            }
        }

        return graph;
    }
}

