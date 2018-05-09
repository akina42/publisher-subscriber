public interface ISubscriber2 extends java.rmi.Remote{
    public void notifySubscriber(String topic, String nameNodeReceived)
            throws java.rmi.RemoteException;
}
