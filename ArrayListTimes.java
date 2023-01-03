package Design_of_Algo;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class ArrayListTimes
{
   /* convert nanos to seconds */
   static final double ONE_BILLION = 1_000_000_000.;
   
   /* sizes of input range from 8 to 512k elements */ 
   static int[] sizes = {8, 32, 128, 256, 2*256, 3*256, 1024, 2*1024, 3*1024, 4*1024, 
         5*1024, 6*1024, 7*1024, 8*1024, 16*1024, 32*1024, 48*1024, 64*1024, 80*1024, 96*1024, 112*1024, 128*1024,
         144*1024, 160*1024, 176*1024, 192*1024, 208*1024, 224*1024, 240*1024, 256*1024, 272*1024, 288*1024, 304*1024, 
         320*1024, 336*1024, 352*1024, 368*1024, 386*1024, 512*1024};  
         
   public static void main(String[] args) throws Exception
   {
      int sIdx = 0;
      long startTime;
      long endTime;
      double time;
      
      Scanner inp = new Scanner(System.in);
      System.out.print("What is your last name? ");
      String lastName = inp.next();
      PrintWriter pw = new PrintWriter(new File(lastName + "_ArrayList.csv"));
      pw.println( "Size, SumFirstAndLast, SumArray, SearchArray" );
      while( sIdx < sizes.length ) 
      {
         int[] A = new int[sizes[sIdx]];
         int[] B = new int[sizes[sIdx]];  
         int[] C = new int[sizes[sIdx]];  
         int[] D = new int[sizes[sIdx]];  
         int maxVal = -1, minVal = Integer.MAX_VALUE;
         
         for( int i=0; i<A.length; i++ ) 
         {
            A[i] = (int)(Math.random()*sizes[sIdx]*2);
            if( maxVal < A[i] ) maxVal = A[i];
            if( minVal > A[i] ) minVal = A[i];
            B[i] = A[i];
            C[i] = A[i];
            D[i] = A[i];
         }
         System.out.println();
         System.out.println("--------------------------------------------------");
         System.out.println("Initial Values: ");
         printArray(A);
         pw.print(A.length + ", ");

         System.out.println( "Accessing element of arraylist ---------------- Size = " + B.length);
         startTime = System.nanoTime();
        
         
         /* calculate the sum of the first and last elements in array */
         int sum = sumFirstAndLast(A);
         endTime = System.nanoTime();
         time = (endTime - startTime) / ONE_BILLION;
         System.out.println( "sumFirstAndLast finished --> time = " + time + " seconds" );
         System.out.println( "sum = " + sum );
         pw.print(time + ", ");
         System.out.println();
         
         /* calculate the sum of the entire array */
         System.out.println( "Summing entire array ---------------- Size = " + B.length);
         startTime = System.nanoTime();
         sum = sumArray(B);         
         endTime = System.nanoTime(); 
         time = (endTime - startTime) / ONE_BILLION;
         System.out.println( "sumArray finished - time = " + time + " seconds.");
         System.out.println( "sum = " + sum );
         pw.print(time + ", ");
         System.out.println();

         /* searching array for a value, method returns the index or -1 if not in array */
         System.out.println( "Starting search array ---------------- Size = " + D.length);
         startTime = System.nanoTime();
         int searchTerm = (int)(Math.random() * (maxVal-minVal+1)) + minVal;
         int index = search(D, searchTerm);
         endTime = System.nanoTime();
         time = (endTime - startTime) / ONE_BILLION;
         System.out.println( "search finished - time = " + time  + " seconds." );
         if( index >= 0 ) System.out.print(searchTerm + " found at location " + index);
         else System.out.print(searchTerm + " not found.");
         pw.println(time + ", ");
         System.out.println();
         
         sIdx = sIdx + 1;   
      }
      pw.close();
   }  
   
   /* prints array or a portion of it if it's too large */
   public static void printArray(int[] X)
   {
      if( X == null ) return;
      System.out.print("[ ");
      int i=0;
      for( ; i<15 && i<X.length; i++ )  
      {
         System.out.print( X[i] + " " );
      }
      if( i < X.length ) System.out.print("... ");
      System.out.println("]");
   }
   
   /******************************************/
   /* complete the methods stubbed out below */
   /******************************************/
   
   
   
   /* add and return the sum of first and last values in X */
   public static int sumFirstAndLast(int[] X)
   {
      int sum = 0;
      
      sum = X[0] + X[X.length - 1];
      return sum;
   }
   /* return sum of entire array */
   public static int sumArray(int[] X)
   {
      int sum = 0;
      for(int i = 0; i<X.length;i++) {
    	  sum = sum + X[i];
      }
      return sum;
   }   
   /* search array for value, return index (or -1 if not found) */
   public static int search(int[] X, int searchTerm) 
   {
	   for(int i = 0; i<X.length;i++) {
		   if(X[i] == searchTerm) {
			   return i;
		   }
	   }
      return -1;
   }
}