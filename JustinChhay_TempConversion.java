/*
    Name: Justin Chhay
    Date: 28.11.2019
    Teacher: Mr. Afsari-Nejad
    Description: Program uses return method to convert user-inputted temperature (unit of choice) to other unit of choice.
*/


// The "JustinChhay_TempConversion" class.
import java.awt.*;
import hsa.Console;
import javax.swing.*; //Allows for JOptionPane usage

public class JustinChhay_TempConversion
{
    Console c;           // The output console

    //Class Variables
    char choice; // knows what choice user wants throughout the class
    double temp; // holds the input in ask data and carries it onto display

    String choice2; //Needed to take input from JOptionPane.showInputDialog for choice
    double cUnit; // variable which will hold the answer from the return method (convertTemp)

    boolean pAskData = false; //needed to ensure user returns back to askData after pauseProgram method
    boolean pDisplay = false; //needed to ensure user returns back to display after pauseProgram method

    //Class Font Variables
    Font title = new Font ("MonoSpaced", Font.BOLD, 28); //Font - Variable for title
    Font method = new Font ("Serif", Font.PLAIN, 32); //Font - Variable for method indicator
    Font text = new Font ("MonoSpaced", Font.BOLD, 18);

    //Class Color Variables
    Color background = new Color (52, 100, 235);  //Color - RGB values for background color
    Color thermometer = new Color (228, 235, 247); //Color - RGB values for glass color

    // Main Method - Executes declared methods
    public static void main (String[] args)
    {
	//Creates Object of the Class JustinChhay_TempConversion
	JustinChhay_TempConversion x;
	x = new JustinChhay_TempConversion ();

	//Starts program with splashScreen method
	x.splashScreen ();
    }


    // Splash Screen Method - Appealing introduction animation
    public void splashScreen ()
    {
	//Local Color Variables
	Color sun = new Color (255, 204, 0);

	//Draws background
	c.setColor (background);
	c.fillRect (0, 0, 640, 500);

	//Draws Name and Method
	c.setFont (method);
	c.setColor (Color.white);
	c.drawString ("by Justin Chhay", 20, 480);
	c.drawString ("SplashScreen", 450, 480);

	//Draws Sun
	c.setColor (sun);
	c.fillOval (130, 250, 150, 150);

	//For Loop - Draws Snowflake
	for (int x = 0 ; x < 100 ; x++)
	{
	    c.setColor (Color.white);
	    c.drawOval (375 + x, 325, 10, 10);
	    c.drawOval (425, 275 + x, 10, 10);
	    c.drawOval (375 + x, 275 + x, 10, 10);
	    c.drawOval (375 + x, 375 - x, 10, 10);
	}

	//Draws thermometer
	c.setColor (thermometer);
	c.fillOval (50, 35, 100, 100);
	c.fillRect (75, 55, 460, 60);
	c.fillArc (500, 55, 60, 60, 90, -180);

	//ForLoop - Draws Large Ticks for Measurement
	for (int x = 0 ; x < 30 ; x++)
	{
	    c.setColor (Color.black);
	    c.drawOval (175, 125 + x, 10, 10);
	    c.drawOval (255, 125 + x, 10, 10);
	    c.drawOval (335, 125 + x, 10, 10);
	    c.drawOval (415, 125 + x, 10, 10);
	    c.drawOval (495, 125 + x, 10, 10);
	}

	//ForLoop - Draws Small Ticks for Measurement
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

	//Draws Red Mercury in Thermometer
	c.setColor (Color.red);
	c.fillOval (60, 45, 80, 80);

	//For Loop- Draws Mercury Rising
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

	//For Loop- Draws Mercury Rising (needed to fill in arc of glass)
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

	//Draws Title
	c.setFont (title);
	c.setColor (Color.white);
	c.drawString ("Temperature Converter", 153, 95);

	//JOptionPane Message - Confirmation before advancing to main menu
	JOptionPane.showMessageDialog (null, "Press OK to advance.");
	mainMenu ();
    }


