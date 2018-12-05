/* Chapter 8 Programming Activity 1
   ArrayPractice1
   Anderson, Franceschi
   Mark Johnson
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class ArrayPractice1 extends JFrame
{
// GUI components
private JButton fillValues;
private JButton printArray;
private JButton setValues;
private JButton countFrequency;
private JButton findMinimum;

private ButtonHandler bh;

private static int [] arr;
private final int SIZE = 15;
private static int current = -1;
private int key;
private BarChart bc;
private static int counter = 0;

private static ArrayPractice1 app;

private Image offscreen;

public ArrayPractice1()
{
  super("Choose your activity");
  Container c = getContentPane();
  c.setLayout(new FlowLayout());

  fillValues = new JButton("Fill Values");
  c.add(fillValues);
  printArray = new JButton("Print Array");
  c.add(printArray);
  setValues = new JButton("Set Values");
  c.add(setValues);
  countFrequency = new JButton("Count Frequency");
  c.add(countFrequency);
  findMinimum = new JButton("Find Minimum");
  c.add(findMinimum);

  bh = new ButtonHandler();
  fillValues.addActionListener(bh);
  printArray.addActionListener(bh);
  setValues.addActionListener(bh);
  countFrequency.addActionListener(bh);
  findMinimum.addActionListener(bh);

  setSize(400, 275);

  arr = new int[SIZE];

  // fill with random numbers between 50 and 80
  for (int i = 0; i < arr.length; i++)
  {
    arr[i] =  (int) (Math.random() * 31) + 50;
  }

  bc = new BarChart(arr);

  // print the array values
  System.out.println("Element\tValue");
  for (int i = 0; i < arr.length; i++)
  {
    System.out.println(i + "\t" + arr[i]);
  }

  setVisible(true);

  offscreen = this.createImage(getSize().width, getSize().height);
}

// ***** 1. The first method has been coded as an example
/**  Fills the array with random numbers between 50 and 80.
*    The instance variable arr is the integer array
*    to be filled with values
*/
public void fillValues()
{
  Random rand = new Random();

   for (int i = 0; i < arr.length; i++)
   {
     arr[i] =  rand.nextInt(31) + 50;
     animate(-1);  // needed to create visual feedback
   }
}
// end of fillValues method

// ***** 2. student writes this method
/** Prints the array to the console with elements separated
*     by a space
*    The instance variable arr is the integer array to be printed
*/
public void printArray()
{
  // Note: to animate the algorithm, put this method call as the
  // last statement in your for loop:
  //   animate(i);
  //     where i is the index of the current array element
  // Part 2 student code starts here:



  // Part 2 student code ends here.
} // end of printArray method

// ***** 3. student writes this method
/** Sets all the elements in the array to parameter value
*    The instance variable arr is the integer array to be processed
*    @param  value    the value to which to set the array elements
*/
public void setValues(int value)
{
  // Note:  to animate the algorithm, put this method call as the
  // last statement in your for loop
  //   animate(i);
  //     where i is the index of the current array element
  // Part 3 student code starts here:



  // Part 3 student code ends here.
} // end of setValues method

// ***** 4 student writes this method
/** Counts number of elements equal to parameter value
*    The instance variable arr is the integer array to be processed
*      @param  value    the value to count
*      @return   the number of elements equal to value
*/
public int countFrequency(int value)
{
  // Note:  to animate the algorithm, put this method call as the
  // last statement in your for loop
  //   animate(i, count);
  //     where i is the index of the current array element
  //           count is the variable holding the frequency
  // Part 4 student code starts here:



  return 0; // Replace this line with your return statement

  // Part 4 student code ends here.

} // end of countFrequency method

// 5 ***** student writes this method
/** Finds and returns the minimum value in arr
*    The instance variable arr is the integer array to be processed
     @return the minimum value found in arr
*/
public int findMinimum()
{
  // Note:  to animate the algorithm, put this method call as the
  // last statement in your for loop
  //   animate(i, minimum);
  //     where i is the index of the current array element
  //           minimum is the variable holding the  minimum
  // Part 5 student code starts here:



  return 0; // Replace this line with your return statement

  // Part 5 student code ends here.
} // end of findMinimum method

