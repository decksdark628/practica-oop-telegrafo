public class Main{
    public static void main(String[] args){
        Cable c1 = new Cable(50.0, 10);
        Cable c2 = new Cable(120.5, 5);
        Cable c3 = new Cable(80.0, 25);
        Cable c4 = new Cable(30.0, 40);
        Relay rel = new Relay();

        SignalCarrier[] carriers = {c1, c2, rel};
        // SignalCarrier[] carriers = {c1, c2, c3, c4};

        TelegraphSystem tlSys = new TelegraphSystem(carriers);

        tlSys.run();
    }
}