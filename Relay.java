public class Relay extends SignalCarrier{
    private boolean status;

    public Result turnOn(){
        Result r;
        if (!status){
            status = true;
            r = new Result(true, "Se ha encendido el Emisor");
        }
        else
            r = new Result(false, "El Emisor ya se encuentra Encendido");
        return r;
    }

    public Result turnOff(){
        Result r;
        if (status){
            status = false;
            r = new Result(true, "Se ha apagado el Emisor");
        }
        else
            r = new Result(false, "El emisor ya se encuentra apagado");
        return r;
    }

    public Result transmit(){
        Signal s = super.getSignal();
        Result r;

        if (s == null)
            r = new Result(false, "No se encontro ninguna señal");
        else{
            amplifySignal();
            if (super.getNextComp() != null){
                super.getNextComp().setSignal(s);
                r = new Result(true, "Señal enviada al siguiente componente");
            }
            else
                r = new Result(true, "Señal transmitida hasta el ultimo componente");
		}
        return r;
    }

    public boolean amplifySignal(){
        boolean conf;
        Signal s = super.getSignal();

        if (s == null)
            conf = false;
        else{
			super.getSignal().setStrength(100);
			System.out.println("Repetidor: Se amplifico la señal");
			conf = true;
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
}
