/* Binary Number Class
   Mark Johnson
*/

import java.util.Scanner;

public class BinaryNumber 
{
public static void main(String[] args) 
{
  Scanner in = new Scanner(System.in);
  System.out.print("Enter a binary number >");
  String sInput = in.nextLine();
  boolean flag = false;
  int count = 0;
  for (int i = 0; i <= sInput.length() - 1; i++)
  {
    if(sInput.charAt(i) == '0' || sInput.charAt(i) == '1' )
    {
      if(sInput.charAt(i) == '1')
        ++count;
    }
    else
    {
      System.out.println("Invalid binary number.");
      flag= true;
      break;
    }
  }
  if(!flag)
  {
    if(count == 2)
      System.out.println("Accepted");
    else
      System.out.println("Rejected");
  }
}
}

