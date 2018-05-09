import java.rmi.Naming;

public class Subscriber2 {
    public Subscriber2() {
        try {
            ISubscriber2 clientServer = new SubscriberImpl2();
            Naming.rebind("//127.0.0.1:1099/subscriber2", clientServer);
            System.out.println("\nSUBSCRIBER 2");
            SubscriberImpl2 subscriberImpl2 = new SubscriberImpl2();
            subscriberImpl2.inputSubscriber();
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
    public static void main(String args[]) {
        new Subscriber2();
    }
}
