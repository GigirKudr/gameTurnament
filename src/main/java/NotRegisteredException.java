public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Игрок по имени " + name + " не найден");
    }
}
