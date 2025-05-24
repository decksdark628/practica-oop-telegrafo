import java.util.HashMap;

public class MorseDecoder{
	private HashMap<String, Character> morseDict = new HashMap<>();

    public String decode(String[] morseMsg){
		if (morseDict == null)
			createMorseDict();
		String decodedMsg = "";

		for (int i = 0; i<morseMsg.length; i++){
            Character c = morseDict.get(morseMsg[i]);
            if (c != null)
			    decodedMsg += morseDict.get(morseMsg[i]);
		}
		return decodedMsg;
	}

	private void createMorseDict(){
		morseDict.put(".-", 'A');
		morseDict.put("-...", 'B');
		morseDict.put("-.-.", 'C');
		morseDict.put("-..", 'D');
		morseDict.put(".", 'E');
		morseDict.put("..-.", 'F');
		morseDict.put("--.", 'G');
		morseDict.put("....", 'H');
		morseDict.put("..", 'I');
		morseDict.put(".---", 'J');
		morseDict.put("-.-", 'K');
		morseDict.put(".-..", 'L');
		morseDict.put("--", 'M');
		morseDict.put("-.", 'N');
		morseDict.put("---", 'O');
		morseDict.put(".--.", 'P');
		morseDict.put("--.-", 'Q');
		morseDict.put(".-.", 'R');
		morseDict.put("...", 'S');
		morseDict.put("-", 'T');
		morseDict.put("..-", 'U');
		morseDict.put("...-", 'V');
		morseDict.put(".--", 'W');
		morseDict.put("-..-", 'X');
		morseDict.put("-.--", 'Y');
		morseDict.put("--..", 'Z');
		morseDict.put("/", ' ');
	}
}
