import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

 Dead [] plague;
 Living man = new Living(250, 250);
 boolean alive;
 public void setup()   
 {     
 	background(0);
 	size(500,500);
 	noStroke();
 	plague = new Dead[10];
 	for(int i = 0; i < plague.length; i++)
 	{
 		plague[i] = new Dead((int)(Math.random()*491), (int)(Math.random()*491));
 	} 
 }   
 public void draw()   
 {   
 	fill(0, 25);
 	rect(-25, -25, 550, 550);
 	if(alive == true)
 	{
 		man.walk();
 	}
 	for(int i = 0; i < plague.length; i++)
 	{
 		plague[i].spookyWalk();
 		plague[i].kill();
 	} 
 }
 public void mousePressed()
 {
 	alive = true;
 	man = new Living(mouseX, mouseY);
 }  
 class Living //green orb that the ghost orbs seek out
 {
 	int myX, myY;
 	Living(int x, int y)
 	{
 		myX = x;
 		myY = y;
 	}
 	public void walk()
 	{
 		int randomX = (int)(Math.random()*7) - 3;
 		int randomY = (int)(Math.random()*7) - 3;
 		fill(0, 150, 50, 50);
 		ellipse(myX, myY, 25, 25);
 		fill(0, 255, 150, 100);
 		ellipse(myX + randomX, myY + randomY, 15, 15);
 		fill(255, 255, 255, 125);
 		ellipse(myX + randomX*2, myY + randomY*2, 10, 10);
 		if(myX < 0)
 		{
 			myX += 1;
 		}
 		else if(myX > 500)
 		{
 			myX += -1;
 		}
 		else
 		{
 			myX += randomX;
 		}
 		if(myY < 0)
 		{
 			myY += 1;
 		}
 		else if(myY > 500)
 		{
 			myY += -1;
 		}
 		else
 		{
 			myY += randomY;
 		}
 	}
 }
 class Dead //blue ghost orbs that randomly walk 
 {     
 	int muhX, muhY;
 	Dead(int x, int y)
 	{
 		muhX = x;
 		muhY = y;
 	}
 	public void spookyWalk()
 	{
 		int randomX = (int)(Math.random()*7) - 3;
 		int randomY = (int)(Math.random()*7) - 3;
 		fill(0, 50, 150, 50);
 		ellipse(muhX, muhY, 25, 25);
 		fill(0, 150, 255, 100);
 		ellipse(muhX + randomX, muhY + randomY, 15, 15);
 		fill(255, 255, 255, 125);
 		ellipse(muhX + randomX*2, muhY + randomY*2, 10, 10);
 		if(alive)
 		{
 			if (muhX > man.myX)
 			{
 				muhX += randomX - 2;
 			}
 			else if (muhX < man.myX)
 			{
 				muhX += randomX + 2;
 			}
 			if (muhY > man.myY)
 			{
 				muhY += randomY - 2;
 			}
 			else if (muhY < man.myY)
 			{
 				muhY += randomY + 2;
 			}
 		}
 		else 
 		{
 			if(muhX < 0)
 			{
 				muhX += 1;
 			}
 			else if(muhX > 500)
 			{
 				muhX += -1;
 			}
 			else
 			{
 				muhX += randomX;
 			}
 			if(muhY < 0)
 			{
 				muhY += 1;
 			}
 			else if(muhY > 500)
 			{
 				muhY += -1;
 			}
 			else
 			{
 				muhY += randomY;
 			}
 		}
 	} 
 	public void kill()
 	{
 		if(muhX == man.myX && muhY == man.myY)
 		{
 			alive = false;
 		}
 	} 
 }    
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
