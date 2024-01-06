package com.amrita.jpl.cys21012.project;


import java.util.*;

public class JavaCP
{
    ArrayList<ArrayList<Integer>> g ;
    boolean vis[] ;

    int n,m;
    int[][][] gph;

    int[] from,to,wt;
    long[]cost ;


    static class pair implements Comparable < pair > {
        long x;
        long y;
        pair(long i, long j) {
            x = i;
            y = j;
        }
        public int compareTo(pair p) {
            if (this.x != p.x) {
                return Long.compare(this.x,p.x);
            } else {
                return Long.compare(this.y,p.y);
            }
        }
        public int hashCode() {
            return (x + " " + y).hashCode();
        }
        public String toString() {
            return x + " " + y;
        }
        public boolean equals(Object o) {
            pair x = (pair) o;
            return (x.x == this.x && x.y == this.y);
        }
    }

    // *Breadth First Search*
    public void bfs(int s, int[][] g){
        LinkedList<pair> q = new LinkedList<>();
        boolean[] vis= new boolean[g.length];
        int[] dist = new int[g.length];
        q.add(new pair(s,0));
        dist[0] = -1;
        while(!q.isEmpty()){
            pair p = q.pollFirst();
            int vertex = (int)p.x;
            int parent = (int)p.y ;

            if(vis[vertex]) continue ;
            vis[vertex] = true ;
            dist[vertex] = dist[parent] +1 ;

            for(int x:g[vertex]){
                q.add(new pair(x,vertex));
            }
        }
    }


    // *Depth First Search*
    public void dfs(int s,int p, int[][] g){
        if(vis[s]) return ;
        vis[s] = true ;
        for(int x: g[s]){
            if(x==p) continue ;
            dfs(x,s,g);
        }
    }


    // *Dijsktra*
    public void dijsktra(){
        cost=new long[n+1];
        cost[1]=0;
        boolean vis[]=new boolean[n+1];
        PriorityQueue<pair> pq=new PriorityQueue<>();
        pq.add(new pair(0,1));
        while(!pq.isEmpty()){
            // dbg(pq);
            pair p=pq.poll();
            int vertex = (int)p.y;
            long weight= p.x ;
            if(vis[vertex]) continue;
            vis[vertex]=true;
            cost[vertex]=p.x;
            for(int[] q :gph[vertex]){
                if(vis[q[0]]) continue;
                pq.add(new pair(wt[q[1]]+weight,q[0]));
            }
        }
    }


    // *Sieve of Eratosthenes*
    public ArrayList<Integer> sieve(int n){
        ArrayList<Integer> al=new ArrayList<>();
        boolean[] prime = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;
        for(int p = 2; p*p <=n; p++)
        {
            if(prime[p])
            {
                for(int i = p*2; i <= n; i += p)
                    prime[i] = false;
            }
        }
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true)
                al.add(i);
        }
        return al;

    }


    // *Next Permutation*
    public boolean next_permutation(int[] p) {
        for (int a = p.length - 2; a >= 0; --a)
            if (p[a] < p[a + 1])
                for (int b = p.length - 1;; --b)
                    if (p[b] > p[a]) {
                        int t = p[a];
                        p[a] = p[b];
                        p[b] = t;
                        for (++a, b = p.length - 1; a < b; ++a, --b) {
                            t = p[a];
                            p[a] = p[b];
                            p[b] = t;
                        }
                        return true;
                    }
        return false;
    }


    // *Power Modulo*
    public long powmod(long a,long b, long mod){
        long result = 1;
        while(b>0){
            if(b%2==1) result = (result*a) % mod;
            b/=2;
            a=(a*a)%mod;
        }
        return result;
    }


    // *Linear Search*
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Return the index if the target is found
            }
        }
        return -1; // Return -1 if the target is not found
    }


    // *Binary Search*
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // Return the index if the target is found
            } else if (array[mid] < target) {
                left = mid + 1; // Continue searching in the right half
            } else {
                right = mid - 1; // Continue searching in the left half
            }
        }

        return -1; // Return -1 if the target is not found
    }


    // *Bubble Sort*
    public static void bubbleSort(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
    }


    // *Selection Sort*
    public static void selectionSort(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr.get(j) < arr.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = arr.get(minIndex);
            arr.set(minIndex, arr.get(i));
            arr.set(i, temp);
        }
    }


    // *Insertion Sort*
    public static void insertionSort(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 1; i < n; i++) {
            int key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, key);
        }
    }


    // *Merge Sort*
    public static void mergeSort(ArrayList<Integer> arr) {
        if (arr.size() <= 1) {
            return;
        }
        int mid = arr.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(arr.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<>(arr.subList(mid, arr.size()));

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(ArrayList<Integer> arr, ArrayList<Integer> left, ArrayList<Integer> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                arr.set(k++, left.get(i++));
            } else {
                arr.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            arr.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            arr.set(k++, right.get(j++));
        }
    }


    // *Quick Sort*
    public static void quickSort(ArrayList<Integer> arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(ArrayList<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr.get(j) <= pivot) {
                i++;
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        int temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return i + 1;
    }


    // *Kadane's Algorithm*
    public static int kadaneAlgorithm(ArrayList<Integer> arr) {
        int maxSoFar = arr.get(0);
        int maxEndingHere = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            maxEndingHere = Math.max(arr.get(i), maxEndingHere + arr.get(i));
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }


    // *Sum of Elements*
    public static int sum(ArrayList<Integer> arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }


    // *Frequency Map*
    public static Map<Integer, Integer> frequency(ArrayList<Integer> arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        return frequencyMap;
    }
}

