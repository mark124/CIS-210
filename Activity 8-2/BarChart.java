/* Draws a Bar Chart
* Anderson, Franceschi
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
  private int activity = 0;

  public BarChart( )
  {}

  public BarChart( int [] dArray )
  {
    data = new int [dArray.length];
    for ( int i = 0; i < dArray.length; i++ )
    {
        data[i] = dArray[i];
    }
    barSize = ( XMAX - 20 ) / data.length;
  }

  public void setArray( int [] dArray )
  {
    for ( int i = 0; i < dArray.length; i++ )
    {
        data[i] = dArray[i];
    }
  }

  public void setActivity( int a )
  {
    activity = a;
  }

  public int getActivity( )
  {
    return activity;
  }

  public void updateBarChart( int key, int index, Graphics g )
  {
    switch( activity )
    {
        case 0: // sequential search
                  draw( g );
                  drawSequentialSearch( key, g );
                  break;
        case 1: // bubble sort
                  draw( g );
                  drawBubbleSort( g );
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
        g.drawString( String.valueOf( data[i]), xStart, YMAX - 5 );
        xStart += barSize;
    }
  }

  public void drawBubbleSort ( Graphics g )
  {
    xStart = 10;
    int a = ArrayPractice2.getCurrent1( );
    int b = ArrayPractice2.getCurrent2( );
    if ( a != -1 && b != -1 )
    {
        g.setColor( Color.RED );
        xStart = 10 + b * barSize;
        g.drawRect( xStart, YMAX - 25 - data[b], barSize-5, data[b] );
        g.drawString( String.valueOf( data[b] ), xStart, YMAX - 5 );
        xStart = 10 + ( b + 1 ) * barSize;
        g.drawRect( xStart, YMAX - 25 - data[b + 1], barSize-5, data[b + 1] );
        g.drawString( String.valueOf( data[b + 1] ), xStart, YMAX - 5 );
    }
  }

  public void drawSequentialSearch( int key, Graphics g )
  {
    int a = ArrayPractice2.getCurrent1( );
    if ( a != -1 )
    {
        g.setColor( Color.RED );
        xStart = 10 + a * barSize;
        g.drawRect( xStart, YMAX - 25 - key, barSize-5, key );
        g.drawString( String.valueOf( data[a] ), xStart, YMAX - 5 );
    }
  }
}
