# Weather-Based Crop Recommendation System

A console application written in Java that helps a farmer decide which crop to plant. The farmer enters daily weather data for 15 days, and the system analyses it and recommends the most suitable crop.

## Features

- Accepts **15 days** of temperature, humidity and rainfall data
- Stores the measurements in three arrays
- Calculates the **average temperature**, **average humidity** and **total rainfall**
- Compares the results against each crop's ideal conditions and gives a clear recommendation
- Displays a helpful message when no crop matches the conditions

## Crop Conditions

| Crop | Temperature (°C) | Rainfall (mm) | Humidity (%) |
|------|------------------|---------------|--------------|
| Rice | 20-35 | 100-300 | 60-90 |
| Wheat | 10-25 | 50-100 | 40-60 |
| Maize | 18-27 | 60-150 | 50-70 |
| Sugarcane | 20-40 | 100-300 | 70-90 |

> Rainfall is compared as the **total** over the 15 days. Temperature and humidity are compared as **averages**.

## Requirements

- Java Development Kit (JDK) 8 or later

## How to Run

From the folder that contains the `org` package directory (for a Maven project, `src/main/java`):

```bash
javac org/example/CropRecommender.java
java org.example.CropRecommender
```

Or open the project in an IDE such as IntelliJ IDEA and run the `CropRecommender` class.

## Usage

For each day, enter the temperature, humidity and rainfall on one line, separated by spaces:

```
28 75 15
```

This means a temperature of 28 °C, humidity of 75% and rainfall of 15 mm. Repeat for all 15 days. The analysis is shown once after the last day.

## Sample Output

```
Welcome to the Weather-Based Crop Recommendation System!
Enter Weather Data for 15 Days:
Day 1 - Temperature (C), Humidity (%), Rainfall (mm): 28 75 15
...
Day 15 - Temperature (C), Humidity (%), Rainfall (mm): 28 75 15

Analyzing the weather data .......
Average temperature: 28.0 C | Total rainfall: 225.0 mm | Average humidity: 75.0%
Based on the weather trends:
Recommended Crop: Rice
Suitable for temperatures between 20-35C, rainfall of 100-300 mm and humidity of 60-90%
```

## How It Works

1. Three `double` arrays store the 15 daily measurements.
2. While reading the input, the program accumulates the average temperature, average humidity and total rainfall.
3. The crop ranges are stored in a 2D array, one row per crop.
4. A loop checks each crop and recommends the first one whose ranges contain **all three** results.
5. If no crop matches, the program tells the farmer to wait for better weather.

## Notes

- Some crops have overlapping ranges (for example Rice and Sugarcane). When more than one crop fits, the first match in the table is recommended.
- To add a new crop, add its name to the `crops` array and its ranges as a new row in the `range` array.

## Author

Brian