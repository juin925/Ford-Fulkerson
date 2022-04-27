package fordfulkerson;
 
import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
    static class Graph {
        int value;
        int graph[][];

        public Graph(int value, int[][] graph) {
            this.value = value;
            this.graph = graph;
        }

        public int findMaxFlow(int source, int sink) {
            int[][] residualGraph = new int[value][value];

            for (int i = 0; i <value ; i++) {
                for (int j = 0; j <value ; j++) {
                    residualGraph[i][j] = graph[i][j];
                }
            }

            int [] parent = new int[value];

            int max_flow = 0; 

            while(isPathExist_BFS(residualGraph, source, sink, parent)){
                int flow_capacity = Integer.MAX_VALUE;
                int t = sink;
                while(t!=source){
                    int s = parent[t];
                    flow_capacity = Math.min(flow_capacity, residualGraph[s][t]);
                    t = s;
                }
                t = sink;
                while(t!=source){
                    int s = parent[t];
                    residualGraph[s][t]-=flow_capacity;
                    residualGraph[t][s]+=flow_capacity;
                    t = s;
                }
                max_flow+=flow_capacity;
            }
            return max_flow;
        }

        public boolean isPathExist_BFS(int [][] residualGraph, int src, int dest, int [] parent){
            boolean pathFound = false;
            boolean [] visited = new boolean[value];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(src);
            parent[src] = -1;
            visited[src] = true;

            while(queue.isEmpty()==false){
                int u = queue.poll();
                for (int v = 0; v <value ; v++) {
                    if(visited[v]==false && residualGraph[u][v]>0) {
                        queue.add(v);
                        parent[v] = u;
                        visited[v] = true;
                    }
                }
            }
            pathFound = visited[dest];
            return pathFound;
        }
    }

    public static void main(String[] args) {
    	int vertices = 6;
        int graph[][] = { {0, 10, 8, 0, 0, 0},
                {0, 0, 5, 5, 0, 0},
                {0, 4, 0, 0, 10, 0},
                {0, 0, 9, 0, 10, 3},
                {0, 0, 0, 6, 0, 14},
                {0, 0, 0, 0, 0, 0}
        };
        Graph g = new Graph(vertices, graph);
        int source = 1;
        int sinc = 4;
        int max_flow = g.findMaxFlow(source,sinc);
        System.out.println("시작점 " + source + " 에서 도착점 " + sinc + " 까지 최대유량은 " + max_flow);
    }
}