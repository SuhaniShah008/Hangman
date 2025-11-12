//Project By Abhi And Suhani
import java.util.Scanner; 
import java.util.Random; 
import java.io.FileReader;
public class Hangman
{
    private String[] wordLibrary = {"boot","donkey","awe","wonder","amaze"};
    // Array to keep track of wrong guesses
    private char[] lettersGuessed=new char[8];
    // Word user needs to guess
    private String secretWord;
    // Representation of the word with dashes for unguessed letters
    private char[] blankDashes;
    private int attemptsLeft=8;
    // Counter for wrong guesses
    private int counter=0;
    // String representation of blankDashes for printing
    String spacesHolder ="";
    // Array of characters in the secret word
    private char [] theWord;
    //Number of correct letters guessed
    private int correctWords;
    private char[] allLetters= new char[50];
    private int wordCount=0;
    
    /* 
    * pre : none
    *
    * post: Chooses a random word from wordLibrary and sets up blank dahes
    */

    //Constructor initializes a random word from the wordLibrary and sets up the blank dashes to match length of secret word
    public Hangman() {
        Random rand = new Random();
        //Sets a random integer from length of array to randomIndex to determine which word is used
        int randomIndex = rand.nextInt(wordLibrary.length);
        secretWord = wordLibrary[randomIndex];
        blankDashes = new char[secretWord.length()];
        theWord = secretWord.toCharArray();
        for (int i = 0; i < theWord.length; i++) {
            blankDashes[i] = '_';
        }
    }
    /* 
    * pre : none
    *
    * post: Prints all the blank dashes 
    */
    // Updates the string representation of the blank dashes for printing
    public void createBlankDashes(){
        spacesHolder = "";
        for(int i = 0; i < blankDashes.length; i++){
            spacesHolder += blankDashes[i] + " ";
        }
    }
    /* 
    * pre : 'letter' is a valid character input by the user.
    *       Throws an IllegalArgumentException if preconditions not met.
    *
    * post: Returns true if the letter has already been guessed, otherwise false.
    */
    // Checks if the player has guessed a letter twice
    public boolean lettersGuessedTwice(char letter) {
        boolean lol=false;
        for (int g=0; g<allLetters.length;g++) {
            if(letter==(allLetters[g]) ) {
                lol=true;
                return lol;
            }
            else{

            }
        }
        wordCount++;
        return lol;
    }
    /* 
    * pre : 'letter' is a valid character input by the user
    *
    * post: Stores all the letters guessed and increases number of words counted
    */
    //Array storing all the letters the user has guessed
    public void storedLetters(char letter){
        allLetters[wordCount]=letter;
        wordCount++;
    }
    
    /* 
    * pre : 'letter' is a valid character input by the user
    *
    * post: Returns true if the user input is only a letter
    */
    //Determines whether the user has inputted only a letter and not other symbols/numbers
    public boolean onlyChar(char letter){
        return Character.isLetter(letter); 
    }
    
    /* 
    * pre : 'input' is a valid string input by the user 
    *
    * post: Returns true if input by user is one character
    */
    //Determines whether the input added by the user is one character only
    public boolean oneChar(String input){
         if(input.length()!=1){
             return false;
         }else{
         return true;
    }
}

    /* 
    * pre : 'letter' is a valid character input by the user.
    *
    * post: Updates blankDashes if the letter is correct, or decrements attemptsLeft and stores the letter in lettersGuessed if incorrect.
            Returns true if the guess is correct.
    */
    // Updates the current guess and checks if the letter is correct
    public boolean updateCurrentGuess(char letter) {
        boolean correctWord = false;
        for(int i=0; i<secretWord.length(); i++){
            if(secretWord.charAt(i) == letter){
                blankDashes[i]=letter;
                correctWord=true;
                correctWords++;
   
            }
        }
        //Assigns wrong letters guessed by user to array to be printed if it is a character
        if(correctWord==false){
            if(onlyChar(letter)){
                lettersGuessed[counter]=letter;
                System.out.print("The letters you guessed wrong are: ");
                for(int z=0; z<lettersGuessed.length;z++){
                    System.out.print(lettersGuessed[z]);
                }
            }
                System.out.println("");
                counter++;
                attemptsLeft--;
        }
        return correctWord;
           
    }
    
    /* 
    * pre : none
    *
    * post: Returns true if attemptsLeft is 0, indicating the game is over.
    */
   // Checks if the game is over by running out of attempts
    public boolean isGameOver() {
        boolean finishedGame = false;
        if(attemptsLeft==0){
            finishedGame=true;
        }
    return finishedGame;
    }
    
    /* 
    * pre : none
    *
    * post: Returns true if all letters in the secret word have been guessed (i.e., no blank dashes remain).
    */
    // Checks if the player has won the game by guessing the entire word without running out of attempts
    public boolean wonGame(){
        boolean finishedGame=false;
        for(int l=0; l<blankDashes.length;l++)
        {
            if(blankDashes[l]=='_'){
                return finishedGame;
            }else{

            }
        }
        return finishedGame=true;
    }
    
    /* 
    * pre : none
    *
    * post: Returns the secret word
    */
    // Getter for the secret word
   public String getsecretWord(){
       return secretWord;
   }
   
   /* 
    * pre : none
    *
    * post: Returns the current state of the word with guessed letters and remaining blanks as a string.
    */
   // String representation of the current state of the word
   public String toString(){
        return spacesHolder;
    }
    
public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
       // Create a new Hangman game instance
       Hangman usergame= new Hangman();
       System.out.println("Welcome to Hangman");
       System.out.println();
        do {
            usergame.createBlankDashes();
            System.out.println("Current Board: "+ usergame);
            System.out.println("Attempts left: "+ usergame.attemptsLeft);
            System.out.print("Enter the letter you are going to guess: ");
            
           //Takes user input for the letter they are guessing
           String userInput = in.next();
           //Converts input to char in order to use methods
           char userLetter = userInput.charAt(0);
            
            //if luna wants case sensitive add this
           //userLetter= Character.toUpperCase(userLetter);
           
           System.out.println();
           
           //Check if the input is a valid single character and is not already guessed
           if(!usergame.oneChar(userInput)){
               System.out.println("Only put one word, try again");
               System.out.println();
           }
           else if(!usergame.onlyChar(userLetter)){
               System.out.println("This is not only a letter, try again");
               System.out.println();
           }
           //Check if character has been guessed before by user
           else if(usergame.lettersGuessedTwice(userLetter)){
            System.out.println("You guessed this letter");
            System.out.println();
           }
           //Updated user game board if guessed correct character
           else if(usergame.updateCurrentGuess(userLetter)){
            System.out.println("Correct!");
            System.out.println();
           }
           //User guessed incorrect charater
           else{
            System.out.println("Incorrect letter!");
            System.out.println();
           }
           usergame.storedLetters(userLetter);
        } 
        while (!usergame.isGameOver() && !usergame.wonGame());
        
        // Display the final result after the game ends
        if(usergame.wonGame()){
           System.out.println("Congratulations, you won! The word was in fact "+ usergame.getsecretWord());
       }else{
           System.out.println("Sorry, you lost! The word was "+usergame.getsecretWord());
            }
    }
}
