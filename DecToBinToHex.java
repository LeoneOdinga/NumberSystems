//
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecToBinToHex 
{
	/******DRIVER CODE********/
	
	
   public static void main(String[] args)
   {  
  	  System.out.println("===============================================================================================");
      System.out.printf("%12s %34s %36s %n","Decimal(Base 10)","Binary(Base2)","Hexadecimal(Base16)");
	  System.out.println("===============================================================================================");
	   
	  List<Integer>returnedBinaryStream = new ArrayList<Integer>();
      
	  int counter =0;   //loop from 0 to 256 while generating binary and hex equivalents automatically
	  
	  while(counter<=256)
	  {
		 returnedBinaryStream = convertToBinary(counter);
		 String returnedHexadecimalStream = convertToHexadecimal(counter);
		 
		 System.out.printf("%12s %37s %30s %n",counter,groupFourBits(returnedBinaryStream),returnedHexadecimalStream);
		 System.out.println("_______________________________________________________________________________________________");
		 
		 counter ++;
	  }
   }
   
   /*FUNCTION TO CONVERT DECIMAL NUMBER TO BINARY EQUIVALENT.IMPLEMENTED USING STACK AND LISTS*/
   
   public static List<Integer> convertToBinary(int decimalNumber)
   {
       int remainder =0;
	   	
	   Stack <Integer>stack = new Stack<Integer>();
	   
	   List<Integer> listOfRemainders = new ArrayList<Integer>();
	   
	   if(decimalNumber == 0)  //if the number is zero we return the result
	   {
		   for(int j=0;j<4;j++)
		   {
			 stack.push(0);   
		   }
	   }
	   
	   while(decimalNumber > 0) // if number greater than zero then continue dividing by 2 while keeping track of the remainders
	   {
		   remainder = decimalNumber % 2;
		  
		   stack.push(remainder);
		   
		   decimalNumber/=2;
		   
	   }
	   
	   int numberOfBits = stack.size();
	   
	   while(numberOfBits%4!=0)  //this will achieve the grouping into blocks of 4 bits in the output
	   {
		   stack.push(0);
		   numberOfBits ++;
		   
		   if(numberOfBits %4 ==0)
		   {
			   break;
		   }
	   }
	   
	   while(!stack.isEmpty())
	   {
		   Integer storePoppedElement = stack.pop();
	        
		   listOfRemainders.add(storePoppedElement); // returns final output list read from the most significant bit(falls at top of the stack)
	   }
	   
	   return listOfRemainders;
   }
   
   public static String groupFourBits(List<Integer> list) // To keep a gap on every 4 bits
   {
	   String holdFourBits="";
	   int count =0;
	   
	      for(int i: list)
	      {
	    	 holdFourBits+=i;
	    	 count ++;
	    	 
	    	 if(count%4==0)
	    	 {
	    		 holdFourBits+=" ";
	    	 }
	      }
	      return holdFourBits;
   }
   
   //FUNCTION TO CONVERT DECIMAL NUMBER TO HEXADECIMAL EQUIVALENT 
   public static String convertToHexadecimal(int decimalNumber)
   {
	   String [] allHexadecimalValues = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	   int remainder =0;
	   String returnedHexadecimalNumber="";
	   Stack <String>stack = new Stack<String>();
	   
	   if(decimalNumber == 0)
	   {
		   returnedHexadecimalNumber = "0";
	   }
	   while(decimalNumber >0)
	   {
		   remainder = decimalNumber % 16;
		   String letspush = allHexadecimalValues[remainder];
		   stack.push(letspush);
		   decimalNumber /=16;
	   }
	   while(!stack.isEmpty())
	   {
		   String storePoppedElement = stack.pop();
	        
		   returnedHexadecimalNumber+=storePoppedElement;
	   }

	   return returnedHexadecimalNumber;
   }
}
