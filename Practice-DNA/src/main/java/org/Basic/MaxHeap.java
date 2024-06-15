package org.Basic;

public class MaxHeap {
    private Integer[] heap;
    private int n; //size of max heap

    public MaxHeap(int capacity){
        heap = new Integer[capacity + 1]; //index 0 iis kept as empty
        n = 0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void insert(int x){
        if(n == heap.length - 1)
            resize(2* heap.length);
        n++;
        heap[n] = x;
        swim(n);
    }

        private void swim(int k){
            while (k > 1 && heap[k/2] < heap[k]){
                int temp = heap[k];
                heap[k] = heap[k/2];
                heap[k/2] = temp;
                k = k/2;
                //because we need to continue shifting up till new
                //value inserted is at correct position
            }
        }

        private void resize(int capacity){
            Integer[] temp = new Integer[capacity];
            for(int i = 0; i < heap.length; i++)
                temp[i] = heap[i];
            heap = temp;
        }

    private int deleteMax() {
        int max = heap[1];
        swap(1, n);
        n--;
        sink(1);
        heap[n + 1] = null;
        if (n > 0 && (n == (heap.length - 1) / 4))
            resize(heap.length / 2);
        return max;
    }

        private void sink(int k) {
            while (2*k <= n){
                int j = 2*k;
                if(j < n && heap[j] < heap[j + 1])
                    j++;
                if(heap[k] >= heap[j])
                    break;
                swap(k, j);
                k = j;
            }
        }

        public void swap(int a, int b){
            int temp = heap[a];
            heap[a] = heap[b];
            heap[b] = temp;
        }

    public int search(int[] arr, int n, int x){
        for(int i = 0; i < n; i++)
            if(arr[i] == 0)
                return i;
        return -1;
    }

    public int binarySearch(int[] nums, int key){
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = (high + low) / 2;
            if(nums[mid] == key)
                return mid;
            if(key < nums[mid])
                high = mid -1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public int searchInsert(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) return mid;
            if(target < arr[mid]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args){
        MaxHeap maxHeap = new MaxHeap(3);
        maxHeap.insert(4);
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(6);
        maxHeap.insert(1);
        maxHeap.insert(3);
        System.out.println(maxHeap.size());

        System.out.println("Delete max value: ");
        maxHeap.deleteMax();
        System.out.println(maxHeap.size());
    }
}
