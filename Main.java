/**
*This is the main file that we will be using to run the program
* it takes in input using a scanner object and gives a random question to answer
*@author Maia Katragadda & Asmita Bag & Grant Cabay & Tristian Mettee
*/


import java.util.*;


public class Main{
	public static void main (String args[]){
	
        ArrayList<Integer> usedNum = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        boolean wantQuestions = true;
        int count = 0;
        String name = "";
        
        //Intro prompts
        System.out.println("Hi welcome to Celeb Check, Answer our questions and will match you up with a celebrity that matches your traits. Please enter your name to start the questions: ");
        name = input.nextLine();
        
        //runs until user doesn't want questions or the program runs out of questions
        while(wantQuestions && count < 4){
			
			String answer = "";
			boolean reused = true;
			boolean properInput = false;
			String stillHere = "";
			
			String[] questions = {"What are you passionate about? ",
			"How would you descirbe a \"sucessful\" person? ",
			"How would you descibe yourself? ",
			"What would you do if you knew you couldn’t fail? ",
			"Describe traits that makes a good friend. ",
			"How would you descirbe your role model? ",
			"What motivates you? ",
			"What makes you unique? ",
			"What are some of your interests? ",
			"What do you think is the most important quality for a person to have in life? ",
			"What are traits do you wish you had? ",
			"How would you descirbe the people around you? ",
			"What do you think your morals are based on? ",
			"How would your friends descirbe you? "};
			
			//Question 1
			
			//creates a random number with the range of the length of the list
			int randomNum = (int)((Math.random()) * (questions.length));
			
			//if the random number has been used it will select another random number
			while(reused){
				reused = false;
				for(int i = 0; i < usedNum.size() ; i++){
					if (randomNum == usedNum.get(i)){
						randomNum = (int)((Math.random()) * (questions.length));
						reused = true;
					}
				}
			}
			
			//prints question stores answer in string, adds question index into used index array
			System.out.println(questions[randomNum]);
			answer += input.nextLine();
			usedNum.add(randomNum);	
			
			//Question 2
			
			reused = true;
			randomNum = (int)((Math.random()) * (questions.length));
		
			while(reused){
				reused = false;
				for(int i = 0; i < usedNum.size() ; i++){
					if (randomNum == usedNum.get(i)){
						randomNum = (int)((Math.random()) * (questions.length));
						reused = true;
					}
				}
			}
		
			System.out.println(questions[randomNum]);
			answer += input.nextLine();
			usedNum.add(randomNum);
			
			//Question 3
			
			reused = true;
			randomNum = (int)((Math.random()) * (questions.length));
		
			while(reused){
				reused = false;
				for(int i = 0; i < usedNum.size() ; i++){
					if (randomNum == usedNum.get(i)){
						randomNum = (int)((Math.random()) * (questions.length));
						reused = true;
					}
				}
			}
		
			System.out.println(questions[randomNum]);
			answer += input.nextLine();
			usedNum.add(randomNum);
			answer = answer.toLowerCase();
			//Keyword object 
			
			Keyword runner = new Keyword(answer);
			runner.themeFinder();
			System.out.println(runner.compareToCelebrity(runner.themeFinder()));
			
			//Asks if user wants to continue
			
			while (properInput == false){
				System.out.println("Would you like to be asked more questions(Y/N)? ");
				stillHere = input.nextLine();
				if(stillHere.charAt(0) == 'Y' || stillHere.charAt(0) == 'y' ){
					wantQuestions = true;
					properInput = true;
				}
				else if(stillHere.charAt(0) == 'N' || stillHere.charAt(0) == 'n') {
					wantQuestions = false;
					properInput = true;
				}
			}
			
			if (count >= 4){
				System.out.println("You're too chatty. There are no more questions to be asked.");
				wantQuestions = false;
			}
			
			count++;
			

		}
		
	}
}
