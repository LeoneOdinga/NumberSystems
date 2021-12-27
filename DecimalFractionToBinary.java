import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Random;

public class DecimalFractionToBinary 
{
  /********DRIVER CODE*******/
  public static void main(String[] args)
  {   
	
    displayTable();
	 
    // I was here in 2019
  }
  
  /*FUNCTION TO TRANSFORM FRACTION PARTS TO BINARY. Using Queues to store the order of most significant bits*/
  public static Queue<Integer> convertFractionPart(double fractionNumber)
  {
	Queue<Integer> fractionBitQueue = new LinkedList<>();
	
	int remainder =0;
	
	if(fractionNumber ==0)
	{
		fractionBitQueue.add(0);
	}
	
	while(remainder != fractionNumber && fractionNumber!= 0)
	{
		fractionNumber *= 2;
		remainder =(int) fractionNumber;
		fractionBitQueue.add(remainder);
		fractionNumber -= remainder;
	}
	return fractionBitQueue;
  }
  
  /*FUNCTION TO FILL OUT THE REMARKS COLUMN BASED ON THE NUMBER OF BITS ON FRACTION PART */
  public static String returnRemarks(Queue<Integer> fractionBitQueue)
  {
	  int sizeOfQueue = fractionBitQueue.size();
	  
	  String remark = (sizeOfQueue > 5) ? "Approximate": "Exactly";
	
	  return remark;
  }
  
  /*FUNCTION TO GENERATE STREAM OF BITS FROM FRACTION PART AS A STRING FROM THE QUEUE*/
  public static String printFractionBits(Queue<Integer> fractionBitQueue)
  {
	  Iterator<Integer> iterator = fractionBitQueue.iterator();
	    String fractionBitStream="";
	    
	    int count =1;
	    while(iterator.hasNext())
	    {
	        int element = iterator.next();
	        fractionBitStream += element;
	        
	        if(count >=5 && returnRemarks(fractionBitQueue) =="Approximate")
	        {
	        	break;
	        }
	        count ++;
	    }
	    
	  return fractionBitStream;
  }
  
  /*FUNCTION TO PRINT ANY LIST PASSED AN ARGUMENT*/
  public static String printList(List<Integer> listPassed)
  {
	  String returnedList = "";
	  
	  for(int i: listPassed)
	  {
		  returnedList+=i;
	  }
	  return returnedList;
  }
  
  /*FUNCTION TRANSFORMING INTEGER PART TO BINARY EQUIVALENT USING STACKS*/
  public static List<Integer> convertToBinary(int decimalNumber)
  {
      int remainder =0;
	   	
	   Stack <Integer>stack = new Stack<Integer>();
	   
	   List<Integer> listOfRemainders = new ArrayList<Integer>();
	   
	   if(decimalNumber == 0)  //if the number is zero we return the result
	   {
			 stack.push(0);   
	   }
	   
	   while(decimalNumber > 0) // if number greater than zero then continue dividing by 2 while keeping track of the remainders
	   {
		   remainder = decimalNumber % 2;
		  
		   stack.push(remainder);
		   
		   decimalNumber/=2;
		   
	   }
	   while(!stack.isEmpty())
	   {
		   Integer storePoppedElement = stack.pop();
	        
		   listOfRemainders.add(storePoppedElement); // returns final output list read from the most significant bit(falls at top of the stack)
	   }
	   
	   return listOfRemainders;
  }
  
  /*FUNCTION TO GENERATE THE TABLE COLUMNS AND PASS IN THE VALUES OF THE FUNCTIONS*/
  public static void displayTable()
  {
	  
	  System.out.println("===============================================================================================");
	  System.out.printf("%9s %24s %26s %24s %n","S/No","Decimal Number","Binary Number","Remarks");
	  System.out.println("===============================================================================================");

	  String RADIXPOINT =".";
	  
	  int count =1;
	  while(count <=30)
	  {
	
	  double numberToConvert = generateRandomNumbers();
	  
	  /***separate the integer part from the fraction part of the number generated**/
	  int integerPart = (int)numberToConvert;
	  double fractionPart = numberToConvert - integerPart;
	  
	  /*convert both the integer and fraction parts to binary equivalents*/
	  List<Integer> integerPartBitList = convertToBinary(integerPart);
	  Queue<Integer> fractionPartBitQueue = convertFractionPart(fractionPart);
	  
	  /*make the output in form of a string*/
	  String integerBitStream = printList(integerPartBitList);
	  String fractionBitStream = printFractionBits(fractionPartBitQueue);
	 
	  String finalBinaryOutput = integerBitStream + RADIXPOINT + fractionBitStream;
	  
	  String verdict = returnRemarks(fractionPartBitQueue);
	  
	  System.out.println("_______________________________________________________________________________________________");
      System.out.printf("%9s %24s %26s %24s %n",count,numberToConvert,finalBinaryOutput,verdict);
			 
	  count ++;
	   
	  }
  }
  
  /*GENERATES RANDOM FLOATING POINT NUMBERS{FROM 0-30} WHILE SETTING THE PRECISION TO AT MOST 3 */
  public static double generateRandomNumbers()
  {
      Random random = new Random();
      
	  double floatingPointRandom = (random.nextFloat());
	  int integerRandom = random.ints(1, 5, 31).findFirst().getAsInt();
	  
	  double generatedRandomNumber = integerRandom + floatingPointRandom;
	  
	  @SuppressWarnings("deprecation")
	  Double truncatedValue= new Double(generatedRandomNumber);

	  return BigDecimal.valueOf(truncatedValue).setScale(3, RoundingMode.HALF_UP).doubleValue();
	  
  }
  
}
