import java.util.*;

public class Q3_Analysis {

	public static ArrayList<String> Discussion_Board(String[] posts){

		Map<String,Integer> occurrencesOfWords = new HashMap<String,Integer>();
		Map<String, TreeSet<String>> map = new HashMap<String, TreeSet<String>>();
		TreeSet<String> allUsers = new TreeSet<>();
		TreeSet<String> allWords = new TreeSet<>();
		String wordsInSentence[];
		int totalWordsInSentence;
		String userName;
		ArrayList<String> mostUsed = new ArrayList<String>();


		//Loop through all the posts, to populate the Treeset with all the users, another Treeset with all the words,
		// and count the number of occurrences of each word and add it to the map.
		for (String sentence : posts){

			//Separate each word in the sentence
			wordsInSentence = separateWords(sentence);
			//Get the total number of words in the sentence
			totalWordsInSentence = wordsInSentence.length;
			//Get the user name of the one who posted, it's at index 0 since it's always the first word in the post
			userName = wordsInSentence[0];

			//Add the user in the treeset, it will not appear 2 times since there are no duplicates in a treeset
			allUsers.add(userName);

			Integer count;

			//Loop through all the words in the post, except the user since we already took care of it
			for(int i = 1; i < totalWordsInSentence; i++){

				//add the word in the treeset, again, no duplicates
				allWords.add(wordsInSentence[i]);

				//add the word with an empty treeset to the hashmap
				map.put(wordsInSentence[i], new TreeSet<String>());


				//Get the number of occurrences of the particular word in the sentence
				count = occurrencesOfWords.get(wordsInSentence[i]);

				//Check if the word does not exist in the map, if it doesn't, add it with a count of 1
				if(count == null) occurrencesOfWords.put(wordsInSentence[i], 1 );

				//Else, pre increment the count and add it with the word as key
				else occurrencesOfWords.put(wordsInSentence[i], ++count );
			}
		}


		//Loop through all the posts, this time to check which user said what word
		//Using another for loop since I had to populate the maps and treesets first
		for (String sentence : posts) {

			//Separate each word in the sentence
			wordsInSentence = separateWords(sentence);
			//Get the total number of words in the sentence
			totalWordsInSentence = wordsInSentence.length;
			//Get the user name of the one who posted, it's at index 0 since it's always the first word in the post
			userName = wordsInSentence[0];

			//Loop through all the words in the post, except the user since we already took care of it
			for(int i = 1; i < totalWordsInSentence; i++){

				//Add to the treeset of the map that this user said the word[i] in the sentence
				//Since we are adding the user in a treeset, then we won't have any duplicates in it
				map.get(wordsInSentence[i]).add(userName);
			}
		}

		//Get the total number of users
		int totalUsersInSystem = allUsers.size();

		//Loop through all the distinct words said by all users
		for(String word : allWords){

			//If the number of user who said each word is equal to the total number of users
			if(map.get(word).size() == totalUsersInSystem){
				//Then all the users said the particular word
				//Add it to an array
				mostUsed.add(word);
			}
		}

		//Sort the array using the occurrences of the words in the map
		mostUsed = orderArrayWithHash(mostUsed, occurrencesOfWords);


		return mostUsed;
	}


	/**
	 * Private method used to split every word in a string
	 *
	 * @param sentence - the string to split
	 * @return an array of String with each word separated
	 * @author Karl Rouhana
	 */
	private static String[] separateWords(String sentence){

		//If sentece is null or empty
		if(sentence == null || sentence.equals(""))

			//Return empty
			return new String[0];

		//Split every time there's a space
		String[] words = sentence.split(" ");

		//Return array of words seperated
		return words;
	}

	/**
	 * Private method to sort an array using a hashmap, used to sort by the number of occurrences of words
	 *
	 * @param array	- array to sort
	 * @param map - map used to sort
	 * @return the sorted array
	 */
	private static ArrayList<String> orderArrayWithHash(ArrayList<String> array, Map<String, Integer> map){

		int size = array.size();
		String word1, word2;
		int occurrenceOf1, occurrenceOf2;

		for(int i = 0; i < size; i++){
			for(int j = 0; j < size - 1; j++){

				word1 = array.get(j);
				word2 = array.get(j+1);
				occurrenceOf1 = map.get(word1);
				occurrenceOf2 = map.get(word2);

				//If the occurrence of the word that comes after the one with less occurrence, swap them
				if(occurrenceOf2 > occurrenceOf1){
					String temp = word2;
					array.set(j+1, word1);
					array.set(j, temp);
				}
			}
		}
		
		return array;
	}
}
