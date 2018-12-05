import java.util.Scanner;

public class MetricLength
{

   public static void main(String[] args)
   {

     Scanner sc = new Scanner(System.in);
     double CM_PER_INCH = 2.54;
     System.out.println("Enter number of inches: ");
     double inches = sc.nextDouble();
     double centimeters = CM_PER_INCH * inches;
     System.out.println("For a given "+inches+" inches the equivalent centimetres are "+centimeters);

   }
}
