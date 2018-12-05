/* Temperature Conversion
Mark Johnson
*/

import java.util.Scanner;

public class TemperatureConversion
{

public static void main(String [] args)
{
  //***** 1. declare any constants here
  // Part 1 student code starts here:

  Scanner sc = new Scanner (System.in);

  // Part 1 student code ends here.

  //***** 2.  declare temperature in Fahrenheit as an int
  // Part 2 student code starts here:
  
  int Tf = 0;
  double Tc;
  System.out.println("Please Enter the Temperature in Fahrenheit : ");
  Tf = sc.nextInt();

  // Part 2 student code ends here.

  //***** 3. calculate equivalent Celsius temperature as a double
  // Part 3 student code starts here:

  Tc = (double)5 / 9 * (Tf - 32);
  
  // Part 3 student code ends here.

  //***** 4. output the temperature in Celsius
  // Part 4 student code starts here:

  System.out.println("The Temperature "+Tf+" in Celsius is : "+Tc);

  // Part 4 student code ends here.

  //***** 5. convert Celsius temperature back to Fahrenheit
  // Part 5 student code starts here:

  Tf = (int) ((double)9 / 5 * Tc + 32);
  
  // Part 5 student code ends here.

  //***** 6. output Fahrenheit temperature to check correctness
  // Part 6 student code starts here:

System.out.println("The Temperature "+Tc+" in Fahreheit is : "+Tf);

  // Part 6 student code ends here.
}

}