public void startActivity(int act)
{
  bc.setActivity(act);
  boolean goodInput  = false;
  String answer = "";

  switch(act)
  {
    case 0:
      fillValues();
      JOptionPane.showMessageDialog(null, "Array filled with new values");
      break;
    case 1:
      printArray();
      JOptionPane.showMessageDialog(null, "Array printed");
      break;
    case 2:
      goodInput = false;
      while (!goodInput || key < 50 || key > 80)
      {
        try
        {
          answer = JOptionPane.showInputDialog(null, "Enter an integer value between 50 and 80 for all the array elements");
          if (answer != null)
          {
            key = Integer.parseInt(answer);
            bc.setKey(key);
            goodInput = true;
          }
          else
          {
            goodInput = false;
            break;
          }
        }
        catch(Exception e)
        {}
      }

      if (goodInput)
      {
        setValues(key);
        String message = "";
        if (bc.getCheckNewValues())
          message = " correctly";
        else
          message = " incorrectly";
        JOptionPane.showMessageDialog(null, "Values set to " + key + message);
      }
      break;
    case 3:
      goodInput = false;
      while (!goodInput || key < 50 || key > 80)
      {
        try
        {
          answer = JOptionPane.showInputDialog(null, "Enter an integer value between 50 and 80 for frequency count");
          if (answer != null)
          {
            key = Integer.parseInt(answer);
            bc.setKey(key);
            goodInput = true;
          }
          else
          {
            goodInput = false;
            break;
          }
        }
        catch(Exception e)
        {}
      }

      if (goodInput)
      {
        int frequency = countFrequency(key);
        String feedbackFrequency = "";
        if (frequency == bc.getExactFrequencyCount())
          feedbackFrequency = "\nThis is correct";
        else
          feedbackFrequency = "\nThis is incorrect";
        String plural = "";
        if (frequency != 1)
          plural = "s";
        if (frequency != -1)
          JOptionPane.showMessageDialog(null, "You found " + key + " " + frequency + " time" + plural + feedbackFrequency);
        else
          JOptionPane.showMessageDialog(null, "You did not find " + key + feedbackFrequency);
      }
      break;
    case 4:
      int a = findMinimum();
      String feedbackMinimum = "";
      if (a == bc.getExactMinimum())
        feedbackMinimum = "\nThis is correct";
      else
        feedbackMinimum = "\nThis is incorrect";
      JOptionPane.showMessageDialog(null, "You found a minimum value of " + a + feedbackMinimum);
      break;
  }
  enableButtons();
}

private void animate(int index)
{
  try
  {
    current = index;
    bc.setArray(arr);

    Graphics g = offscreen.getGraphics();
    paint(g);
    g = this.getGraphics();
    g.drawImage(offscreen, 0, 0, this);

    Thread.sleep(1000);
  }
  catch(InterruptedException e)
  {
    System.out.println("IE Exception " + e.getMessage());
    System.out.println(e.toString());
  }
}

private void animate(int index, int intermedResult)
{
  try
  {
    current = index;
    bc.setStudentResult(intermedResult);
    bc.setArray(arr);

    Graphics g = offscreen.getGraphics();
    paint(g);
    g = this.getGraphics();
    g.drawImage(offscreen, 0, 0, this);

    Thread.sleep(1000);
  }
  catch(InterruptedException e)
  {
    System.out.println("IE Exception " + e.getMessage());
    System.out.println(e.toString());
  }
}

public void enableButtons()
{
  fillValues.setEnabled(true);
  printArray.setEnabled(true);
  setValues.setEnabled(true);
  countFrequency.setEnabled(true);
  findMinimum.setEnabled(true);
}

public void disableButtons()
{
  fillValues.setEnabled(false);
  printArray.setEnabled(false);
  setValues.setEnabled(false);
  countFrequency.setEnabled(false);
  findMinimum.setEnabled(false);
}

public static int [] getArr()
{
  return arr;
}

public static int getCounter()
{
  return counter;
}

public static int getCurrent()
{
  return current;
}

public void paint(Graphics g)
{
  super.paint(g);
  bc.updateBarChart(key, current, g);
}

public static void main(String [] args)
{
  app = new ArrayPractice1();
  app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

private class ButtonHandler implements ActionListener
{
  private boolean on = true;
  public void actionPerformed(ActionEvent e)
  {
    PrintArrayT t = new PrintArrayT(app);
    if (e.getSource() == fillValues)
    {
      disableButtons();
      fillValues.requestFocus();
      bc.setActivity(0);
      t.start();
    }
    else if (e.getSource() == printArray)
    {
      disableButtons();
      printArray.requestFocus();
      bc.setActivity(1);
      t.start();
    }
    else if (e.getSource() == setValues)
    {
      disableButtons();
      setValues.requestFocus();
      bc.setActivity(2);
      t.start();
    }
    else if (e.getSource() == countFrequency)
    {
      disableButtons();
      countFrequency.requestFocus();
      bc.setActivity(3);
      t.start();
    }
    else if (e.getSource() == findMinimum)
    {
      disableButtons();
      findMinimum.requestFocus();
      bc.setActivity(4);
      t.start();
    }
  }
}

private class PrintArrayT extends Thread
{
  int [] arr;
  ArrayPractice1 s1;
  public PrintArrayT(ArrayPractice1 s)
  {
    arr = ArrayPractice1.arr;
    s1 = s;
  }

  public void run()
  {
    startActivity(bc.getActivity());
  }
}

}
