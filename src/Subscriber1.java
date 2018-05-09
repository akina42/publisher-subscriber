import java.rmi.Naming;

public class Subscriber1 {
    public Subscriber1() {
        try {
            ISubscriber1 clientServer = new SubscriberImpl1();
            Naming.rebind("//127.0.0.1:1099/subscriber1", clientServer);
            System.out.println("\nSUBSCRIBER 1");
            SubscriberImpl1 subscriberImpl1 = new SubscriberImpl1();
            subscriberImpl1.inputSubscriber();
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
    public static void main(String args[]) {
        new Subscriber1();
    }
}
