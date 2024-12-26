import java.io.*;
import java.io.File;
import java.util.*;
public class SpellChecker implements SpellCheckerInterface{
	private Set<String>dictionary = new HashSet<>();
	public SpellChecker(String filename){
		File dictFile = new File(filename);
		try{
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String currentLine = reader.readLine();
			while(currentLine!=null){
				String linePunctuationRemoved = currentLine.replaceAll("[^a-zA-Z]","").toLowerCase();
				String [] wordsOnLine = linePunctuationRemoved.split("\\s+");
				for(String eachWord : wordsOnLine){
					dictionary.add(eachWord);
				}
				currentLine = reader.readLine();
			}
		}
		catch(Exception excep){
			excep.printStackTrace();
		}
	}
	public List<String> getIncorrectWords(String filename){
		File inputFile = new File(filename);
		List<String> badWords = new ArrayList<>();
		try{
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String currentLine = reader.readLine();
			while(currentLine!=null){
				if(!currentLine.equals("")){
					String[] wordsOnLine = currentLine.split("\\s+");
					for(String curWord : wordsOnLine){
						String wordPunctuationRemoved = curWord.replaceAll("[^a-zA-Z]","").toLowerCase();
						if(false == dictionary.contains(wordPunctuationRemoved)){
							badWords.add(wordPunctuationRemoved);
						}
					}
				}
				currentLine = reader.readLine();
			}
		} 
		catch(Exception excep){
			excep.printStackTrace();
		}
		return badWords;
	}
	public Set<String> getSuggestions(String word){
		Set<String> suggestionSet = new HashSet<>();
		String potentialWord = "";
		for(int i = 0; i<word.length();i++){
			potentialWord = word.toLowerCase().substring(0,i)+
			word.toLowerCase().substring(i+1,word.length());
			if(dictionary.contains(potentialWord)){
				suggestionSet.add(potentialWord);
			}
		}
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for(int i = 0; i<word.length();i++){
			for(char charac : alphabet){
				potentialWord = word.toLowerCase().substring(0,i) + charac +
				word.toLowerCase().substring(i,word.length());
				if(dictionary.contains(potentialWord)){
					suggestionSet.add(potentialWord);
				}
				if(i==word.length()-1){
					potentialWord = word +charac;
					if(dictionary.contains(potentialWord)){
						suggestionSet.add(potentialWord);
					}
				}
			}
		}
		for(int i = 1; i<word.length();i++){
			if(i!=word.length()-1){
				potentialWord = word.toLowerCase().substring(0,i-1) +word.toLowerCase().substring(i,i+1) + word.toLowerCase().substring(i-1,i) + word.toLowerCase().substring(i+1,word.length());
			}
			else{
				potentialWord = word.toLowerCase().substring(0,i-1) +word.toLowerCase().substring(i,i+1) + word.toLowerCase().substring(i-1,i);
			}
			if(dictionary.contains(potentialWord)){
				suggestionSet.add(potentialWord);
			}
		}
		return suggestionSet;
	}
}