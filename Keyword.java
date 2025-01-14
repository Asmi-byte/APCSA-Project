import java.util.*;
import java.io.*;
public class Keyword {
    private String[] userWords;
    private List<String> keywords;

    public Keyword(String input) 
  {
        this.userWords = input.split(" ");



    }

    public void makeKeywords()
    {
        keywords = new ArrayList<>();
    
        for (int index = 0; index < userWords.length; index++) {
          String currentLine = userWords[index];
          int space = currentLine.indexOf(" ");

          while (space != -1) {
            String currentWord = currentLine.substring(0, space);
            keywords.add(currentWord);
            currentLine = currentLine.substring(space + 1);
            space = currentLine.indexOf(" ");
          }

          keywords.add(currentLine);
        }
    }

public void removeFiller()
{
    try
    {
		File file = new File("filler.txt");
		Scanner moreInput = new Scanner(file);
		String[] stopWords = new String[22]; //size is the number of adjectives in filler.txt
		int counter = 0;
		boolean removeIndex = true;
		while(moreInput.hasNextLine())
		{
			stopWords[counter] = moreInput.nextLine();		
			counter++;
		}		
		
		for(int i = 0; i< keywords.size(); i++)
		{
			String word = keywords.get(i);
			for(int j = 0; j < stopWords.length; j++)
			{
				String current = stopWords[j];
				if (word.equals(current))
				{
					
					removeIndex = false;
				}
			}
			if(removeIndex)
			{
				keywords.remove(i);
				i--;
			}
			removeIndex = true;
		}
		moreInput.close();
      }
      catch(Exception e)
      {
		 System.out.println("Error closing Scanner: " + e.getMessage());
      }
}

    public String themeFinder() //Use themefinder to find the most said word 
    {
        this.makeKeywords();
        this.makeWordBasic();
        this.removeFiller();           
        String theme = "";
        int wordcount = 0;
        for (String word : keywords) {
            int count = 0;
            for (String otherWord : keywords) {
                if (word.equals(otherWord)) {
                    count++;
                }
            }
            if (count > wordcount) {
                wordcount = count;
                theme = word;
            }
        }
        return theme;
    }

	public void makeWordBasic()
	{
		String[] input = new String[keywords.size()];
		for(int i = 0; i <keywords.size(); i++)
		{
			input[i] = keywords.get(i);
		}
		for(int i = 0; i < keywords.size(); i++)
		{		
			if(input[i].indexOf("ambit")!=-1)
				input[i] = "ambitious";
			else if(input[i].indexOf("creat")!=-1)
				input[i] = "creative";
			else if(input[i].indexOf("passion")!=-1)
				input[i] = "compassionate";
			else if(input[i].indexOf("conscien")!=-1)
				input[i] = "conscientious";
			else if(input[i].indexOf("courag")!=-1)
				input[i] = "courageous";
			else if(input[i].indexOf("flex")!=-1)
				input[i] = "flexible";
			else if(input[i].indexOf("hones")!=-1)
				input[i] = "honest";
			else if(input[i].indexOf("humb")!=-1)
				input[i] = "humble";
			else if(input[i].indexOf("honor")!=-1)
				input[i] = "honorable ";
			else if(input[i].indexOf("loya")!=-1)
				input[i] = "loyal";
			else if(input[i].indexOf("patien")!=-1)
				input[i] = "patient";
			else if(input[i].indexOf("persis")!=-1)
				input[i] = "persistent";
			else if(input[i].indexOf("perse")!=-1)
				input[i] = "persistent";	
			else if(input[i].indexOf("resil")!=-1)
				input[i] = "resilient";
			else if(input[i].indexOf("discipl")!=-1)
				input[i] = "disciplined";
			else if(input[i].indexOf("kind")!=-1)
				input[i] = "kind";
			else if(input[i].indexOf("work")!=-1)
				input[i] = "hardworker";
			else if(input[i].indexOf("happ")!=-1)
				input[i] = "happy";
			else if(input[i].indexOf("intel")!=-1)
				input[i] = "intelligent";
			else if(input[i].indexOf("smart")!=-1)
				input[i] = "intelligent";
			else if(input[i].indexOf("lov")!=-1)
				input[i] = "loving";
			else if(input[i].indexOf("humor")!=-1)
				input[i] = "humorous";	
			else if(input[i].indexOf("funn")!=-1)
				input[i] = "humorous";	
			else if(input[i].indexOf("terr")!=-1)
				input[i] = "mean";
			else if(input[i].indexOf("horr")!=-1)
				input[i] = "mean";
			else if(input[i].indexOf("mean")!=-1)
				input[i] = "mean";
			else
			{
				input[i] = input[i];
			}
		}
		for(int i = 0; i < keywords.size(); i++)
		{
			keywords.set(i,input[i]);
		}
		
	}
	
