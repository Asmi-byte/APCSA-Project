import java.util.*;


public class Main{
	public static void main (String args[]){
	
        ArrayList<Integer> usedNum = new ArrayList<Integer>();
        
        String answer = "";
        Scanner input = new Scanner(System.in);
        
	
		boolean reused = true;
		
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
		
		
		int randomNum = (int)((Math.random()) * (questions.length));
		
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
		




	/**
	 * proper reusing format
	 * 
	 
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
		
		
		System.out.println(answer);	
		
		**/
		
		
		//used after all questions are asked
		
		Keyword runner = new Keyword(answer);

		
		
	}
}
	
