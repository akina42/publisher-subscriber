import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.*;

public class SubscriberImpl1 extends java.rmi.server.UnicastRemoteObject implements ISubscriber1 {


    public SubscriberImpl1()
            throws java.rmi.RemoteException {
        super();
    }

    public void inputSubscriber()
          throws java.rmi.RemoteException{

        Set<Subscription> listSubscriptions = new HashSet<>();
        Subscription subscription1 = new Subscription();
        Subscription subscription2 = new Subscription();
        Subscription subscription3 = new Subscription();
        Scanner scanner = new Scanner(System.in);
        String nameNode = "A1";
        Integer option = 0;
        while (option != 4){
            System.out.println("\nDigite o número do tópico que você quer assinar:");
            System.out.println("\n1 - Física");
            System.out.println("2 - Matemática");
            System.out.println("3 - Ciência da Computação");
            System.out.println("4 - Sair do Menu");
            option = Integer.parseInt(scanner.nextLine());
            System.out.println(option);
            switch(option){
                case 1:
                    System.out.println("\nVocê assinou a seção sobre Física!");
                    subscription1.setNode(nameNode);
                    subscription1.setTopic("a1");
                    listSubscriptions.add(subscription1);
                    break;
                case 2:
                    System.out.println("\nVocê assinou a seção sobre Matemática!");
                    subscription2.setNode(nameNode);
                    subscription2.setTopic("a2");
                    listSubscriptions.add(subscription2);
                    break;
                case 3:
                    System.out.println("\nVocê assinou a seção sobre Ciência da Computação!");
                    subscription3.setNode(nameNode);
                    subscription3.setTopic("a3");
                    listSubscriptions.add(subscription3);
                    break;
                case 4:
                    System.out.println("\nVocê selecionou a opção para sair do menu. " +
                            "Em breve você começará a receber as publicações!");
                    break;
                default:
                    System.out.println("\nOpção Inválida! Por favor, tente novamente.");
                    break;
            }

        }

        try{
            IIntermediary2 intermediary2 = (IIntermediary2) Naming.lookup("//127.0.0.1:1099/intermediary2");
            intermediary2.receiveSubscribe(listSubscriptions, nameNode);
        }
        catch (Exception e){
            System.out.println("\nErro: " + e);
        }
        scanner.close();

    }

    public void notifySubscriber(String topic, String nameNodeReceived)
            throws java.rmi.RemoteException{
        System.out.println("\nRecebida a notificação do tópico " + topic + " !");
        System.out.println("Notificação recebida do nó " + nameNodeReceived + ".");

    }
}
