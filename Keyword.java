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

    public String themeFinder()
    {
        this.makeKeywords();
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


    public List<String> getKeywords() 
    {
        return keywords;
    }
}
