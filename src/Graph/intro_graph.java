package Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class intro_graph {
    public void matrix_graph(int n, int m){
        int adj[][]= new int[n+1][m+1];
        Scanner x = new Scanner(System.in);
        for (int i = 0; i < m; i++) {
            int u , v;
            u = x.nextInt();
            v = x.nextInt();
            // you are marking co-ordinates as 1
            adj[u][v] = 1;
            adj[v][u] = 1;
        }
    }
    //SPACE COMPLEXITY = O(3N)
    public ArrayList<Integer> bfs (int V , ArrayList<ArrayList<Integer>> adj){
        // create a bfs list storage
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis [] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0]= true;
        while (!q.isEmpty()){
            //q.poll shows the top element that is initially 0
            Integer node = q.poll();
            //added in bfs
            bfs.add(node);

            for(Integer it : adj.get(node)){
                //check first if its visited or not if not then mark it true and then add it to bfs
                if(vis[it] == false){
                    //before adding add it as
                    vis[it] = true;
                    q.add(node);
                }
            }
        }
        return bfs;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //DFS

   static int provinces(ArrayList<ArrayList<Integer>>adj,int V){
       ArrayList<ArrayList<Integer>> adjls = new ArrayList<ArrayList<Integer>>();
       for (int i = 0; i < V; i++) {
           adjls.add(new ArrayList<>());
       }
       for (int i = 0; i < V; i++) {
           for (int j = 0; j < V; j++) {
               if(adj.get(i).get(j)==1 && i!=j){
                   adjls.get(i).add(j);
                   adjls.get(j).add(i);
               }
           }
       }
       int vis[] = new int[V];
       int cnt = 0;
       for (int i = 0; i < V; i++) {
           if(vis[i] == 0){
               cnt++;
               dfs(i, adjls,vis);
           }
       }
       return cnt;
   }
   private static void dfs(int node, ArrayList<ArrayList<Integer>> adjls, int vis[]){
       vis[node] = 1;
       for(Integer it : adjls.get(node)){
           if(vis[it]==0){
               dfs(it, adjls, vis);
           }
       }
    }

    public int numIsland(char [][] grid){
       int n = grid.length;
       int m = grid[0].length;
       int [][] vis = new int [n][m];
       int cnt = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if(vis[n][m] == 0 && grid[n][m] == '1'){
                    cnt++;
                    bfs(row,col,vis,grid);
                }
            }
        }
        return cnt;
    }

    private void bfs(int ro , int co , int [][] vis , char [][]grid){
        vis[ro][co] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(ro,co));
        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for (int delrow = -1; delrow < 1; delrow++) {
                for (int delcol = -1; delcol < 1; delcol++) {
                    int nrow = row + delrow;
                    int ncol = row + delcol;
                    if(nrow >=0 && nrow < n && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0){
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }


}
class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first= first;
        this.second = second;
    }
}