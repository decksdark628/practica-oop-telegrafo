public class Signal {
    private static final int STRENGTH_THRESHOLD = 35;
    private String[] content;
    private int strength;

    public Signal(String[] content) {
        this.content = content;
        strength = 100;
    }

    public boolean decreaseStrength(int signalDegrad){
        boolean conf;
        if (strength - signalDegrad <= strength){
            if (strength - signalDegrad < 0)
                strength = 0;
            else
                strength = strength - signalDegrad;
            conf = true;
        }
        else 
            conf = false;

        checkStrength();
        return conf;
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
