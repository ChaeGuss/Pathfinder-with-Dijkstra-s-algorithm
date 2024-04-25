/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pathfinder.cw;

/**
 *
 * @author DELL
 */
import java.io.IOException;
import java.util.*;

public class ShortestPathFinder {

    public static List<String> findShortestPath(Graph graph) {
        // Initialize distances
        int[][] distance = new int[graph.height][graph.width];
        for (int i = 0; i < graph.height; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        // Initialize start square distance to 0
        distance[graph.start.y][graph.start.x] = 0;

        // Priority queue to store squares based on distance
        PriorityQueue<Square> pq = new PriorityQueue<>(Comparator.comparingInt(a -> distance[a.y][a.x]));
        pq.offer(graph.start);

        // Parent map to store parent squares for backtracking
        Map<Square, Square> parent = new HashMap<>();

        // Perform Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Square current = pq.poll();

            // Stop if finish square is reached
            if (current == graph.finish) {
                break;
            }

            // Explore neighbors
            for (Square neighbor : graph.getNeighbors(current)) {
                int newDistance = distance[current.y][current.x] + 1; // Since all weights are 1
                if (newDistance < distance[neighbor.y][neighbor.x]) {
                    distance[neighbor.y][neighbor.x] = newDistance;
                    pq.offer(neighbor);
                    parent.put(neighbor, current);
                }
            }
        }

        // Reconstruct path if finish square is reached
        if (!parent.containsKey(graph.finish)) {
            return null; // No path exists
        }

        List<String> path = new ArrayList<>();
        Square current = graph.finish;
        while (current != graph.start) {
            path.add(0, "Move to (" + (current.x + 1) + "," + (current.y + 1) + ")");
            current = parent.get(current);
        }
        path.add(0, "Start at (" + (graph.start.x + 1) + "," + (graph.start.y + 1) + ")");
        return path;
    }

    public static void main(String[] args) {
        String folderPath = "C:\\Users\\DELL\\OneDrive\\Documents\\NetBeansProjects\\Pathfinder cw\\examples";
        String fileName = "maze10_2.txt";
        try {
            Graph graph = TextFile.parseMap(folderPath, fileName);
            List<String> path = findShortestPath(graph);
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

