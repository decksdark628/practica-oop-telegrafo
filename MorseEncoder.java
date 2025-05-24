public class MorseEncoder{
	private static String[] morse;

    public String[] encode(String s){
		String msg = s.toUpperCase();
		String[] codedMsg = new String[msg.length()];
        int index;

        if (morse == null)
            createReverseMorseDict();

		for (int i = 0; i<s.length(); i++){
            if (msg.charAt(i)-'A' >= 0 && msg.charAt(i)-'A' <= 25 )
                index = msg.charAt(i)-'A';
            else if (msg.charAt(i) == ' ')
                index = 26;
            else
                index = 27;

            codedMsg[i] = morse[index];    
        }
        
		return codedMsg;
	}

    private static void createReverseMorseDict(){
		morse = new String[]{
			".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
			".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", 
			"...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "/", "?"
		};
    }    
}