    // Instructions Method - Informs user of directions on use and purpose of this program
    public void mainMenu ()
    {
	//Clears screen with title header (thermometer)
	title ();

	//Indicates which method user is currently on
	c.setFont (method);
	c.drawString ("Main Menu", 450, 480);

	//Text - Program Options
	c.setFont (text);
	c.setColor (Color.white);
	c.drawString ("1) Celsius to Fahrenheit", 50, 200);
	c.drawString ("2) Celsius to Kelvin", 50, 250);
	c.drawString ("3) Fahrenheit to Celsius", 50, 300);
	c.drawString ("4) Fahrenheit to Kelvin", 50, 350);
	c.drawString ("5) Kelvin to Fahrenheit", 350, 200);
	c.drawString ("6) Kelvin to Celsius", 350, 250);
	c.drawString ("7) Instructions", 350, 300);
	c.drawString ("Press ANY other key to EXIT.", 150, 400);

	//Try Catch - ErrorTrap for CHOICE (ensures program won't crash or stop if user clicks on cancel or X button)
	try
	{
	    //JOptionPane - Asks user for choice in main menu (Determines next output screen)
	    choice2 = JOptionPane.showInputDialog (null, "Please enter an option:\n 1 for Celsius to Fahrenheit\n 2 for Celsius to Kelvin\n 3 for Fahrenheit to Celsius\n 4 for Fahrenheit to Kelvin\n 5 for Kelvin to Fahrenheit\n 6 for Kelvin to Celsius\n 7 for Instructions\n ANY OTHER KEY TO EXIT");

	    //If Structure - Calls a specific method depending on user input for choice2
	    if (choice2.equals ("1") || choice2.equals ("2") || choice2.equals ("3") || choice2.equals ("4") || choice2.equals ("5") || choice2.equals ("6"))
	    {
		askData (); //If user chooses a specified conversion, run askData();
	    }
	    else if (choice2.equals ("7"))
	    {
		instructions (); //If user chooses 7, run instructions();
	    }
	    else
	    {
		goodbye (); //if user inputs anything else, run goodbye(); to exit
	    }
	}
	catch (Exception e)
	{
	    //Error Trap - If user closes or cancels input, will call intro method again
	    JOptionPane.showMessageDialog (null, "Invalid Input! You must input a character to advance.");
	    mainMenu ();
	}
    }


