
import java.util.Scanner;

public class test3 {
    static int[] uniqu(int arr[]){
        int[] uniqueArr = new int[arr.length];
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            boolean isduplicate = false;
            for(int j = 0; j < i; j++){
                if(arr[i] == arr[j]){
                    isduplicate = true;
                    break;
                }
            }
            if(!isduplicate){
                uniqueArr[index++] = arr[i];
            }
        }
        int[] result = new int[index];
        for(int i = 0; i < index; i++){
            result[i] = uniqueArr[i];
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("enter 10 numbers:");
        for(int i = 0; i < 10; i++){
            arr[i] = sc.nextInt();
        }
        int[] uniqueArr = uniqu(arr);
        System.out.println("unique array:");
        for(int i = 0; i < uniqueArr.length; i++){
            System.out.print(uniqueArr[i] + " ");
        }
    }
}
