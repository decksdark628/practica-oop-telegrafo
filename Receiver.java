public class Receiver{
    private SignalCarrier prevCarrier;
    private String message;

    public Result receiveSignal(){
        Result r;
        Signal morseSignal = prevCarrier.getSignal();
        if (morseSignal == null)
            r = new Result(false, "No se recibio una señal");
        else{
            MorseDecoder mDec = new MorseDecoder();
			message = mDec.decode(morseSignal.getContent());
            r = new Result(true, "Señal decodificada correctamente");
        }
        
        System.out.println(r.getMessage());
        return r;
    }
    
	public void displayMessage(){
		if (message != null) 
			System.out.println("Mensaje: \n" + message);
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
}