    // AskData Method - Asks for values needed to convert units
    private void askData ()
    {
	//Clears screen and draws title
	title ();

	//Indicates which method user is on
	c.setFont (method);
	c.drawString ("AskData", 450, 480);

	//Prompt for Pause (text)
	c.setFont (text);
	c.drawString ("Would you like to pause the program?", 125, 220);

	//JOptionPane - Asks if user wants to pause program
	int pause = JOptionPane.showConfirmDialog (null, "Would you like to PAUSE the program?");

	//If Structure - Will run pauseProgram(); or continue with askData(); depending on previous user input
	if (pause == JOptionPane.OK_OPTION)
	{
	    pAskData = true;  //Ensures that user returns back to askData method
	    pauseProgram ();
	}
	else if (pause == JOptionPane.NO_OPTION || pause == JOptionPane.CANCEL_OPTION || pause == JOptionPane.CLOSED_OPTION)
	{
	    //Erases prompt for pause text on screen
	    c.setFont (text);
	    c.setColor (background);
	    c.drawString ("Would you like to pause the program?", 125, 220);
	    c.setColor (Color.white);

	    //If Structure - Will output conversion statement depending on choice2 input from main menu
	    if (choice2.equals ("1"))
		c.drawString ("Converting Celsius (°C) to Fahrenheit (°F)", 50, 200);
	    else if (choice2.equals ("2"))
		c.drawString ("Converting Celsius (°C) to Kelvin (K)", 50, 200);
	    else if (choice2.equals ("3"))
		c.drawString ("Converting Fahrenheit (°F) to Celsius (°C)", 50, 200);
	    else if (choice2.equals ("4"))
		c.drawString ("Converting Fahrenheit (°F) to Kelvin (K)", 50, 200);
	    else if (choice2.equals ("5"))
		c.drawString ("Converting Kelvin (K) to Fahrenheit (°F)", 50, 200);
	    else if (choice2.equals ("6"))
		c.drawString ("Converting Kelvin (K) to Celsius (°C)", 50, 200);

	    //Text - Draws text for input prompt
	    c.drawString ("Enter a negative temperature: ", 50, 230);

	    //Try Catch - Error trap for temp, makes sure input is a number
	    try
	    {
		//JOptionPane - Asks user for input for negative temperature value to convert from (parses into double)
		temp = Double.parseDouble (JOptionPane.showInputDialog (null, "Please input a negative int/double value for the temperature you are converting from."));

		//If Structure - Error trap for temp, makes sure input is negative
		if (temp > 0.0)
		{
		    //Error Trap Message - JOptionPane.Message, will run askData(); again after outputting error statement
		    JOptionPane.showMessageDialog (null, "Invalid input! Please enter a negative value.");
		    askData ();
		}
	    }
	    catch (Exception e)
	    {
		//Error Trap Message - JOptionPane.Message, will run askData(); again after outputting error statement
		JOptionPane.showMessageDialog (null, "Invalid input! Please enter a numerical value.");
		askData ();
	    }

	    //If Structure - Will Output correct user-inputted temperature in correct unit
	    if (choice2.equals ("1"))
		c.drawString (temp + " °C", 375, 230);
	    else if (choice2.equals ("2"))
		c.drawString (temp + " °C", 375, 230);
	    else if (choice2.equals ("3"))
		c.drawString (temp + " °F", 375, 230);
	    else if (choice2.equals ("4"))
		c.drawString (temp + " °F", 375, 230);
	    else if (choice2.equals ("5"))
		c.drawString (temp + " K", 375, 230);
	    else if (choice2.equals ("6"))
		c.drawString (temp + " K", 375, 230);

	    //Will allow user to confirm advancing to display method
	    JOptionPane.showMessageDialog (null, "Press OK to advance.");
	    display ();
	}
    }


    // Display Method - Will display user-inputted conversion after specified conversion using the blackbox return method
    private void display ()
    {
	//Clears screen and draws title
	title ();

	//Indicates which method user is on
	c.setFont (method);
	c.drawString ("Display", 450, 480);

	//Prompt for Pause (text)
	c.setFont (text);
	c.drawString ("Would you like to pause the program?", 125, 220);

	//JOptionPane - Asks if user wants to pause program
	int pause = JOptionPane.showConfirmDialog (null, "Would you like to PAUSE the program?");

	//If Structure - Will run pauseProgram(); or continue with display(); depending on previous user input
	if (pause == JOptionPane.OK_OPTION)
	{
	    pDisplay = true;  //Ensures that user returns back to display method
	    pauseProgram ();
	}
	else if (pause == JOptionPane.NO_OPTION || pause == JOptionPane.CANCEL_OPTION || pause == JOptionPane.CLOSED_OPTION)
	{
	    //Erases prompt for pause (text)
	    c.setColor (background);
	    c.setFont (text);
	    c.drawString ("Would you like to pause the program?", 125, 220);

	    //Assigning String variable, choice 2, into char variable choice, for parameter inside return method
	    choice = choice2.charAt (0);

	    //Calling the return method and storing it in a double variable called cUnit (current unit)
	    cUnit = convertTemp (temp, choice);
	    c.setColor (Color.white);
	    c.setFont (text);

	    //If Structure - Depedning on user choice, it will output the correct specified conversion with appropriate units
	    if (choice2.equals ("1")) // Celsius to Fahrenheit
	    {
		c.drawString ("Converted " + temp + " °C to " + cUnit + " °F", 50, 240);
		c.drawString ("Conversion from Celsius to Fahrenheit completed.", 50, 270);
	    }
	    else if (choice2.equals ("2")) // Celsius to Kelvin
	    {
		c.drawString ("Converted " + temp + " °C to " + cUnit + " K", 50, 240);
		c.drawString ("Conversion from Celsius to Kelvin completed.", 50, 270);
	    }
	    else if (choice2.equals ("3")) // Fahrenheit to Celsius
	    {
		c.drawString ("Converted " + temp + " °F to " + cUnit + " °C", 50, 240);
		c.drawString ("Conversion from Fahrenheit to Celsius completed.", 50, 270);
	    }
	    else if (choice2.equals ("4")) // Fahrenheit to Kelvin
	    {
		c.drawString ("Converted " + temp + " °F to " + cUnit + " K", 50, 240);
		c.drawString ("Conversion from Fahrenheit to Kelvin completed.", 50, 270);
	    }
	    else if (choice2.equals ("5")) // Kelvin to Fahrenheit
	    {
		c.drawString ("Converted " + temp + " K to " + cUnit + " °F", 50, 240);
		c.drawString ("Conversion from Kelvin to Fahrenheit completed.", 50, 270);
	    }
	    else if (choice2.equals ("6")) // Kelvin to Celsius
	    {
		c.drawString ("Converted " + temp + " K to " + cUnit + " °C", 50, 240);
		c.drawString ("Conversion from Kelvin to Celsius completed.", 50, 270);
	    }

	    //Confirms with user before advancing to main menu
	    JOptionPane.showMessageDialog (null, "Press OK to return to main menu.");
	    mainMenu ();
	}
    }


