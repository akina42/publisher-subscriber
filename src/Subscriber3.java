import java.rmi.Naming;

public class Subscriber3 {
    public Subscriber3() {
        try {
            ISubscriber3 clientServer = new SubscriberImpl3();
            Naming.rebind("//127.0.0.1:1099/subscriber3", clientServer);
            System.out.println("\nSUBSCRIBER 3");
            SubscriberImpl3 subscriberImpl3 = new SubscriberImpl3();
            subscriberImpl3.inputSubscriber();
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
    public static void main(String args[]) {
        new Subscriber3();
    }
}
