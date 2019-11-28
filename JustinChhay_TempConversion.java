/*
    Name: Justin Chhay
    Date: 28.11.2019
    Teacher: Mr. Afsari-Nejad
    Description: Program uses reutrn method to convert user-inputted temperature (unit of choice) to other unit of choice.
*/

// The "JustinChhay_TempConversion" class.
import java.awt.*;
import hsa.Console;
import javax.swing.*; //Allows for JOptionPane usage

public class JustinChhay_TempConversion
{
    Console c;           // The output console

    //Class Variables
    char choice; //so that it knows what choice user wants throughout the class
    double temp; //so that it holds the input in ask data and carries it onto display
    char cUnit; //gonna hold the ans

    //Class Graphics Variables
    Font title = new Font ("MonoSpaced", Font.BOLD, 28); //Font - Variable for title
    Color background = new Color (192, 203, 252);  //Color - RGB values for background color


    // Class Constructor (creates the console)
    public JustinChhay_TempConversion ()
    {
	c = new Console ("Temperature Conversion Calculator by Justin Chhay");
    }


    // Main Method - Executes declared methods
    public static void main (String[] args)
    {
	//Creates Object of the Class JustinChhay_TempConversion
	JustinChhay_TempConversion x;
	x = new JustinChhay_TempConversion ();

	//Starts program with splashScreen method
	x.splashScreen ();


    }


    public double convertTemp (double temp, char cUnit)
    {

	double ans = 0.0;
	if (cUnit == '1')
	{
	    ans = temp * 4.5;

	}
	else if (cUnit == '2')
	{

	    ans = temp * 4.0;
	}
	return ans;

    }


    // Title Method - Clears previous screen and draws new background and title
    public void title ()
    {
	//Local Color Variables



	//Clears
	c.clear ();

	//Draws background
	c.setColor (background);
	c.fillRect (0, 0, 640, 500);


	//Draws title
	c.setFont (title);
	c.drawString ("Temperature Converter", 50, 100);

    }


    // Splash Screen Method - Appealing introduction animation
    public void splashScreen ()
    {
	//Local Color Variables
	Color thermometer = new Color (228, 235, 247); //Color - RGB values for glass color


	//
	c.setColor (background);
	c.fillRect (0, 0, 640, 500);

	c.setColor (thermometer);
	c.fillOval (50, 35, 100, 100);
	c.fillRect (75, 55, 460, 60);
	c.fillArc (500, 55, 60, 60, 90, -180);

	for (int x = 0 ; x < 30 ; x++)
	{
	    c.setColor (Color.black);
	    c.drawOval (175, 125 + x, 10, 10);
	    c.drawOval (255, 125 + x, 10, 10);
	    c.drawOval (335, 125 + x, 10, 10);
	    c.drawOval (415, 125 + x, 10, 10);
	    c.drawOval (495, 125 + x, 10, 10);        
	}

	for (int x = 0 ; x < 15 ; x++)
	{
	    
	    c.drawOval (195, 125 + x, 7, 7);
	    c.drawOval (215, 125 + x, 7, 7);
	    c.drawOval (235, 125 + x, 7, 7);
	    
	    c.drawOval (275, 125 + x, 7, 7);
	    c.drawOval (295, 125 + x, 7, 7);
	    c.drawOval (315, 125 + x, 7, 7);
	    
	    c.drawOval (355, 125 + x, 7, 7);
	    c.drawOval (375, 125 + x, 7, 7);
	    c.drawOval (395, 125 + x, 7, 7);
	    
	    c.drawOval (435, 125 + x, 7, 7);
	    c.drawOval (455, 125 + x, 7, 7);
	    c.drawOval (475, 125 + x, 7, 7);
	    
	}

	c.setColor (Color.red);
	c.fillOval (60, 45, 80, 80);


	for (int x = 0 ; x < 440 ; x++)
	{
	    c.fillRect (90, 65, x, 40);

	    try
	    {
		Thread.sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	}

	for (int x = 0 ; x < 10 ; x++)
	{
	    c.fillOval (500 + x, 65, 40, 40);
	    try
	    {
		Thread.sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	}

	c.setColor (Color.white);
	c.setFont (title);
	c.drawString ("Temperature Converter", 125, 100);




	JOptionPane.showMessageDialog (null, "Press OK to continue.");
	instructions ();
    }


    // Instructions Method - Informs user of directions on use and purpose of this program
    public void instructions ()
    {
	title ();

	c.drawString ("INSTRUCTIONS", 0, 0);
    }
} // JustinChhay_TempConversion class


