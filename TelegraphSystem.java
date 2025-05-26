public class TelegraphSystem {
    private Emitter emitter;
    private SignalCarrier[] signCarriers;
    private Receiver receiver;

    public TelegraphSystem(Emitter emt, SignalCarrier[] sigCar, Receiver rec) {
        this.emitter = emt;
        this.signCarriers = sigCar;
        this.receiver = rec;
    }
    public TelegraphSystem(SignalCarrier[] sigCar) {
        emitter = new Emitter();
        this.signCarriers = sigCar;
        receiver = new Receiver();
    }

    public void run(){
        if (!validSequence())
            System.out.println("\tError: El sistema esta incompleto");
        else{
            System.out.println("\nConectando componentes...");
            connectSystem();
            System.out.println("El sistema se ha conectado correctamente");

            System.out.println("\nInicializando componentes...");
            initializeSystem();
            System.out.println("\nComponentes del sistema:" + this.toString());

            System.out.println("\nEjecutando telegrafo...");
            emitter.transmit();
            for (int i = 0; i<signCarriers.length; i++){
                signCarriers[i].transmit();
            }
            receiver.receiveSignal();
            receiver.displayMessage();
        }
    }

    private boolean validSequence(){
		boolean conf = false;
        if (signCarriers != null){
            conf = true;
            for (int i = 0; i<signCarriers.length && conf; i++){
                if (signCarriers[i] == null)
                    conf = false;
            }
        }
		return conf;
	}

    private void connectSystem(){
        int n = signCarriers.length-1;
        emitter.setNextComp(signCarriers[0]);
        receiver.setPrevCarrier(signCarriers[n]);
        for (int i = 0; i<signCarriers.length-1; i++){
            signCarriers[i].setNextCarrier(signCarriers[i+1]);
        }
    }

    private void initializeSystem(){
        emitter.turnOn();
        for (int i = 0; i<signCarriers.length; i++){
            if (signCarriers[i] instanceof TurnsOnOff){
                TurnsOnOff turns = ((TurnsOnOff)signCarriers[i]);
                turns.turnOn();
            }
        }
    }

    public Emitter getEmitter() {
        return this.emitter;
    }
    public void setEmitter(Emitter emt) {
        this.emitter = emt;
    }
    public SignalCarrier[] getSignCarriers() {
        return this.signCarriers;
    }
    public void setSignCarriers(SignalCarrier[] sigCar) {
        this.signCarriers = sigCar;
    }
    public Receiver getReceiver() {
        return this.receiver;
    }
    public void setReceiver(Receiver rec) {
        this.receiver = rec;
    }

    @Override
    public String toString() {
        String temp = "\n> Emisor:\n\t" + emitter.toString()+
            "\n> Portadores de señal";
        for (int i = 0; i<signCarriers.length; i++){
                temp += "\n\t " + signCarriers[i];
        }
        temp += "\n> Receptor:\n\t" + getReceiver();
        return temp;
    }
}
