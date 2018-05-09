import java.rmi.Naming;
import java.util.Scanner;

public class Publisher2 {
    public static void main(String[] args) {
        try {
            IIntermediary3 intermediary3 = (IIntermediary3) Naming.lookup( "//127.0.0.1:1099/intermediary3");
            System.out.println("\nPUBLISHER 2");
            System.out.println("\nDigite o tópico a ser publicado: ");
            Scanner auxTopic = new Scanner(System.in);
            String topic = auxTopic.nextLine();
            String namePublisher = "P2";
            intermediary3.publishEvent(topic, namePublisher);
            System.out.println("\nTópico publicado com sucesso!");
            auxTopic.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
