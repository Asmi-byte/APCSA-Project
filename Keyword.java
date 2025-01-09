import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;

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

        FileReader input = new FileReader("filler.txt");
        String stuff = input.getEncoding();
        String[] stopWords = stuff.split("\n");
        for (String word: stopWords)
            {
                for(int i = 0; i < keywords.size(); i++)
                    {
                        String current = keywords.get(i);
                        if (word.equals(current))
                        {
                            keywords.remove(i);
                            i--;
                        }
                    }
            }
        }
      catch(IOException e)
        {
           System.out.println("Error closing FileReader: " + e.getMessage());
       }
    }

    public String themeFinder() //Use themefinder to find the most said word 
    {
        this.makeKeywords();
        this.removeFiller();    
        this.makeWordBasic();
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
			else if(input[i].indexOf("resil")!=-1)
				input[i] = "resilient";
			else if(input[i].indexOf("discipl")!=-1)
				input[i] = "disciplined";
			else if(input[i].indexOf("kind")!=-1)
				input[i] = "kind";
			else if(input[i].indexOf("nic")!=-1)
				input[i] = "nice";
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
		if(userInput.equals("kind"))
		{
			return "You said " + userInput + " the most out of any important word! Just like you, Audrey Hepburn said 'For beautiful eyes, look for the good in others;for beautiful lips, speak only words of kindness; and for poise, walk with the knowledge that you are never alone.'";
		}
		return "You are a unique individual and unlike any celebrity in our database!";
	}
	
    public List<String> getKeywords()  //raw list of all words
    {
        return keywords;
    }
}
