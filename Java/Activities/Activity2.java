package activities;

public class Activity2 {
    public static void main(String[] args){
        int[] arr = {10, 77, 10, 54, -11, 10};

        int sum = 0;
        int count = 0;

        for(int arrNo: arr){
            if(arrNo==10){
                count+=1;
                sum=sum+10;
            }
        }
        System.out.println("The number of 10's: "+ count);
        if(sum==30){
            System.out.println("The sum of 10's is 30 ");
        }
        else{
            System.out.println("Sum of 10's is not 30");
        }
    }
}
