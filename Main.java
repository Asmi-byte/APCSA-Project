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
        System.out.println("Hi! Welcome to Celebrity Check. Answer my questions I and will match you up with a celebrity that matches your traits. \nPlease enter your name to start the questions: ");
        name = input.nextLine();
        
        //runs until user doesn't want questions or the program runs out of questions
        while(wantQuestions && count < 4){
			
			String answer = "";
			boolean reused = true;
			boolean properInput = false;
			String stillHere = "";
			
			String[] questions = {
			"What traits would you use to describe a \"sucessful\" person? ",
			"What traits could you describe yourself with? ",
			"What would you do if you knew you couldn’t fail? ",
			"Describe traits that makes a good friend. ",
			"How would you describe your role model? ",
			"What type of person motivates you to do better? ",
			"What traits makes you unique? ",
			"What do you think is the most important quality for a person to have in life? ",
			"What are some traits you wish you had? ",
			"How would you describe the people around you? ",
			"What types of people do you think your morals are based on? ",
			"How would your friends descirbe you? ",
			"What would you change about your personality? ",
			"How are you feeling right now? "};
			
			//Question 1
			
			System.out.println("Let's start with question 1:");
			
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
			
			//Question 2 (same as question 1)
			
			System.out.println("Moving on to question 2:");
			
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
			
			//Question 3 (same as question 1)

			System.out.println("Last question " + name + ":");
			
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
			//sets answer to lowercase to compare with texts
			answer = answer.toLowerCase();
			
			//Keyword object 
			
			Keyword runner = new Keyword(answer);
			runner.themeFinder();
			System.out.println(runner.compareToCelebrity(runner.themeFinder()));
			
			//Asks if user wants to continue will stop asking questions if user says no willl continue is yes until 4 sets of questions have been asked
			
			while (properInput == false){
				System.out.println("Would you like to be asked more questions(Y/N)? ");
				stillHere = input.nextLine();
				if(stillHere.charAt(0) == 'Y' || stillHere.charAt(0) == 'y' ){
					wantQuestions = true;
					properInput = true;
					System.out.println("Awesome! Let's keep comparing you to a celebrity " + name + ".");
				}
				else if(stillHere.charAt(0) == 'N' || stillHere.charAt(0) == 'n') {
					wantQuestions = false;
					properInput = true;
					System.out.println("Okay bye " + name + "!");
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
