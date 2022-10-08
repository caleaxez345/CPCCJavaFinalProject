//fields
public class Hardware
{

   private double gpuClockSpeed;
   private double cpuClockSpeed;
   private int cpuCoreNumber;
   private int monitorResolution;
   
   /**
      This is a no-arg contructor that explicitly initializes all fields
   */
   public Hardware() 
   {
      gpuClockSpeed = 0.0;
      cpuClockSpeed = 0.0;
      cpuCoreNumber = 0;
      monitorResolution = 0;
   }
   
   /**
      This is a constructor that initializes all values with arguments
      @param gpu This is the gpu clock speed passed into the method
      @param cpu This is the cpu clock speed passed into the method
      @param cores This is the number of cores passed into the method
      @param resolution This is the monitor resolution the user selects
   */
   public Hardware(double gpu, double cpu, int cores, int resolution) 
   {
      gpuClockSpeed = gpu;
      cpuClockSpeed = cpu;
      cpuCoreNumber = cores;
      monitorResolution = resolution;
   }
   
   /**
      The setGpuClockSpeed method allows code outside of the class to store a value in an object's gpuClockSpeed variable       
      @param gpu This is the gpu clock speed passed into the method
   */
   public void setGpuClockSpeed(double gpu) 
   {
      gpuClockSpeed = gpu;
   }
   
   /**
      The setCpuClockSpeed method allows code outside of the class to store a value in an object's cpuClockSpeed variable 
      @param cpu This is the cpu clock speed passed into the method
   */
   public void setCpuClockSpeed(double cpu) 
   {
      cpuClockSpeed =cpu;
   }
   
   /**
      The setCpuCoreNumber method allows code outside of the class to store a value in an object's cpuCoreNumber variable 
      @param cores This is the number of cores passed into the method
   */
   public void setCpuCoreNumber(int cores) 
   {
      cpuCoreNumber = cores;
   }
   
   /**
      The setMonitorResolution method allows code outside of the class to store a value in an object's monitorResolution variable 
      @param resolution This is the monitor resolution the user selects
   */
   public void setMonitorResolution(int resolution) 
   {
      monitorResolution = resolution;
   }
   
   
   
   /**
      The getResolutionString method finds the String representation of the resolution based on the integer representation
      @return The String representation of the resolution
   */
   public String getResolutionString() 
   {
      //declare local constants to hold the resolution menu options
      
      final int RESOLUTION_1280_720 = 1, 
                RESOLUTION_1920_1080 = 2, 
                RESOLUTION_2560_1440 = 3, 
                RESOLUTION_3840_2160 = 4;
      
      //declare local reference variable
      String monitorResolutionAsString = "";
      
      
      //determine the resolution (as a String) based on the argument passed for the monitor resolution          
      if (monitorResolution == RESOLUTION_1280_720)
      {
         monitorResolutionAsString = "1280 X 720";
      }
      else if (monitorResolution == RESOLUTION_1920_1080)      
      {
         monitorResolutionAsString = "1920 X 1080";
      }
      else if (monitorResolution == RESOLUTION_2560_1440)      
      {
         monitorResolutionAsString = "2560 X 1440";
      }
      else 
      {
         monitorResolutionAsString = "3840 X 2160";
      }
      
      return monitorResolutionAsString;
   }
   
   /**
      The getMultiplierValue method finds the multiplier value (used in calculating the performance score) based on the integer representation
      @return The multiplier value (used in calculating the performance score)
   */
   public double getMultiplierValue() 
   {
      //declare constants to hold the resolution menu options
      final int RESOLUTION_1280_720 = 1, 
                RESOLUTION_1920_1080 = 2, 
                RESOLUTION_2560_1440 = 3, 
                RESOLUTION_3840_2160 = 4;
      
      //declare constants to hold the multiplier values          
      final double MULTIPLIER_1280_720 = 1.0, 
                   MULTIPLIER_1920_1080 = .75, 
                   MULTIPLIER_2560_1440 = .55, 
                   MULTIPLIER_3840_2160 = .35;
      
      //declare variable to hold the multiplier
      double multiplier = 0;
        
      //determine the rmultiplier value based on the argument we are passed for the monitor resolution          
      if (monitorResolution == RESOLUTION_1280_720)
      {
         multiplier = MULTIPLIER_1280_720;
      }
      else if (monitorResolution == RESOLUTION_1920_1080)
      {
         multiplier = MULTIPLIER_1920_1080;
      }
      else if (monitorResolution == RESOLUTION_2560_1440)      
      {
         multiplier = MULTIPLIER_2560_1440;
      }
      else 
      {
         multiplier = MULTIPLIER_3840_2160;
      }
      
      return multiplier;
   }
   
   /**
      The calculatePerformanceScore calculates the performance score of a computer
      @return The performance score of the computer
   */
   public double calculatePerformanceScore() 
   {
      //declare constant to hold the attribute
      final int ATTRIBUTE = 5;
    
     // double multiplier = getMultiplierValue();
      
      return (ATTRIBUTE * gpuClockSpeed + (cpuCoreNumber * cpuClockSpeed))* getMultiplierValue();
   }
   
   /**
      The calculatePerformanceScore provides the recommended graphics quality to play the game at
      @return The recommended graphics quality to play the game at
   */
   public String getRecommendedQuality()
   {
      //declare constants to hold the recommended graphics quality thresholds
      final double PERFORMANCE_THRESHOLD_ULTRA = 17000, 
                   PERFORMANCE_THRESHOLD_HIGH = 15000,  
                   PERFORMANCE_THRESHOLD_MEDIUM = 13000,  
                   PERFORMANCE_THRESHOLD_LOW= 11000; 
                   
      
      //declare reference variable 
      String recommendedQuality = "";
      
      
     // double performanceScore = calculatePerformanceScore();
      
      //determine the recommended graphics quality based on the argument we are passed for the performance score
      if // (performanceScore > PERFORMANCE_THRESHOLD_ULTRA)   
         (calculatePerformanceScore() > PERFORMANCE_THRESHOLD_ULTRA)   
      {
         recommendedQuality = "Ultra";
      }
      else if // (performanceScore > PERFORMANCE_THRESHOLD_HIGH)      
          (calculatePerformanceScore() > PERFORMANCE_THRESHOLD_HIGH)
      {
         recommendedQuality = "High";
      }
      else if //(performanceScore > PERFORMANCE_THRESHOLD_MEDIUM)      
         (calculatePerformanceScore() > PERFORMANCE_THRESHOLD_MEDIUM)
      {
         recommendedQuality = "Medium";
      }
      else if // (performanceScore > PERFORMANCE_THRESHOLD_LOW)      
         (calculatePerformanceScore() > PERFORMANCE_THRESHOLD_LOW)
      {
         recommendedQuality = "Low";
      }
      else      
      {
         recommendedQuality = "Unable to Play";
      }
      
      return recommendedQuality;
   }
   
  /**
      The displayInformation method displays information about a computer
   */
   public void displayInformation()
   {
     // String monitorResolutionAsString = getResolutionString();
    //  double performanceScore = calculatePerformanceScore();
     // String recommendedQuality = getRecommendedQuality();
      
      System.out.println("GPU Clock Speed: " + gpuClockSpeed + " MHz");
      System.out.println("CPU Clock Speed: " + cpuClockSpeed + " MHz");
      System.out.println("Number of cores: " + cpuCoreNumber);
      System.out.println("Monitor Resolution: " + getResolutionString());
      System.out.printf("Performance Score: %,.3f\n", calculatePerformanceScore());
      System.out.println("Recommended Graphics Quality: " + getRecommendedQuality());
   }
   
}