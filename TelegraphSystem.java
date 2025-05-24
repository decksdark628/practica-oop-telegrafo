public class TelegraphSystem {
    private Emitter emt;
    private SignalCarrier[] sigCar;
    private Receiver rec;

    public TelegraphSystem(Emitter emt, SignalCarrier[] sigCar, Receiver rec) {
        this.emt = emt;
        this.sigCar = sigCar;
        this.rec = rec;
    }
    public TelegraphSystem(SignalCarrier[] sigCar) {
        emt = new Emitter();
        this.sigCar = sigCar;
        rec = new Receiver();
    }

    public void run(){
        if (!validSequence())
            System.out.println("El sistema esta incompleto");
        else{
            initializeSystem();
            emt.turnOn();
            emt.transmit();
            for (int i = 0; i<sigCar.length; i++){
                sigCar[i].transmit();
            }
            rec.receiveSignal();
            rec.displayMessage();
        }
    }

    private boolean validSequence(){
		boolean conf = false;
        if (sigCar != null){
            conf = true;
            for (int i = 0; i<sigCar.length && conf; i++){
                if (sigCar[i] == null)
                    conf = false;
            }
        }
		return conf;
	}

    private void initializeSystem(){
        int n = sigCar.length-1;
        emt.setNextComp(sigCar[0]);
        rec.setPrevCarrier(sigCar[n]);
        for (int i = 0; i<sigCar.length-1; i++){
            sigCar[i].setNextComp(sigCar[i+1]);
        }
    }

    public Emitter getEmt() {
        return this.emt;
    }
    public void setEmt(Emitter emt) {
        this.emt = emt;
    }
    public SignalCarrier[] getSigCar() {
        return this.sigCar;
    }
    public void setSigCar(SignalCarrier[] sigCar) {
        this.sigCar = sigCar;
    }
    public Receiver getRec() {
        return this.rec;
    }
    public void setRec(Receiver rec) {
        this.rec = rec;
    }
}
