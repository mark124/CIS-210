/* Chapter 3 Programming Activity 2
   Calling class methods
   Anderson, Franceschi
   Mark Johnson
*/

// ***** add your import statements here

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.JOptionPane;
import java.lang.Math;

public class PracticeMethods
{

public static void main(String [] args)
{
  //*****
  // 1.  a. Create a Scanner object to read from the console
  //     b. Prompt the user for their first name
  //     c. Print a message that says hello to the user
  //     d. Print a message that says how many letters
  //               are in the user's name
  // Part 1 student code starts here:

Scanner scan = new Scanner(System.in);

System.out.print("Enter your first name > ");
String firstName = scan.next();
System.out.println("Hello " + firstName + ", " );
int lettersInName = firstName.length();
System.out.println("Your name has " + lettersInName + " letters.");

  // Part 1 student code ends here.

  //*****
  // 2. a. Skip a line, then prompt the user for the year
  //            they were born.
  //    b. Calculate and print the age the user will be this year.
  //    c. Declare a constant for average life expectancy,
  //            set its value to 77.9
  //    d. Print a message that tells the user the percentage
  //            of their expected life they've lived.
  //       Use the DecimalFormat class to format the percentage
  // Part 2 student code starts here:

DecimalFormat percentPattern = new DecimalFormat( "%00.0" );

System.out.print("\nEnter the year you were born(yyyy) > ");
int yearBorn = scan.nextInt();
int userAge = 2018 - yearBorn;
System.out.println("This year you are " + userAge + " years old.");
final double avgLifeExp = 77.9;
double lifeLived = userAge / avgLifeExp;
double lifeLivedSoFar = lifeLived * 100;

System.out.println("You have lived " + percentPattern.format(lifeLived) + " of your life.");

  // Part 2 student code ends here.

  //*****
  // 3.  a. Generate a random integer between 1 and 20
  //     b. Pop up an input dialog box and ask the user for a guess.
  //     c. Pop up an output dialog box telling the user the number
  //          and how far from the number the guess was (hint: use Math.abs)
  // Part 3 student code starts here:
Random random = new Random();

int start = 1, end = 20;
int ranNumber = random.nextInt( end - start + 1) + start;

String numGuess = JOptionPane.showInputDialog(null,
                  "I'm thinking of a number between 1 and 20. \n What is your guess?");
int numGuessInt = Integer.parseInt( numGuess);
JOptionPane.showMessageDialog(null, "The number was " + ranNumber + "\n Your guess was " + Math.abs(numGuessInt - ranNumber) + " away");

  // Part 3 student code ends here.
}

}
