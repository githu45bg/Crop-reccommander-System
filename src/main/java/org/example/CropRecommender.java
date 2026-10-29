package org.example;

import java.util.Scanner;

public class CropRecommender{
    static void main(String[]args){
        Scanner in = new Scanner(System.in);

        // three arrays to store i5 days of data
        double[] temp =new double[15];
        double[] humidity = new double[15];
        double[] rain = new double[15];

        // variable to store results of the analysis
        double avgTemp=0;
        double avgHumd=0;
        double totalRain=0;

        System.out.println("Welcome to the Weather-Based-Crop Recommendation System");
        System.out.println("Enter Weather data for 15 days:");
        //  accept user data for each 15 days
        for (int i=0;i<15;i++) {
            System.out.print("Day" + (i + 1) + " " + "Temperature (C), Humidity(%), Rainfall(mm):");
            temp[i] = in.nextDouble();
            humidity[i] = in.nextDouble();
            rain[i] = in.nextDouble();
            //perform calculations
            avgTemp += temp[i] / 15;
            avgHumd += humidity[i] / 15;
            totalRain += rain[i];
        }
            //show calculated results
            System.out.printf("%nAnalyzing the Weather data..........%n");
            System.out.printf("Average temperature: %.1f C | Total rainfall: %.1f mm | Average humidity: %.1f%%%n",
                    avgTemp, totalRain, avgHumd);
            System.out.println("Based on weather trends:");
            //crops grown
            String[]crops={"Rice","Wheat","Maize","Sugarcane"};
            //range table(minTemp,maxTemp,minRain,maxRain,minHumidity,maxHumidity
            int[][] range={
                    {20,35,100,500,60,90},//rice
                    {10,23, 50,200,50,60},// wheat
                    {23,45,60,400,50,70},//maize
                    {32,45,100,1500,50,90}//sugarcane
            };

            boolean found= false;//becomes true once a suitable crop is found
            //checks each crop
            for (int j = 0; j < crops.length && !found; j++) {
                int[] r = range[j];
                /* THe crop matches only if temperature , rainfall and
                humidity are all within range
                 */

                if (avgTemp>= r[0] && avgTemp <=r[1]
                    && totalRain>=r[2] &&totalRain <=r[3]
                    && avgHumd>=r[4] && avgHumd <=r[5]){
                    // gives the farmer a clear recommendation for crops
                    System.out.println("Recommended Crop:"+crops[j]);
                    System.out.println("Suitable for temperatures between "+r[0]+"-"+r[j]
                            +"C,rainfall of "+r[2]+"-"+r[3]
                            +"mm and humidity of "+r[4]+"-"+r[5]+"%");
                    found= true;// stops the loop
                }
            }
            if(!found){
                System.out.println("No crop matches these conditions, Consider waiting for better weather");
            }




    }

}