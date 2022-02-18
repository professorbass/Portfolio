


public interface StateChangeable<T extends Status> {
    void changeState(T status);
}
