public class Relay extends SignalCarrier implements TurnsOnOff{
    private boolean status;

    public Result turnOn(){
        Result r;
        if (!status){
            status = true;
            r = new Result(true, "\tSe ha encendido el Repetidor");
        }
        else
            r = new Result(false, "\tEl Repetidor ya se encuentra Encendido");
        System.out.println(r.getMessage());
        return r;
    }

    public Result turnOff(){
        Result r;
        if (status){
            status = false;
            r = new Result(true, "\tSe ha apagado el Repetidor");
        }
        else
            r = new Result(false, "\tEl Repetidor ya se encuentra apagado");
        System.out.println(r.getMessage());
        return r;
    }

    public Result transmit(){
        Signal s = super.getSignal();
        Result r;

        if (s == null)
            r = new Result(false, "Repetirdor: No se encontro ninguna señal");
        else{
            amplifySignal();
            if (super.getNextCarrier() != null){
                super.getNextCarrier().setSignal(s);
                r = new Result(true, "Repetidor: Señal enviada al siguiente componente");
            }
            else
                r = new Result(true, "Repetidor: Señal transmitida hasta el ultimo componente");
		}
        System.out.println("\t" + r.getMessage());
        System.out.println("\t\tSeñal actual: " + s.getStrength());
        return r;
    }

    public boolean amplifySignal(){
        boolean conf;
        Signal s = super.getSignal();

        if (s == null)
            conf = false;
        else{
            if (super.getSignal().getStrength() != 0){
			    super.getSignal().setStrength(100);
			    System.out.println("\tRepetidor: Se amplifico la señal");
			    conf = true;
            }
            else
                System.out.println("\tRepetidor: No se pudo amplificar la señal. La señal es '0'");
                conf = false;
		}
        return conf;
    }
    public boolean isStatus() {
        return this.status;
    }
    public boolean getStatus() {
        return this.status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Repetidor {" +
            " Encendido: " + isStatus() + "}";
    }
}
