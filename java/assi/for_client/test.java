public class test {
    void sorting(int arr[]){
        int cnt=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                cnt=i+1;
                break;
            }
        }
        System.out.println("The array is rotated "+cnt+" times");
        
        
    
    }
    public static void main(String[] args) {
        int arr[]={8,9,10,2,5,6};
        test t=new test();
        t.sorting(arr);
    }
}
