import java.util.Set;

public interface IIntermediary1 extends java.rmi.Remote{

    public void receiveSubscribe(Set listSubscriptionsReceived, String nameNodeReceived)
            throws java.rmi.RemoteException;

    public void publishEvent(String topic, String nameNodeReceived)
            throws java.rmi.RemoteException;
}
