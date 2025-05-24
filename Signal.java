public class Signal {
    private static final int STRENGTH_THRESHOLD = 35;
    private String[] content;
    private int strength;

    public void decreaseStrength(int signalDegrad){
        if (strength - signalDegrad >= 0)
			strength -= signalDegrad;
		else
			strength = 0;
        checkStrength();
	}

    private void checkStrength(){
        if (strength < STRENGTH_THRESHOLD){
            content = null;
            System.out.println("Mensaje perdido");
        }   
    }

    public String[] getContent() {
        return this.content;
    }
    public void setContent(String[] content) {
        this.content = content;
    }
    public int getStrength() {
        return this.strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
}
