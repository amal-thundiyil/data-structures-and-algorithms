import java.util.*;
import java.io.*;
import java.lang.*;

public class Main2 {
    static final int totalVertex = 9;

    int minimumDistance(int distance[], Boolean spSet[]) {
        // Initialize min value
        int m = Integer.MAX_VALUE, m_index = -1;

        for (int vx = 0; vx < totalVertex; vx++) {
            if (spSet[vx] == false && distance[vx] <= m) {
                m = distance[vx];
                m_index = vx;
            }
        }
        return m_index;

    }

    // A utility method to display the built distance array
    void printSolution(int distance[], int n) {
        System.out.println("The shortest Distance from source 0th node to all other nodes are: ");
        for (int j = 0; j < n; j++)
            System.out.println("To " + j + " the shortest distance is: " + distance[j]);
    }

    void dijkstra(int graph[][], int s) {
        int distance[] = new int[totalVertex]; // The output array distance[i] holds the shortest distance from source s
                                               // to j

        Boolean spSet[] = new Boolean[totalVertex];
        for (int j = 0; j < totalVertex; j++) {
            distance[j] = Integer.MAX_VALUE;
            spSet[j] = false;
        }

        distance[s] = 0;

        for (int cnt = 0; cnt < totalVertex - 1; cnt++) {
            int ux = minimumDistance(distance, spSet);
            spSet[ux] = true;

            for (int vx = 0; vx < totalVertex; vx++)

                // Update distance[vx] if and only if it is not in the spSet, there is an
                // edge from ux to vx, and the total weight of path from source s to
                // vx through ux is lesser than the current value of distance[vx]
                if (!spSet[vx] && graph[ux][vx] != -1 && distance[ux] != Integer.MAX_VALUE
                        && distance[ux] + graph[ux][vx] < distance[vx]) {
                    distance[vx] = distance[ux] + graph[ux][vx];
                }
        }

        // display the build distance array
        printSolution(distance, totalVertex);
    }

    // main method
    public static void main(String argvs[]) {
        // A 9 * 9 matrix is created.
        // arr[x][y] = - 1 means, there is no any edge that connects the nodes x and y
        // directly
        int grph[][] = new int[][] { { -1, 3, -1, -1, -1, -1, -1, 7, -1 },
                { 3, -1, 7, -1, -1, -1, -1, 10, 4 },
                { -1, 7, -1, 6, -1, 2, -1, -1, 1 },
                { -1, -1, 6, -1, 8, 13, -1, -1, 3 },
                { -1, -1, -1, 8, -1, 9, -1, -1, -1 },
                { -1, -1, 2, 13, 9, -1, 4, -1, 5 },
                { -1, -1, -1, -1, -1, 4, -1, 2, 5 },
                { 7, 10, -1, -1, -1, -1, 2, -1, 6 },
                { -1, 4, 1, 3, -1, 5, 5, 6, -1 } };

        // creating an object of the class DijkstraExample
        Main2 obj = new Main2();
        obj.dijkstra(grph, 0);
    }
}