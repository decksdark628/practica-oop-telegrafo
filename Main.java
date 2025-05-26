public class Main{
    public static void main(String[] args){
        Cable c1 = new Cable(5.0, 10);
        Cable c2 = new Cable(12.5, 2);
        Cable c3 = new Cable(3.5, 5);
        Cable c4 = new Cable(2, 10);
        Relay rel1 = new Relay();
        Relay rel2 = new Relay();
        

        SignalCarrier[] carriers = {c1, rel1, c2, c3, rel2, c4};


        TelegraphSystem tlSys = new TelegraphSystem(carriers);
        System.out.println("Un nuevo telegrafo ha sido creado");

        tlSys.run();
    }
}