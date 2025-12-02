package day1;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= new int[]{10, 77, 10, 54, -11, 10};
		int len=arr.length;
		int sum=0;
		
		for(int i=0;i<len;i++) {
			 if(arr[i]==10) {
				 
				 sum=sum+arr[i];
			 }
	
		}
		if(sum==30) {
		System.out.println("The sum of all the 10's in the array is:"+sum);
		}
		else
		{
			System.out.println("The sum is:"+sum);
		}

	}

}
