/* BarChart Class
   Anderson, Franceschi
   Mark Johnson
*/
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;

public class BarChart
{
  public static int XMAX = 400;
  public static int YMAX = 250;

  private int [] data;
  private int barSize;
  private int xStart;
  private int activity = 4;
  private int studentResult;
  private int exactFrequencyCount;
  private int exactMinimum;
  private int key;
  private boolean checkNewValues;

  public BarChart( int [] dArray )
  {
    data = new int [dArray.length];
    for ( int i = 0; i < dArray.length; i++ )
    {
        data[i] = dArray[i];
    }
    barSize = ( XMAX - 20 ) / data.length;
    studentResult = -1;
    exactFrequencyCount = -1;
    exactMinimum = -1;
    key = -1;
    checkNewValues = true;
  }

  public void setArray( int [] dArray )
  {
    for ( int i = 0; i < dArray.length; i++ )
    {
        data[i] = dArray[i];
    }
  }

  public void setStudentResult( int newStudentResult )
  {
    studentResult = newStudentResult;
  }

  public void setKey( int newKey )
  {
    key = newKey;
  }

  public int getExactFrequencyCount( )
  {
    return exactFrequencyCount;
  }

  public int getExactMinimum( )
  {
    return exactMinimum;
  }

  public void setActivity( int a )
  {
    activity = a;
  }

  public int getActivity( )
  {
    return activity;
  }

  public boolean getCheckNewValues( )
  {
    return checkNewValues;
  }

  public void updateBarChart( int key, int index, Graphics g )
  {
    draw( g );
    switch( activity )
    {
      case 0:  // fill values
                break;
      case 1:  // print out the array
               // count++;
              drawArray( index, g );
              break;
      case 2: // set all array values to a certain value
              drawNewValue( index, g );
              break;
      case 3: // count frequency of key
              drawFrequency( key, g );
              break;
      case 4: // find the minimum
              drawMinimum( g );
              break;
    }
  }

  public void draw( Graphics g )
  {
    xStart = 10;
    g.setColor( Color.BLUE );

    for ( int i = 0; i < data.length; i++ )
    {
        g.fillRect( xStart, YMAX - 25 - data[i], barSize-5, data[i] );
        g.drawString( String.valueOf(data[i]), xStart, YMAX - 5 );
        xStart += barSize;
    }
  }

  public void drawArray( int index, Graphics g )
  {
    xStart = 10;
    g.setColor( Color.RED );

    for ( int i = 0; i <= index; i++ )
    {
        g.fillRect( xStart, YMAX - 25 - data[i], barSize-5, data[i] );
        g.drawString( String.valueOf( data[i]), xStart, YMAX - 5 );
        xStart += barSize;
    }
  }

  public void drawNewValue( int index, Graphics g )
  {
    xStart = 10;
    g.setColor( Color.BLUE );
    String s = "";
    checkCurrentNewValues( index );
    if ( checkNewValues )
      s = "correctly";
    else
      s = "incorrectly";
    g.drawString( "Setting new array elements to " + key, 25, 115 );
    g.drawString( "Up to index " + index + ", the new values are set " + s, 25, 135 );
    g.setColor( Color.RED );

    for ( int i = 0; i <= index; i++ )
    {
        g.fillRect( xStart, YMAX - 25 - data[i], barSize-5, data[i] );
        g.drawString( String.valueOf( data[i] ), xStart, YMAX - 5 );
        xStart += barSize;
    }
  }

  public void drawFrequency( int key, Graphics g )
  {
    int a = ArrayPractice1.getCurrent( );

    if ( a != -1 )
    {
      g.setColor( Color.BLUE );
      g.drawString( "Your current frequency count: " + studentResult, 25, 115 );
      exactFrequencyCount = findExactFrequencyCount( a, key );
      g.drawString( "Correct current frequency count: " + exactFrequencyCount, 25, 135 );

      if ( data[a] != key )
      {
          g.setColor( Color.RED );
          xStart = 10 + a * barSize;
          g.drawRect( xStart, YMAX - 25 - key, barSize - 5, key );
      }
      else
      {
          g.setColor( Color.RED );
          xStart = 10 + a * barSize;
          g.fillRect( xStart, YMAX - 25 - key, barSize - 5, key );
          g.drawString( String.valueOf( data[a] ), xStart, YMAX - 5 );
      }

      xStart = 10;
      for ( int i = 0; i < a; i++ )
      {
          if ( data[i] == key )
          {
              g.setColor( Color.RED );
              g.fillRect( xStart, YMAX - 25 - data[i], barSize-5, data[i] );
              g.drawString( String.valueOf( data[i] ), xStart, YMAX - 5 );
          }
          xStart += barSize;
      }
    }
  }

  public int findExactFrequencyCount( int index, int key )
  {
    int currentCount = 0;
    for ( int i = 0; i <= index; i++ )
    {
        if ( data[i] == key )
            currentCount++;
    }

    return currentCount;
  }

  public void drawMinimum( Graphics g )
  {
    int a = ArrayPractice1.getCurrent( );
    int b = findSubMinimum( a );

    if ( a != -1 )
    {
      g.setColor( Color.BLUE );
      g.drawString( "Your current minimum: " + studentResult, 25, 115 );
      exactMinimum = b;
      g.drawString( "Correct current minimum: " + exactMinimum, 25, 135 );

      g.setColor( Color.RED );
      xStart = 10 + a * barSize;
      g.drawRect( xStart, YMAX - 25 - data[a], barSize-5, data[a] );
      xStart = 10;

      for ( int i = 0; i <= a; i++ )
      {
        if ( data[i] == b )
        {
          g.setColor( Color.RED );
          g.fillRect( xStart, YMAX - 25 - data[i], barSize-5, data[i] );
          g.drawString( String.valueOf(data[i]), xStart, YMAX - 5 );
          break;
         }
         xStart += barSize;
      }
    }
  }

  public int findSubMinimum( int index )
  {
    int minimum = data[0];
    for ( int i = 0; i <= index; i++ )
    {
        if ( minimum > data[i] )
            minimum = data[i];
    }

    return minimum;
  }

  public void checkCurrentNewValues( int index )
  {
    checkNewValues = true;
    for ( int i = 0; i <= index; i++ )
    {
        if ( key != data[i] )
            checkNewValues = false;
    }
  }
}
