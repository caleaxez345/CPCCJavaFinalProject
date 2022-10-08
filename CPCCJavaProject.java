//CSC-151 - Java Programming
//Carlos Garcia Alavez
//Spring 2022, Final Project

import java.util.Scanner; 
public class CPCCJavaProject
{
   public static void main(String[]args)
   {
      //create a Scanner object used to read input from the console
      Scanner keyboard = new Scanner(System.in);
      
      //create variables to hold user input and any values calculated from them
      double gpuClockSpeed = 0,  
             cpuClockSpeed = 0, 
             multiplier = 0,
             performanceScore = 0,
             highestPerformanceScore = 0,
             lowestPerformanceScore = 0;
             
      int cpuCoreNumber = 0,
          monitorResolution = 0,
          numOfComputers = 0;
          
      String recommendedQuality = "",
             monitorResolutionAsString = "";
              
      //declare variable used in logic for determining highest and lowest performance scores       
      boolean firstComputer = true;
      
      //declare constants for values used in input validation ranges
      final double CLOCK_SPEED_GPU_LOW_THRESHOLD = 800,   
                   CLOCK_SPEED_GPU_HI_THRESHOLD = 2000,
                   CLOCK_SPEED_CPU_LOW_THRESHOLD = 1000,   
                   CLOCK_SPEED_CPU_HI_THRESHOLD =5500;   
                   
      final int CORES_LOW_THRESHOLD = 1,
                CORES_HI_THRESHOLD = 16;        
   
      //get the number of computers
      System.out.print("How many computers are being processed? ");
      numOfComputers = keyboard.nextInt();
      
      //validate the input
      while(numOfComputers < 0)
      {
         System.out.print("Input must be non-negative.  How many computers are being processed? ");
         numOfComputers = keyboard.nextInt();
      }
    
      //display the title
      System.out.println(); 
      displayTitle();
      System.out.println(); 
      
      for(int i = 0; i < numOfComputers; i++)
      {
         //get the user's input - the user's input will be passed as arguments to the constructor (note: the constructor creates the new computer object)

         System.out.print("Please enter the clock speed (in Megahertz) of your graphics card: ");
         gpuClockSpeed = keyboard.nextDouble();
         
         //validate the input
         while(gpuClockSpeed < CLOCK_SPEED_GPU_LOW_THRESHOLD || gpuClockSpeed > CLOCK_SPEED_GPU_HI_THRESHOLD)
         {
            System.out.println("The clock speed should be between " + CLOCK_SPEED_GPU_LOW_THRESHOLD + " and " + CLOCK_SPEED_GPU_HI_THRESHOLD + " Megahertz.");
            System.out.print("Please enter the clock speed (in Megahertz) of your graphics card: ");
            gpuClockSpeed = keyboard.nextDouble();
         }
      
         System.out.print("Please enter the clock speed (in Megahertz) of your processor: ");
         cpuClockSpeed = keyboard.nextDouble();
         
         //validate the input
         while(cpuClockSpeed < CLOCK_SPEED_CPU_LOW_THRESHOLD || cpuClockSpeed > CLOCK_SPEED_CPU_HI_THRESHOLD)
         {
            System.out.println("The clock speed should be between " + CLOCK_SPEED_CPU_LOW_THRESHOLD + " and " + CLOCK_SPEED_CPU_HI_THRESHOLD + " Megahertz.");
            System.out.print("Please enter the clock speed (in Megahertz) of your processor: ");
            cpuClockSpeed = keyboard.nextDouble();
         }
      
         System.out.print("Please enter the number of cores of your processor: ");
         cpuCoreNumber = keyboard.nextInt();
         
         //validate the input
         while(cpuCoreNumber < CORES_LOW_THRESHOLD || cpuCoreNumber > CORES_HI_THRESHOLD)
         {
            System.out.println("The number of cores should be between " + CORES_LOW_THRESHOLD + " and " + CORES_HI_THRESHOLD + ".");
            System.out.print("Please enter the number of cores of your processor: ");
            cpuCoreNumber = keyboard.nextInt();
         }
      
         System.out.println("What is the resolution of your monitor?");
         System.out.println("\t1. 1280 x 720");
         System.out.println("\t2. 1920 x 1080");
         System.out.println("\t3. 2560 x 1440");
         System.out.println("\t4. 3840 x 2160");
         System.out.print("Please select from the options above: "); 
         monitorResolution = keyboard.nextInt();
         
         //validate the input
         while(monitorResolution < 1 || monitorResolution > 4)
         {
            System.out.print("Invalid menu selection. Please select from the options above: "); 
            monitorResolution = keyboard.nextInt();
         }
         
         //create a computer object; pass the user's input (gpuClockSpeed, cpuClockSpeed, cpuCoreNumber - passed by value; monitorResolution passed by reference)
         //the computer object is of the Hardware class type
         Hardware computer = new Hardware(gpuClockSpeed, cpuClockSpeed, cpuCoreNumber, monitorResolution);
      
         //call the display method to output the results
         System.out.println();
         computer.displayInformation();
         System.out.println();  
         
             
         //find the highest and lowest performance scores
         if(firstComputer)
         {
            //if this if the first computer that we are processing, by default it is the highest and lowest performance score we have seen
            highestPerformanceScore = computer.calculatePerformanceScore(); 
            lowestPerformanceScore = computer.calculatePerformanceScore();
            firstComputer = false;
         }
         else
         {
            //check if the performance score of this computer is higher than the highest performance score we have seen
            if(computer.calculatePerformanceScore() > highestPerformanceScore)
                                                                                                 
            {
               highestPerformanceScore = computer.calculatePerformanceScore();            
            }
            
            //check if the performance score of this computer is lower than the lowest performance score we have seen
            if(computer.calculatePerformanceScore() < lowestPerformanceScore)
            {
               lowestPerformanceScore = computer.calculatePerformanceScore();
            }
         }
      }
      
      //display the highest and lowest performance scores
      System.out.printf("The highest performance score was: %,.3f\n", highestPerformanceScore);
      System.out.printf("The lowest performance score was: %,.3f\n", lowestPerformanceScore);
   }
   

    //The displayTitle method displays the title
   public static void displayTitle()
   {
      String title = "Computer Hardware Graphics Quality Recommendation Tool";
      System.out.println(title);
   }
}