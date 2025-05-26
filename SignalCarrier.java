public abstract class SignalCarrier implements TransmitsSignal{
    private Signal signal;
	private SignalCarrier nextCarrier;

    public abstract Result transmit();

    public Signal getSignal() {
        return this.signal;
    }
    public void setSignal(Signal signal) {
        this.signal = signal;
    }
    public SignalCarrier getNextCarrier() {
        return this.nextCarrier;
    }
    public void setNextCarrier(SignalCarrier nextCarrier) {
        this.nextCarrier = nextCarrier;
    }

    @Override
    public String toString() {
        return "{" +
            " signal='" + getSignal() + "'" +
            ", nextCarrier='" + getNextCarrier() + "'" +
            "}";
    }
}