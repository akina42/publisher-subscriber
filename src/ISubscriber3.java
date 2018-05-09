public interface ISubscriber3 extends java.rmi.Remote{
    public void notifySubscriber(String topic, String nameNodeReceived)
            throws java.rmi.RemoteException;
}
