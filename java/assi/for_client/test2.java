
import java.util.Scanner;

public class test2 {
     static int occurence(String s,String b){
        int count=0;
        String a[]=s.split(" ");
        for(int i=0;i<a.length;i++){
            if(a[i].equals(b)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter sentence");
        String s=sc.nextLine();
        System.out.println("enter word");
        String b=sc.nextLine();
        System.out.println(occurence(s,b));
    }
}
