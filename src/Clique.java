


public class Clique{
	
	
	
	
public static boolean check(int []comb, int[][] clique)	
{
	int k=comb.length; 
	int i=0; 
	
	while(i<k)
	{
		int j=0; 
		while(j<k)
		{
			if(i!=j)
			{
				if(comb[i]>k || comb[j]>k)
					return false;
				if(comb[i]==comb[j])
					return false; 
				if(clique[comb[i]][comb[j]]==0)
					return false;
				
			}
			j++; 
		}
		i++;
	}
	
	return true; 
}


public static void bruteClique(int[][]  clique, int K){
 
       
        int n = clique.length;
        int[] elements = new int[n];
        
        for(int i=0; i<n; i++)
        {
        	elements[i]=i; 
        }
         
        if(K > n){
            System.out.println("Invalid input, K > N");
            return;
        }
       
        int combination[] = new int[K];
         
       
        int r = 0;      
        int index = 0;
         
        while(r >= 0){
            
            if(index <= (n + (r - K))){
                    combination[r] = index;
                     
                if(r == K-1){
  
                	if(check(combination, clique))
            		{
            			System.out.println("Found a solution ");
            			for(int i=0; i<combination.length; i++)
                    	{
                    		
                    		System.out.print(combination[i]+" ");
                    	}
            			return; 
            		}
                    index++;                
                }
                else{
                   
                    index = combination[r]+1;
                    r++;                                        
                }
            }
            else{
                r--;
                if(r > 0)
                    index = combination[r]+1;
                else
                    index = combination[0]+1;   
            }           
        }
    }

	public static void main(String[] args){
		 int[][] clique={ {0,0,1,0,1},
				          {1,1,1,1,1},
				          {1,1,1,1,1},
				          {1,1,1,1,1},
				          {0,1,1,0,1}};	

		bruteClique(clique,3);
	}

}