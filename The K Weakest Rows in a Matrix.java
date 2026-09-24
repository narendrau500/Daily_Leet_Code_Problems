
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>(
            (a,b)->{
                if(a[0]!=b[0]){
                    return b[0]-a[0];

                }
                return b[1]-a[1];
            }
        );
        int i=0;
        for(int[] r:mat){
            int count=cnt(r);
            maxHeap.offer(new int[]{count,i});
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
            i++;
        }
        int[] r=new int[k];
        for(int j=k-1;j>=0;j--){
            r[j]=maxHeap.poll()[1];
        }
        return r;
    }
    private int cnt(int[] r){
        int c=0;
        for(int i=0;i<r.length;i++){
            if(r[i]==0){
                break;
            }
            c++;
        }
        return c;
    }
}