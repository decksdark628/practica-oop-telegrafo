public abstract class SignalCarrier implements TransmitsSignal{
    private Signal signal;
	private SignalCarrier nextComp;

    public abstract Result transmit(Signal s);

    public Signal getSignal() {
        return this.signal;
    }
    public void setSignal(Signal signal) {
        this.signal = signal;
    }
    public SignalCarrier getNextComp() {
        return this.nextComp;
    }
    public void setNextComp(SignalCarrier nextComp) {
        this.nextComp = nextComp;
    }
}