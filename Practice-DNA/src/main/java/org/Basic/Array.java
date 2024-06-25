package org.Basic;

public class Array {
    static int[] dummyArray = {9, 1, 8, 2, 7, 3, 6, 4, 5};
    static int[] SortedDummyArray = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};

    public static void main(String[] args) {
        int index = interpolationSearch(SortedDummyArray, 16);
        System.out.println(index);
    }

    public void sort(int[] arr){
        int n = arr.length;
        boolean isSwapped;

        for(int i = 0; i < n - 1; i++){
            isSwapped = false;
            for(int j = 0; j < n - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if(isSwapped == false) {
                break;
            }
        }
    }

    public static int linearSearch(int[] array, int value){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                return i;
        }
        return -1;
    }

    public static int binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int value = array[middle];

            System.out.println("middle value: " + value);

            if(value < target) left = middle + 1;
            else if(value > target) right = middle - 1;
            else return middle;
        }
        return -1;
    }


    //tham khảo tại https://freetuts.net/tim-kiem-noi-suy-interpolation-search-2922.html
//    Chúng ta sẽ sử dụng công thức tìm phần tử chính giữa của tập theo cách tìm kiếm Binary Search:
//      Search = left + (right - left) * 1/2
//    Trong công thức trên chúng ta sẽ thay giá trị 1/2 bằng biểu thức sau:
//      (X - T[left]) / (T[right] - T[left])
//    Sau khi thay biểu thức vào công thức sẽ được công thức mới như sau:
//      Search = left + (X- T[left]) * (right – left) / (T[right] – T[left])
    public static int interpolationSearch(int[] array, int value){
        int left = 0;
        int right = array.length - 1;

        while (value >= array[left] && value <= array[right] && left <= right) {
            int probe = left + (right - left) * (value - array[left]) / (array[right] - array[left]);
            System.out.println("probe: " + probe);
            if(array[probe] == value) {
                return probe;
            }
            else if(array[probe] < value) {
                left = probe + 1;
            }
            else {
                right = probe - 1;
            }
        }
        return -1;
    }

    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j <array.length - i - 1; j++){
                if (array[j] > array[j+1]) {
                    int temp = array [j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
    }

    public static void selectionSort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            int min = i;
            for (int j = i + 1; j < array.length; j++){
                if(array[min] < array[j]){
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    public static void insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    public int[] mergeTwoArray(int[] arr1, int[] arr2, int n, int m){
        int[] result = new int[n + m];
        int i = 0; int j = 0; int k = 0;
        while (i < n && j < m){
            if(arr1[i] < arr2[j]){
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        while(i < n){
            result[k] = arr1[i];
            i++; k++;
        }
        while(j < m){
            result[k] = arr2[j];
            j++; k++;
        }
        return result;
    }

    //Recursion: đệ quy

    //**************** mergeSort ****************
    public static void mergeSort(int[] array) {
        int length = array.length;
        if (length <= 1)
            return;

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        for (int i = 0; i < middle; i++) {
            leftArray[i] = array[i];
        }
        for (int i = middle; i < length; i++) {
            rightArray[i - middle] = array[i];
        }

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    public static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0, l = 0, r = 0;

        while (l < leftSize && r < rightSize) {
            if (leftArray[l] <= rightArray[r])
                array[i++] = leftArray[l++];
            else
                array[i++] = rightArray[r++];
        }

        while (l < leftSize) array[i++] = leftArray[l++];
        while (r < rightSize) array[i++] = rightArray[r++];
    }


    // This is hard, you should turn back when you are ready
    public void arrangeMaxMin(int[] arr){
        int maxldx = arr.length - 1;
        int minldx = 0;
        int max = arr[maxldx] + 1;
        for(int i = 0; i < arr.length; i++){
            if(i % 2 == 0){
                arr[i] = arr[i] + (arr[maxldx] % max) * max;
                maxldx--;
            } else {
                arr[i] = arr[i] + (arr[minldx] % max) * max;
                minldx++;
            }
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i] / max;
        }
    }

    //**************** Merge Sort use Call Stalk ****************
    public void sort(int[] arr, int[] temp, int low, int high){
        if(low < high){ //base case
            int mid = low + high + (high - low) / 2; // overflow condition (low + high) / 2;
            sort(arr, temp, low, mid);
            sort(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);
        }
    }

    private void merge(int[] arr, int[] temp, int low, int mid, int high){
        for(int i = low; i <= high; i++){
            temp[i] = low;
        }
        int i = low; // traverse left sorted subarray;
        int j = mid + 1; // traverse right sorted subarray;
        int k = low; // will merge both arrays into original array (arr)

        while(i <= mid && j <= high){
            if(temp[i] <= temp[j]){
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        while(i <= mid){
            arr[k] = temp[i];
            k++;
            i++;
        }
    }

    //**************** QuickSort ****************
    public static void quickSort(int[] array, int start, int end) {
        if(end <= start) return; //base case
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j <= end - 1; j++){
            if (array[i] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;
        return i;
    }

    public static int[] sortedSquares(int[] arr){
        // Two pointer technique
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        int[] result = new int[n];

        // {-4, -1, 0, 3} -> {0, 1, 9, 16}

        for(int k = n - 1; k >= 0; k--){
            if(Math.abs(arr[i]) > Math.abs(arr[j])){
                result[k] = arr[i] * arr[i];
                i++;
            } else {
                result[k] = arr[j] * arr[j];
                j--;
            }
        }
        return result;
    }

    //**************** Three number sort ****************
    void threeNumberSort(int[] arr){
        int i = 0;
        int j = 0;
        int k =arr.length - 1;
        while(i <= k){
            if(arr[i] == 0){
                swap(arr, i, j);
                i++;
                j++;
            } else if(arr[i] == 1){
                i++;
            } else if(arr[i] == 2){
                swap(arr, i, k);
                k--;
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}