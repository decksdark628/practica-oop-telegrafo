import java.util.Scanner;

public class Emitter implements TransmitsSignal, TurnsOnOff{
    private boolean status;
    private SignalCarrier nextCarrier;

    public Result turnOn(){
        Result r;
        if (!status){
            status = true;
            r = new Result(true, "\tSe ha encendido el Emisor");
        }
        else
            r = new Result(false, "\tEl Emisor ya se encuentra Encendido");
        System.out.println(r.getMessage());
        return r;
    }

    public Result turnOff(){
        Result r;
        if (status){
            status = false;
            r = new Result(true, "\tSe ha apagado el Emisor");
        }
        else
            r = new Result(false, "\tEl emisor ya se encuentra apagado");
        System.out.println(r.getMessage());
        return r;
    }

    private boolean validMsg(String s){
        boolean valid = true;
        if (s == null)
            valid = false;
        else{
            for (int i = 0; i<s.length() && valid; i++){
                char x = s.charAt(i);
                if ( ! (  (x >= 'A' && x<= 'Z')  ||  (x>= 'a' && x<= 'z')  ||  x == ' ') ) 
                    valid = false;
            }
        }
        return valid;
    }

    private String captureMsg(){
        Scanner sc = new Scanner(System.in);
        String temp;
        boolean valid;

        System.out.print("Escribe un mensaje: ");
        do {
            temp = sc.nextLine();
            temp.trim();
            valid = validMsg(temp);
            if(!valid)
                System.out.println("Emisor: Solo se pueden usar caracteres de la 'A' a la 'Z' y espacios.\nIntentalo de nuevo:");
        } while (!valid);
        sc.close();
        return temp;
    }

    public Result transmit(){
        Result r;
        if (!status)
            r = new Result(false, "Emisor: No se pudo enviar la señal. El transmisor no esta encendido");
		else{
			MorseEncoder mEnc = new MorseEncoder();
			String[] morseSignal = mEnc.encode(captureMsg());

            Signal signal = new Signal(morseSignal);

            nextCarrier.setSignal(signal);
            r = new Result( true, "Emisor: Señal enviada al siguiente componente");
		}
        System.out.println("\t" + r.getMessage());
        return r;
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
    public SignalCarrier getNextCarrier() {
        return this.nextCarrier;
    }
    public void setNextComp(SignalCarrier nextCarrier) {
        this.nextCarrier = nextCarrier;
    }

    @Override
    public String toString() {
        String temp;
        temp = "Encendido: " + isStatus();
        if (nextCarrier != null)
            temp += ", Siguiente componente: " + getNextCarrier();
        return temp;
    }
}