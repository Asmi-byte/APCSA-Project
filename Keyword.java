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

	public String makeWordBasic(String input)
	{
		
		if(input.indexOf("ambit")!=-1)
			return "ambitious";
		else if(input.indexOf("creat")!=-1)
			return "creative";
		else if(input.indexOf("passion")!=-1)
			return "compassionate";
		else if(input.indexOf("conscien")!=-1)
			return "conscientious";
		else if(input.indexOf("courag")!=-1)
			return "courageous";
		else if(input.indexOf("flex")!=-1)
			return "flexible";
		else if(input.indexOf("hones")!=-1)
			return "honest";
		else if(input.indexOf("humb")!=-1)
			return "humble";
		else if(input.indexOf("honor")!=-1 || input.indexOf("integ")!=-1)
			return "honorable ";
		else if(input.indexOf("loya")!=-1)
			return "loyal";
		else if(input.indexOf("patien")!=-1)
			return "patient";
		else if(input.indexOf("persis")!=-1 || input.indexOf("perserver")!=-1)
			return "persistent";
		else if(input.indexOf("resil")!=-1)
			return "resilient";
		else if(input.indexOf("discipl")!=-1)
			return "disciplined";
		return input;
	}
	
    public List<String> getKeywords()  //raw list of all words
    {
        return keywords;
    }
}
