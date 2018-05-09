import java.rmi.Naming;

public class Intermediary1 {
    public Intermediary1() {
        try {
            IIntermediary1 clientServer = new IntermediaryImpl1();
            Naming.rebind("//127.0.0.1:1099/intermediary1", clientServer);
            System.out.println("\nINTERMEDIARY 1");
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
    public static void main(String args[]) {
        new Intermediary1();
    }
}
