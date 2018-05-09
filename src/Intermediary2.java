import java.rmi.Naming;

public class Intermediary2 {
    public Intermediary2() {
        try {
            IIntermediary2 clientServer = new IntermediaryImpl2();
            Naming.rebind("//127.0.0.1:1099/intermediary2", clientServer);
            System.out.println("\nINTERMEDIARY 2");
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
    public static void main(String args[]) {
        new Intermediary2();
    }
}
