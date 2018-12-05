// Mark Johnson

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JApplet;

// Replace AppletTemplate with your applet's class name:
// You will also have to change the name of this file to match.

public class Computer extends JApplet
{

public void paint(Graphics g)
{
  super.paint(g);

  //Your drawing code goes here:
int sX = 100;
int sY = 25;
Color brown = new Color(128,128,0);

//Monitor on the computer + color
g.setColor(Color.black);
g.fillRect(sX + 35, sY + 5, 130, 125);
g.drawRect(sX + 35, sY + 5, 130, 125);

g.setColor(Color.blue);
g.drawRect(sX + 42, sY + 13, 115, 110);
g.fillRect(sX + 42, sY + 13, 115, 110);

//Legs of the Computer + color
g.setColor(Color.black);
g.drawLine(sX + 50, sY + 150, sX + 70, sY + 130);
g.drawLine(sX + 40, sY + 150, sX + 60, sY + 130);
g.drawLine(sX + 150, sY + 150, sX + 130, sY + 130);
g.drawLine(sX + 160, sY + 150, sX + 140, sY + 130);

//Desk + color
g.setColor(brown);
g.fillRect(sX - 50, sY + 150, 300, 10);
g.drawRect(sX - 50, sY + 150, 300, 10);

//Speakers
g.setColor(Color.black);
g.fillRect(sX - 25, sY + 75, 45, 75); //Rect
g.setColor(Color.gray);
g.fillOval(sX - 25, sY + 75, 45, 75); // oval
g.setColor(Color.black);
g.fillOval(sX - 15, sY + 100, 25, 25); //circle

g.setColor(Color.black);
g.fillRect(sX + 180, sY + 75, 45, 75);
g.setColor(Color.gray);
g.fillOval(sX + 180, sY + 75, 45, 75);
g.setColor(Color.black);
g.fillOval(sX + 190, sY + 100, 25, 25);

//Polygon
g.setColor(Color.yellow);
Polygon hexagon = new Polygon();
hexagon.addPoint(155, 90);
hexagon.addPoint(180, 53);
hexagon.addPoint(230, 53);
hexagon.addPoint(255, 90);
hexagon.addPoint(230, 132);
hexagon.addPoint(180, 132);
g.fillPolygon( hexagon );

//Error Message
g.setColor(Color.yellow);
g.drawString("Error: ", 145, 50);
}

}
