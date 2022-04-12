//Time Complexity O(NLog K)
//Space Complexity O(k)
//LeetCode tested

import java.util.*;

public class FindKClosestElements {
    public class Pair implements  Comparable<Pair>{
        int val;
        int gap;

        Pair(int val,int gap){
            this.val = val;
            this.gap = gap;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.gap == o.gap){
                return this.val - o.val;
            }else{
                return this.gap-o.gap;
            }
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            if(pq.size()<k){
                pq.add(new Pair(arr[i],Math.abs(x-arr[i])));
            }else{
                if(pq.peek().gap > Math.abs(arr[i]-x)){
                    pq.remove();
                    pq.add(new Pair(arr[i],Math.abs(x-arr[i])));
                }
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(0);
        }
        for (int i = k-1; i >=0 ; i--) {
            list.set(i,pq.poll().val);
        }

        return  list;
    }
}
