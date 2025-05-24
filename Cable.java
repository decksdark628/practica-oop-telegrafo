public class Cable extends SignalCarrier{
	private double length;
	private int signalDegrad;

    public Result transmit(){
        Signal s = super.getSignal();
        Result r;
        
        if (s == null)
            r = new Result(false, "No se encontro ninguna señal");
        else{
            degradeSignal();
            super.getNextComp().setSignal(s);
            r = new Result(true, "Señal enviada al siguiente componente");
		}
        return r;
    }

    private void degradeSignal(){
		for (int i = 1; i<=length; i++){
			super.getSignal().decreaseStrength(signalDegrad);
		}
	}
}
