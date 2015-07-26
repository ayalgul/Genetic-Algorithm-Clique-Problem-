
import java.util.*;

public class Clique{
	
	

// checks if the chromosome is 	a clique
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

//checks the fitness value of each chromosome by setting the 
//total fitness value to one and checking each possible 
//edge (ith and jth pair). if that edge does not exist
// or numbers are duplicates we subtract from total fitness. 
//then we divide the total fitness to the max fitness. 
public static float fitnessCheck(int []comb, int[][] clique)	
{
	int k=comb.length; 
	float fitness= k*(k-1);
	int i=0; 
	
	while(i<k)
	{
		int j=0; 
		while(j<k)
		{
			if(i!=j)
			{
				if(comb[i]==comb[j])
					fitness--; 
				else if(clique[comb[i]][comb[j]]==0)
					fitness--;
				
			}
			j++; 
		}
		i++;
	}
	
	return fitness/(k*(k-1)); 
}

public static void geneticClique(int [][]clique, int k, int popsize, int maxgen, int fitthresh, int tournsize)
{
	
	int n= clique.length; 
	int population[][]= new int[popsize][k];
	float fitness[]= new float[popsize];
	
	for(int j=0; j<popsize; j++)
	{
		int array[] = new int [k]; 
		for(int i=0; i<k; i++)
			array[i]= (int) (Math.random()*n)+0;
		
		fitness[j]=fitnessCheck(array, clique);
		population[j]=array; 
	}
	
	int t=0; 
	int ktourn[][] = new int[tournsize][k];
	boolean tourncheck[]= new boolean[popsize]; 
	
	
		
		while(t<tournsize)
		{
			int r=(int) (Math.random()*(popsize))+0;
			if(tourncheck[r]==false)
			{
			ktourn[t]= population[r]; 
				
					System.out.println(r+" "); 
				
			t++;
			tourncheck[r]=true;
			}
		}
		
		
		
	
}


// just generates a random possible solution and checks if that solution is
// acceptable or not. 
public static void randomClique(int [][] clique, int k)
{
	int array[] = new int [k]; 
	int n= clique.length; 
	
	for(int i=0; i<k; i++)
			array[i]= (int) (Math.random()*n)+0;
			
	
	if(check(array, clique))
	{
		System.out.println("Solution found");
		for(int i=0; i<k; i++)
				System.out.print(array[i]+" ");
		
	}

}

//checks all possible solutions of the clique problem by using a combination
//algorithm I got from my friend Nate Ritholtz a former queens college student. 
public static void bruteClique(int[][]  clique, int k){
 
       
        int n = clique.length;
        int[] elements = new int[n];
        
        for(int i=0; i<n; i++)
        {
        	elements[i]=i; 
        }
         
        if(k > n){
            System.out.println("Invalid input, K > N");
            return;
        }
       
        int combination[] = new int[k];
         
       
        int r = 0;      
        int index = 0;
         
        while(r >= 0){
            
            if(index <= (n + (r - k))){
                    combination[r] = index;
                     
                if(r == k-1){
  
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

		geneticClique(clique,3, 1000, 100, 2 ,50);
	}

}