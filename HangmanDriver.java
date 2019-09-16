/**
* @author Alvin Tran
* @author Justin Le
* Hangman Project
* 9/28/19
*/

import java.util.*;
import java.lang.*;

public class Hangman
{
   //This is an array of Strings
   static String movieList[]={"Star Wars: The Last Jedi", "Bumblebee", "The Matrix", "Avatar", "Doctor Strange", "Avengers: Infinity War", "Sprited Away", "Guardians of the Galaxy", "Blade Runner 2049", "Patlabor 2", "The Towering Inferno"};
   // add more to this list by adding more String Literals se"Battleship","Bumblebee",parated by commas
   /**
    * Entry point of the program
    * @param args input arguments
    */
	public static void main(String[] args)
	{
		int count=0;
		int found=0;
		int playing=1;
		String movie=movieList[new Random().nextInt(movieList.length)];// picks a random element from movieList
		StringBuilder currentGuess=new StringBuilder(movie);// converts string into a strngbuilder
		StringBuilder correctGuess=new StringBuilder(movie);// creates a stringbuilder to check currentGuess
		Scanner scanner=new Scanner(System.in);

		for(int i=0; i<currentGuess.length(); i++)//Replaces all letters in currentGuess with '*'
		{
			if(Character.isLetter(currentGuess.charAt(i)))
			{
				currentGuess.setCharAt(i,'*');
			}
		}

		System.out.println(currentGuess);

		while(count<8 && playing==1)
		{
			System.out.println("Enter a character: ");
			String str=scanner.nextLine(); //allows user to enter input
			char c=str.charAt(0); //validation that only allows first character to be checked

			for(int i=0; i<correctGuess.length(); i++) //iterates through correctGuess
			{
				if(Character.toLowerCase(correctGuess.charAt(i))==Character.toLowerCase(c)) //checks to see if c is equal to any character in correctGuess
				{
					found=1;
					currentGuess.setCharAt(i,correctGuess.charAt(i)); //replaces '*' with correct letters
		    	}
			}
			System.out.println(currentGuess.toString()); //prints currentGuess

			for(int i=0; i<correctGuess.length(); i++) //for loop that checks if game is still ongoing
				{
					if(currentGuess.charAt(i)==correctGuess.charAt(i))
					{
						playing=0; //Game Over: User Wins
					}
					else
					{
						playing=1; //Game Still Ongoing
						break;
					}
				}

			if(found==0)
			{
				count+=1;//increases count by 1 for every incorrect guess
			}

			found=0;//resets found to 0 after every guess

			if(count==1) 
			{
				System.out.println(c + " is not a letter");
				System.out.println("Wrong guess, try again");
				System.out.println();
			 	System.out.println();
			 	System.out.println();
			 	System.out.println();
			 	System.out.println("___|___");
			 	System.out.println();
			 }
			 if(count==2) 
			 {
			 	System.out.println(c + " is not a letter");
			 	System.out.println("Wrong guess, try again");
			 	System.out.println("   |");
			 	System.out.println("   |");
			 	System.out.println("   |");
			 	System.out.println("   |");
			 	System.out.println("   |");
			 	System.out.println("   |");
			 	System.out.println("   |");
			 	System.out.println("___|___");
			 }
			 if(count==3) 
			 {
			 	System.out.println("Wrong guess, try again");
		 		System.out.println("   ____________");
			 	System.out.println("   |");
			 	System.out.println("   |");
			 	System.out.println("   |");
			 	System.out.println("   |");
			 	System.out.println("   |");
			 	System.out.println("   |");
			 	System.out.println("   | ");
			 	System.out.println("___|___");
			 }
			 if(count==4)
			 {
			 	System.out.println("Wrong guess, try again");
			 	System.out.println("   ____________");
			 	System.out.println("   |          _|_");
			 	System.out.println("   |         /   \\");
			 	System.out.println("   |        		");
			 	System.out.println("   |        		");
			 	System.out.println("   |");
			 	System.out.println("   |");
			 	System.out.println("   |");
			 	System.out.println("___|___");
			 }
			 if(count==5) 
			 {
			 	System.out.println("Wrong guess, try again");
			 	System.out.println("   ____________");
			 	System.out.println("   |          _|_");
			 	System.out.println("   |         /   \\");
			 	System.out.println("   |        |     |");
			 	System.out.println("   |         \\_ _/");
			 	System.out.println("   |           ");
			 	System.out.println("   |           ");
			 	System.out.println("   |");
			 	System.out.println("___|___");
			 }
			 if(count==6) 
			 {
			 	// System.out.println(c + " is not a letter");
			 	System.out.println("Wrong guess, try again");
			 	System.out.println("   ____________");
			 	System.out.println("   |          _|_");
			 	System.out.println("   |         /   \\");
			 	System.out.println("   |        |     |");
			 	System.out.println("   |         \\_ _/");
			 	System.out.println("   |           |");
			 	System.out.println("   |           |");
			 	System.out.println("   |           ");
			 	System.out.println("___|___        ");
			 }
			 if(count==7) 
			 {
			 	// System.out.println(c + " is not a letter");
			 	System.out.println("Wrong guess, try again");
			 	System.out.println("   ____________");
			 	System.out.println("   |          _|_");
			 	System.out.println("   |         /   \\");
			 	System.out.println("   |        |     |");
			 	System.out.println("   |         \\_ _/");
			 	System.out.println("   |           |");
			 	System.out.println("   |           |");
			 	System.out.println("   |          /  ");
			 	System.out.println("___|___      /   ");
			 }
			 if(count==8) 
			 {
			 	System.out.println("GAME OVER!");
			 	System.out.println("   ____________");
			 	System.out.println("   |          _|_");
			 	System.out.println("   |         /   \\");
		 		System.out.println("   |        |     |");
			 	System.out.println("   |         \\_ _/");
			 	System.out.println("   |          _|_");
			 	System.out.println("   |         / | \\");
			 	System.out.println("   |          / \\ ");
			 	System.out.println("___|___      /   \\");
			 	System.out.println("GAME OVER! The movie was " + movie);
			 	break;
			 }
		}
		if(playing==0) // Sets the results of the game
		{
			System.out.println("You Win!");
		}
		else
		{
			System.out.println("You Lose!"); //Prints if count==7
		}
	}
}