    // PauseProgram Method - Pauses program during askData or display method
    public void pauseProgram ()
    {
	//Clears screen and draws title
	title ();

	//Indicates which method user is on
	c.setFont (method);
	c.drawString ("PauseProgram", 450, 480);

	//Pause Statement
	c.setFont (text);
	c.drawString ("PROGRAM PAUSED", 240, 220);

	//JOptionPane - Needed so that the program allows user to stop and view output
	JOptionPane.showMessageDialog (null, "Click OK to ADVANCE.");

	//If structure will return user to previous method
	if (pAskData == true)
	{
	    pAskData = false;  //Ensures that user returns back to askData method
	    askData ();        //Runs previous method (askData)
	}
	else if (pDisplay == true)
	{
	    pDisplay = false;  //Ensures that user returns back to display method
	    display ();        //Runs previous method (display)
	}
    }


    // Instructions Method
    public void instructions ()
    {
	//Clears screen and draws title
	title ();

	//Indicates which method user is on
	c.setFont (method);
	c.drawString ("Instructions", 450, 480);

	//Instructions to use program (text)
	c.setFont (text);
	c.drawString ("My program will calculate any specified conversion", 30, 180);
	c.drawString ("between negative temperature values of:", 30, 200);
	c.drawString ("Celsius, Fahrenheit, and Kelvin", 160, 220);
	c.drawString ("Step 1) Input a key in the main menu to", 65, 250);
	c.drawString ("        choose an option.", 65, 270);
	c.drawString ("Step 2) Enter an appropriate negative temperature.", 65, 300);
	c.drawString ("        (the unit you are converting from)", 65, 320);
	c.drawString ("Step 3) Conversion complete. ", 65, 350);
	c.drawString ("You will then return back to the main menu, where", 35, 390);
	c.drawString ("you can repeat the program or exit it.", 35, 410);

	//JOptionPane Message - Confirms with user before returning to main menu
	JOptionPane.showMessageDialog (null, "Press OK to return to main menu.");
	mainMenu ();
    }


    // Goodbye Method - Salutations to user
    public void goodbye ()
    {
	//Clears screen and draws title
	title ();

	//Indicates which method user is on
	c.setFont (method);
	c.drawString ("Goodbye", 450, 480);

	//Text
	c.setFont (text);
	c.drawString ("Thanks for using this program!", 120, 200);
	c.drawString ("Name: Justin Chhay", 150, 230);
	c.drawString ("Teacher: Mr. Afsari-Nejad", 150, 260);
	c.drawString ("Due Date: 02.12.2019", 150, 290);
	c.drawString ("Course Code: ICS3U6", 150, 320);

	//JOptionPane Message - Confirms with user before exiting program
	JOptionPane.showMessageDialog (null, "Goodbye");
	System.exit (0); //Exits program after confirmation with exit code 0
    }


