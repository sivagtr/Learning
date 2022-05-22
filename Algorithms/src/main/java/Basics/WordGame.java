package Basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordGame {

	public static void main(String[] args) {
		WordGame wordGame = new WordGame();
		wordGame.solve();
	}

//	H   I  V  E A T D V
//	Input   :  M V  R  T A V I V
	private void solve() {
		String secret = "stevi";
		String input = "";
		char[] ans = new char[input.length()];

		Map<Character, List<Integer>> secretMap = new HashMap<>();
		for(int i = 0; i<secret.length(); i++){
			char c = secret.charAt(i);
			List<Integer> valuesList = secretMap.get(c);
			if(valuesList == null){
				valuesList = new ArrayList<>();
			}
			valuesList.add(i);
			secretMap.put(c, valuesList);
		}
		System.out.println(secretMap);
		for(int i = 0; i<input.length(); i++){
			if(secret.charAt(i) == input.charAt(i)){
				ans[i] = 'G';
				secretMap.get(secret.charAt(i)).remove(new Integer(i));
			}
		}
		System.out.println(secretMap);
		for(int i = 0; i<input.length(); i++){
			if(ans[i] == 'G') continue;
			List<Integer> valuesList = secretMap.get(input.charAt(i));
			if(valuesList != null && !valuesList.isEmpty()){
				ans[i] = 'Y';
				valuesList.remove(0);
			}else{
				ans[i] = 'R';
			}
		}
		for(char c : ans){
			System.out.print(c+  " ");
		}
	}
}