	public String compareToCelebrity(String userInput)
	{
		if(userInput.equals("ambitious"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Elvis Presley said 'Ambition is a dream with a v8 engine.'";
		}
		else if(userInput.equals("creative"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Pablo Picasso said 'Every child is an artist; the problem is staying an artist when you grow up'";
		}
		else if(userInput.equals("compassionate"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Maya Angelou said 'My mission in life is not merely to survive, but to thrive; and to do so with some passion, some compassion, some humor, and some style'";
		}
		else if(userInput.equals("conscientious"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Kara Walker said ' To be a truly conscientious artist, you have to look at what's not working and challenge it. You riff on things'";
		}
		else if(userInput.equals("courageous"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Ernest Hemingway said 'Courage is grace under pressure'";
		}
		else if(userInput.equals("disciplined"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Jake Gylenhall said 'I've learned over the years that freedom is just the other side of discipline'";
		}
		else if(userInput.equals("flexible"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Luke Hemsworth  said 'You have to learn to be fluid and go where you're needed, when you're needed. You've gotta be flexible. I think that's what acting is'";
		}
		else if(userInput.equals("hardworker"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Henry Ford said 'Thinking is the hardest work there is, which is the probable reason why so few engage in it.'";
		}
		else if(userInput.equals("happy"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Drew Barrymore said 'Happiness is the best makeup.'";
		}
		else if(userInput.equals("honest"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Frank Ocean said 'There's just some magic in truth and honesty and openness.'";
		}
		else if(userInput.equals("honorable"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Socrates said 'The greatest way to live with honor in this world is to be what we pretend to be.'";
		}
		else if(userInput.equals("humble"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Dwayne Johnson said 'I'm always asked, 'What's the secret to success?' But there are no secrets. Be humble. Be hungry. And always be the hardest worker in the room.'";
		}
		else if(userInput.equals("humorous"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Michael J. Fox said 'I think the scariest person in the world is the person with no sense of humor.'";
		}
		else if(userInput.equals("intelligent"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Ian McEwan said 'True intellegence requires fabulous imagination.'";
		}
		else if(userInput.equals("joyful"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Oprah Winfrey said 'I define joy as a sustained sense of well-being and internal peace — a connection to what matters.'";
		}
		else if(userInput.equals("kind"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Audrey Hepburn said 'For beautiful eyes, look for the good in others;for beautiful lips, speak only words of kindness; and for poise, walk with the knowledge that you are never alone'";
		}
		else if(userInput.equals("loving"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Frank Sinatra said 'A simple 'I love you' means more than money'";
		}
		else if(userInput.equals("loyal"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Josiah Royce said 'Unless you can find some sort of loyalty, you cannot find unity and peace in your active living'";
		}
		else if(userInput.equals("mean"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Maia Katragadda said 'Eliminate the children'";
		}
		else if(userInput.equals("nice"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Clare Pooley said 'In a world where you can be anything, be kind.'";
		}
		else if(userInput.equals("patient"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Benjamin Franklin said 'He that can have patience can have what he will.'";
		}
		else if(userInput.equals("persistent"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Thomas Edison said 'Many of life’s failures are people who did not realize how close they were to success when they gave up.'";
		}
		return "You are a unique individual and unlike any celebrity in our database!";
	}
	
    public List<String> getKeywords()  //raw list of all words
    {
        return keywords;
    }
}