    // Title Method - Clears previous screen and draws new background and title
    public void title ()
    {
	//Clears
	c.clear ();

	//Draws background
	c.setColor (background);
	c.fillRect (0, 0, 640, 500);

	//Draws Name
	c.setFont (method);
	c.setColor (Color.white);
	c.drawString ("by Justin Chhay", 20, 480);

	//Draws thermometer
	c.setColor (thermometer);
	c.fillOval (50, 20, 100, 100);
	c.fillRect (75, 40, 460, 60);
	c.fillArc (500, 40, 60, 60, 90, -180);

	//ForLoop - Draws Large Ticks for Measurement
	for (int x = 0 ; x < 20 ; x++)
	{
	    c.setColor (Color.black);
	    c.drawOval (175, 110 + x, 10, 10);
	    c.drawOval (255, 110 + x, 10, 10);
	    c.drawOval (335, 110 + x, 10, 10);
	    c.drawOval (415, 110 + x, 10, 10);
	    c.drawOval (495, 110 + x, 10, 10);
	}

	//ForLoop - Draws Small Ticks for Measurement
	for (int x = 0 ; x < 10 ; x++)
	{
	    c.drawOval (195, 110 + x, 7, 7);
	    c.drawOval (215, 110 + x, 7, 7);
	    c.drawOval (235, 110 + x, 7, 7);

	    c.drawOval (275, 110 + x, 7, 7);
	    c.drawOval (295, 110 + x, 7, 7);
	    c.drawOval (315, 110 + x, 7, 7);

	    c.drawOval (355, 110 + x, 7, 7);
	    c.drawOval (375, 110 + x, 7, 7);
	    c.drawOval (395, 110 + x, 7, 7);

	    c.drawOval (435, 110 + x, 7, 7);
	    c.drawOval (455, 110 + x, 7, 7);
	    c.drawOval (475, 110 + x, 7, 7);
	}

	//Draws Red Mercury in Thermometer
	c.setColor (Color.red);
	c.fillOval (60, 30, 80, 80);
	c.fillRect (90, 50, 440, 40);

	//ForLoop - Also draws red mercury
	for (int x = 0 ; x < 10 ; x++)
	{
	    c.fillOval (500 + x, 50, 40, 40);
	}

	//Draws title
	c.setFont (title);
	c.setColor (Color.white);
	c.drawString ("Temperature Converter", 153, 80);
    }


    // Return method - convertTemp will calculate a specified conversion based off the value and choice given
    private double convertTemp (double temp, char choice)
    {
	//Initialized double variable to hold answer (current unit)
	double cUnit = 0.0;

	//If Structure - Depending on char choice, program will execute specified conversion
	if (choice == '1' || choice == '5')  //Converting to Fahrenheit
	{
	    if (choice == '1') //celsius to fahrenheit
		cUnit = (temp * 1.8) + 32;
	    if (choice == '5') //kelvin to fahrenheit
		cUnit = (temp - 273.15) * 1.8 + 32;
	}
	else if (choice == '2' || choice == '4')  //Converting to Kelvin
	{
	    if (choice == '2') //celsius to kelvin
		cUnit = temp + 273.15;
	    if (choice == '4') //fahrenheit to kelvin
		cUnit = (temp - 32.0) * (5.0 / 9.0) + 273.15;
	}
	else if (choice == '3' || choice == '6')   //Converting to Celsius
	{
	    if (choice == '3') //fahrenheit to celsius
		cUnit = (temp - 32) * (5.0 / 9.0);
	    if (choice == '6') //kelvin to celsius
		cUnit = temp - 273.15;
	}

	//Return answer after conversion
	return cUnit;
    }


    // Class Constructor (creates the console)
    public JustinChhay_TempConversion ()
    {
	//The String parameter gives window title
	c = new Console ("Temperature Conversion Calculator by Justin Chhay");
    }
} // JustinChhay_TempConversion class


