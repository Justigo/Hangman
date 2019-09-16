/**
* @author Alvin Tran
* @author Justin Le
* Hangman Project
* 9/28/19
*/

import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.Random;
import java.util.ArrayList;

public class HangmanDriver
{
   //This is an array of Strings
   private static String movieList[]={"Star Wars: The Last Jedi", "The Matrix", "Avatar", 
   		"Doctor Strange", "Avengers: Infinity War", "Sprited Away", "Guardians of the Galaxy", 
   		"Willow", "Place beyond the Pines", "The Towering Inferno"};

   /** Entry point of the program */
	public static void main(String[] args)
	{
		int countErrors = 0, found = 0, playing = 1;
		String movie = movieList[new Random().nextInt(movieList.length)];//random element:movieList
		StringBuilder currentGuess = new StringBuilder(movie); //string -> strngbuilder
		StringBuilder correctGuess = new StringBuilder(movie); //stringbuilder: check currentGuess
		Scanner input = new Scanner(System.in);
		ArrayList<Character> usedGuesses = new ArrayList<Character>();

		for(int i=0; i<currentGuess.length(); i++) //Replaces all letters in currentGuess with '*'
		{
			if(Character.isLetter(currentGuess.charAt(i)))
			{
				currentGuess.setCharAt(i,'*');
			}
		}
		instructionMenu();
		System.out.println(currentGuess);

		while(countErrors < 8){

			System.out.print("\nEnter a character: ");
			String guess = input.next(); //allows user to enter input
			char letterGuess = guess.charAt(0); //only allows first character to be checked

			if(guess.equalsIgnoreCase("MENU")){
				instructionMenu();
				System.out.println(currentGuess);

			}else if(guess.length() > 1){
				System.out.println("Only a SINGLE letter/number is allowed bozo!\ncurrentGuess");

			}else if(usedGuesses.contains(letterGuess)){

				System.out.println("Already used this one! BOZO!");

				for(int eachUsedGuess = 0; eachUsedGuess < usedGuesses.size(); eachUsedGuess++){
					if(eachUsedGuess == usedGuesses.size()-1){
						System.out.println(usedGuesses.get(eachUsedGuess));
					}else{
						System.out.print(usedGuesses.get(eachUsedGuess) + ", ");
					}
				}
				System.out.println(currentGuess);
			}else if((letterGuess >= 48 && letterGuess <= 57) || 
					(letterGuess >= 65 && letterGuess <= 90) || 
					(letterGuess >= 97 && letterGuess <= 122)){
				usedGuesses.add(letterGuess);

				for(int i=0; i<correctGuess.length(); i++){ //iterates through correctGuess

					if(Character.toLowerCase(correctGuess.charAt(i)) ==
						Character.toLowerCase(letterGuess)){ 
						found=1;
						currentGuess.setCharAt(i,correctGuess.charAt(i)); //replaces '*' -> correct
		    		}
				}
				if(found != 1){
					countErrors++;
					createHangmanArt(countErrors, correctGuess + "", letterGuess);
					System.out.printf("You have used %d/8 of your guesses%n", countErrors);
				}
				found = 0;
				System.out.println(currentGuess.toString()); //prints currentGuess

			}else{
				System.out.println("Only a SINGLE letter/number is allowed bozo!\ncurrentGuess");
			}

			
			if((currentGuess.substring(0)).equalsIgnoreCase(correctGuess.substring(0))){
				playing = 0;
				break; //Win Game;
			}
			

		}
		if(playing==0){ // Sets the results of the game
			System.out.println("You Win!");
		}else{
			System.out.println("You Lose!"); //Prints if count==7
		}
	}

	/** Creates hangman visual*/
	public static void createHangmanArt(int countErrors, String movie, char letterGuess){
		if(countErrors==1){
			System.out.println(letterGuess + " is not a letter");
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();

		}else if(countErrors==2){
			System.out.println(letterGuess + " is not a letter");
			System.out.println("Wrong guess, try again");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");

		}else if(countErrors==3){
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

		}else if(countErrors==4){
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

		}else if(countErrors==5){
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

		}else if(countErrors==6){
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

		}else if(countErrors==7){
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

		}else if(countErrors==8) {
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
		}
	}

	/** Creates an instructions menu */
	public static void instructionMenu(){
		System.out.println("\tINSTRUCTIONS\n" +
							"1) You have 8 chances to mess up\n"+
							"2) You can't guess the whole movie\n"+
							"3) Only letters and numbers are allowed" +
							"If you forget the rules, type MENU");
	}
}
