import java.rmi.Naming;
import java.util.Scanner;

public class Publisher1 {
    public static void main(String[] args) {
        try {
            IIntermediary1 intermediary1 = (IIntermediary1) Naming.lookup( "//127.0.0.1:1099/intermediary1");
            System.out.println("\nPUBLISHER 1");
            System.out.println("\nDigite o tópico a ser publicado: ");
            Scanner auxTopic = new Scanner(System.in);
            String topic = auxTopic.nextLine();
            String namePublisher = "P1";
            intermediary1.publishEvent(topic, namePublisher);
            System.out.println("\nTópico publicado com sucesso!");
            auxTopic.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
