import java.rmi.Naming;

public class Intermediary3 {
    public Intermediary3() {
        try {
            IIntermediary3 clientServer = new IntermediaryImpl3();
            Naming.rebind("//127.0.0.1:1099/intermediary3", clientServer);
            System.out.println("\nINTERMEDIARY 3");
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
    public static void main(String args[]) {
        new Intermediary3();
    }
}
