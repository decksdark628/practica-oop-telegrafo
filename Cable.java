public class Cable extends SignalCarrier{
	private double length;
	private int signalDegrad;

    public Cable(double length, int signalDegrad) {
        this.length = length;
        this.signalDegrad = signalDegrad;
    }

    public Result transmit(){
        Signal s = super.getSignal();
        Result r;
        
        if (s == null)
            r = new Result(false, "Cable: No se encontro ninguna señal");
        else{
            degradeSignal();
            if (super.getNextCarrier() != null){
                super.getNextCarrier().setSignal(s);
                r = new Result(true, "Cable: Señal enviada al siguiente componente");
            }
            else
                r = new Result(true, "Cable: Señal transmitida hasta el ultimo componente");
		}
        System.out.println("\t" + r.getMessage());
        System.out.println("\t\tSeñal actual: " + s.getStrength());
        return r;
    }

    private void degradeSignal(){
        Signal s = super.getSignal();
        boolean stop = false;
        for (int i = 1; i<=length && !stop; i++){
			if (!s.decreaseStrength(signalDegrad) || s.getStrength() <= 0)
                stop = true;
		}
	}
    
    public double getLength() {
        return this.length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public int getSignalDegrad() {
        return this.signalDegrad;
    }
    public void setSignalDegrad(int signalDegrad) {
        this.signalDegrad = signalDegrad;
    }

    @Override
    public String toString() {
        return "Cable { " +
            "Longitud: " + getLength() + " KM" +
            ", Degracion de señal: " + getSignalDegrad() + "%" +
            " }";
    }
}
