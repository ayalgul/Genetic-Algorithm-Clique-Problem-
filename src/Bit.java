import java.util.Random;


public class Bit {
	
	public static int  bitPartSize(int n)
	{
		
		for(int i=0; i<n; i++)
		{
			if( Math.pow(2, i) > (n-1))
			{
				return i; 
			}
		}
		return -1; 
	}
	
	public static int bitToInt(String binary){
	    char[] numbers = binary.toCharArray();
	    int result = 0;
	    int count = 0;
	    for(int i=numbers.length-1;i>=0;i--){
	         if(numbers[i]=='1')result+=(int)Math.pow(2, count);
	         count++;
	    }
	    return result;
	}
	
	
	public static int[] bitToIntArray(int n,int k, String str)
	{
		int bitPart= Bit.bitPartSize(n);
		int last=0;
		int index=0; 
		int array[]= new int[k];
		
		for(int j=bitPart; j<=k*bitPart; j++)
		{
			if(j%bitPart==0)
			{
				array[index]=Bit.bitToInt(str.substring(last, j));
				//System.out.print(array[index]); 
				//System.out.println(); 
				index++; 
				last=j;
			}
		}
		
		return array; 
	}
	
	public static String createBitString(int n, int k)
	{
		int bitpart= Bit.bitPartSize(n);
		Random rn = new Random();
		StringBuilder sb = new StringBuilder();
		sb.append("");
		
			// creates random bit string 
			for(int i=0; i<k*bitpart; i++)
			{
				int r=  rn.nextInt(1 - 0 + 1) + 0;
				sb.append(r);
				
			}
			String str = sb.toString();
		
			return str; 
	}
	
	
	

}
