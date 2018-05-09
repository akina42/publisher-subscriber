import java.rmi.Naming;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntermediaryImpl3 extends java.rmi.server.UnicastRemoteObject implements IIntermediary3{
    Set<Subscription> listSubscriptions = new HashSet<>();
    Set<Subscription> listRoutes = new HashSet<>();
    String nameNode = "I1";


    public IntermediaryImpl3()
            throws java.rmi.RemoteException {
        super();
    }

    public void receiveSubscribe(Set listSubscriptionsReceived, String nameNodeReceived){

/*        System.out.println("\nRecebida uma assinatura do nó: " + nameNodeReceived + "!");*/

        if(nameNodeReceived.equals("A1") ||
                nameNodeReceived.equals("A2") ||
                nameNodeReceived.equals("A3")){
            Iterator<Subscription> listSubscriptionsReceivedAsIterator = listSubscriptionsReceived.iterator();
            while(listSubscriptionsReceivedAsIterator.hasNext()/* &&
                    listSubscriptionsReceivedAsIterator.next() != null*/){
                listSubscriptions.add(listSubscriptionsReceivedAsIterator.next());
            }
        }
        else{
            Iterator<Subscription> listSubscriptionsReceivedAsIterator = listSubscriptionsReceived.iterator();
            while(listSubscriptionsReceivedAsIterator.hasNext() /*&&
                    listSubscriptionsReceivedAsIterator.next() != null*/){
                listSubscriptionsReceivedAsIterator.next().setNode(nameNodeReceived);
                listRoutes.add(listSubscriptionsReceivedAsIterator.next());
            }
        }
        try{
            IIntermediary2 intermediary2 = (IIntermediary2) Naming.lookup("//127.0.0.1:1099/intermediary2");
            intermediary2.receiveSubscribe(listSubscriptions, nameNode);
        }
        catch (Exception e){
            System.out.println("\nErro: " + e);
        }

    }


    public void publishEvent(String topic, String nameNodeReceived){

/*        System.out.println("\nRecebida uma publicação do nó: " + nameNodeReceived + "!");*/

        Iterator<Subscription> listSubscriptionsAsIterator = listSubscriptions.iterator();
        Iterator<Subscription> listRoutesAsIterator = listRoutes.iterator();

        while(listSubscriptionsAsIterator.hasNext() /*&&
                listSubscriptionsAsIterator.next() != null*/){
            String auxNode = listSubscriptionsAsIterator.next().getNode();
            switch(auxNode){
/*                case "A1":
                    try{
                        ISubscriber1 subscriber1 = (ISubscriber1) Naming.lookup("//127.0.0.1:1099/subscriber1");
                        subscriber1.notifySubscriber(topic, nameNode);
                    }
                    catch (Exception e){
                        System.out.println("\nErro: " + e);
                    }
                    break;
                case "A2":
                    try{
                        ISubscriber2 subscriber2 = (ISubscriber2) Naming.lookup("//127.0.0.1:1099/subscriber2");
                        subscriber2.notifySubscriber(topic, nameNode);
                    }
                    catch (Exception e){
                        System.out.println("\nErro: " + e);
                    }
                    break;*/
                case "A3":
                    try{
                        ISubscriber3 subscriber3 = (ISubscriber3) Naming.lookup("//127.0.0.1:1099/subscriber3");
                        subscriber3.notifySubscriber(topic, nameNode);
                    }
                    catch (Exception e){
                        System.out.println("\nErro: " + e);
                    }
                    break;
                default:
/*                    System.out.println("\nNão há assinantes para notificar.");*/
                    break;
            }
        }

        while(listRoutesAsIterator.hasNext() /*&&
                listRoutesAsIterator.next() != null*/){
            String auxIntermediary = listRoutesAsIterator.next().getNode();
            switch(auxIntermediary){
                case "I2":
                    try{
                        IIntermediary2 intermediary2 = (IIntermediary2) Naming.lookup("//127.0.0.1:1099/intermediary2");
                        intermediary2.publishEvent(topic, nameNode);
                    }
                    catch (Exception e){
                        System.out.println("\nErro: " + e);
                    }
                    break;
                default:
/*                    System.out.println("\nNão há intermediários para enviar esta publicação.");*/
                    break;
            }

        }
    }
}