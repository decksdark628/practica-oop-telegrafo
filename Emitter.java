import java.util.Scanner;

public class Emitter implements TransmitsSignal{
    private boolean status;
    private SignalCarrier nextComp;

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

        System.out.println("Escribe un mensaje: ");
        do {
            temp = sc.nextLine();
            valid = validMsg(temp);
            if(!valid)
                System.out.println("Solo se pueden usar caracteres de la 'A' a la 'Z' y espacios.\nIntentalo de nuevo:");
        } while (!valid);
        sc.close();
        return temp;
    }

    public Result transmit(){
        Result r;
        if (!status)
            r = new Result(false, "No se pudo enviar la señal. El transmisor no esta encendido");
		else{
			MorseEncoder mEnc = new MorseEncoder();
			String[] morseSignal = mEnc.encode(captureMsg());

            nextComp.getSignal().setContent(morseSignal);
            r = new Result( true, "Señal enviada al siguiente componente");
		}
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
    public SignalCarrier getNextComp() {
        return this.nextComp;
    }
    public void setNextComp(SignalCarrier nextComp) {
        this.nextComp = nextComp;
    }
}