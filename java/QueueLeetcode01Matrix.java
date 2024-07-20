package java;
import java.util.ArrayDeque;
import java.util.Queue;

public class QueueLeetcode01Matrix {
    private void check(Queue<Integer> q, int[][] mat, int[][] dist, int py, int px, int y, int x){
        int h = mat.length;
        int w = mat[0].length;
        if(y<0||y>=h) return;
        if(x<0||x>=w) return; 
        if(dist[y][x]>dist[py][px] + 1) {
            dist[y][x] = dist[py][px]+1;
            q.add(y);
            q.add(x);
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int h = mat.length;
        int w = mat[0].length;
        int[][] dist = new int[h][w];

        Queue<Integer> q = new ArrayDeque<>();
        for(int y=0;y<h;y++)for(int x=0;x<w;x++)dist[y][x]=Integer.MAX_VALUE;
        for(int y=0;y<h;y++)for(int x=0;x<w;x++){
            if(mat[y][x]==0) {
                dist[y][x]=0;
                q.add(y);q.add(x);
            }
        }
        while(q.size()>0){
            int cy = q.poll();
            int cx = q.poll();
            check(q,mat,dist,cy,cx,cy-1, cx);
            check(q,mat,dist,cy,cx,cy+1, cx);
            check(q,mat,dist,cy,cx,cy, cx-1);
            check(q,mat,dist,cy,cx,cy, cx+1);
        }
        return dist;
    }    
}
