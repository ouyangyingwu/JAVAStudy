package main.java.util;

public class ArrayMethod {
	//遍历数组
    public static void print(int[] arr){
        /*for(int i:arr){ //使用加强for循环遍历
            System.out.print(arr[i]+"\t");
        }
        System.out.println; */
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }

    //获取最大值
    public static int max(int[] arr){
        int max=arr[0]; 
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    //获取最大值索引
    public static int maxIndex(int[] arr){
        int maxIndex=0;; 
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[maxIndex]){
                maxIndex=i;
            }
        }
        return maxIndex;
    }

    //获取最小值
    public static int min(int[] arr){
        int min=arr[0]; 
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }

    //获取最小值索引
    public static int minIndex(int[] arr){
        int minIndex=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<arr[minIndex]){
                minIndex=i;
            }
        }
        return minIndex;
    }

    //在数组中查找指定元素是否存在 ,如是存在返回true,不存在返回false
    public static boolean search(int[] arr,int number){
        for(int i=0;i<arr.length;i++){
            if(number==arr[i]){
                return true; 
            }
        }
        return false;
     }

     //在数组中查找指定元素是否存在 ,如是存在返回索引,不存在返回-1
     public static int searchIndex(int[] arr,int number){
        for(int i=0;i<arr.length;i++){
            if(number==arr[i]){
                return i; //返回索引
            }
        }
        return -1;
     }
}