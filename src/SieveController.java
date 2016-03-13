import java.awt.Color;
import java.util.Random;

public class SieveController {
	SieveModel model;
	public SieveController(SieveModel m){
		model = m; //The controller requires a reference to the model being used so as to be able to manipulate and access model data
	
	}
	
	 	void sieve(SieveModel m)
	    {
		 	int n = m.numbers.length;
	        
	        for(int i = 2; i <= Math.sqrt(n);i++)
	        {
	            if(m.numbers[i] == false)
	            {
	                crossOutHigherMultiples(m.numbers, i);
	            }
	        }
	        System.out.println("The Prime Numbers less than or equal to " + n + " are: " + nonCrossedOutSubseqToString(m.numbers)); 
	        System.out.println("The list including both prime and non-prime numbers less than or equal to " + n + " are " + sequenceToString(m.numbers));
	    }
	    
	    static boolean[] createSequence(int n)
	    {
	        boolean[] returnArray = new boolean[n];
	        for(int i = 2; i < n; i++)
	        {
	           returnArray[i] = false; 
	        }
	        
	        return returnArray;
	    }
	    
	    static String nonCrossedOutSubseqToString(boolean[] numbers)
	    {
	        String output = "";
	        for(int i = 2; i < numbers.length; i++)
	        {
	            if(numbers[i] == false)
	                output += i + ", ";
	        }
	        return output.substring(0, output.length()-2);
	    
	    }
	    
	    static String sequenceToString(boolean[] numbers)
	    {
	        String output = "";
	        for(int i = 2; i < numbers.length; i++){
	            if(numbers[i] == true)
	                output += "[" + i + "], ";
	            else
	                output += i + ", ";
	        }
	        return output.substring(0, output.length()-2);
	    }
	    
	    void crossOutHigherMultiples(boolean[] numbers, int startNumber)
	    {
	    	Random random = new Random();
	    	Color multipleColor = new Color(random.nextInt(256), random.nextInt(256), 0);
	        for(int i = 2; i < numbers.length; i++)
	        {
	        	int nextMultiple = startNumber * (i);
	            if(nextMultiple < numbers.length && !model.IsPrime(nextMultiple))
	            {
	                model.UpdatePrime(nextMultiple, multipleColor); //Flag nextMultiple as not being prime in the model
	            }
	        }
	    }  
}
