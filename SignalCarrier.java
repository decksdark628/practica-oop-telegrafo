public abstract class SignalCarrier implements TransmitsSignal{
    private Signal signal;
	private SignalCarrier nextCarrier;

    public abstract Result transmit(Signal s);

    public Signal getSignal() {
        return this.signal;
    }
    public void setSignal(Signal signal) {
        this.signal = signal;
    }
    public SignalCarrier getNextComp() {
        return this.nextCarrier;
    }
    public void setNextComp(SignalCarrier nextComp) {
        this.nextCarrier = nextComp;
    }
}