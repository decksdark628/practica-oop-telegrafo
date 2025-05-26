public class Receiver{
    private SignalCarrier prevCarrier;
    private String message;

    public Result receiveSignal(){
        Result r;
        Signal morseSignal = prevCarrier.getSignal();
        if (morseSignal == null)
            r = new Result(false, "Receptor: No se recibio una señal");
        else{
            String[] content = morseSignal.getContent();
            if (content == null)
                r = new Result(false, "\tEmisor: No se encontro el mensaje");
            else{
                MorseDecoder mDec = new MorseDecoder();
			    message = mDec.decode(morseSignal.getContent());
                r = new Result(true, "Receptor: Señal decodificada correctamente");
            }            
        }
        
        System.out.println("\t" + r.getMessage());
        return r;
    }
    
	public void displayMessage(){
		if (message != null) 
			System.out.println("Mensaje: " + message);
		else
			System.out.println("Error. No se pudo leer el mensaje");
	}

    public SignalCarrier getPrevCarrier() {
        return this.prevCarrier;
    }
    public void setPrevCarrier(SignalCarrier prevCarrier) {
        this.prevCarrier = prevCarrier;
    }
    public String getMessage() {
        return this.message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Componente anterior: " + getPrevCarrier() +
            ", Mensaje: " + getMessage();
    }
}