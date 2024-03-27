public class AlreadyWatchedException extends RuntimeException{
    public AlreadyWatchedException() {
        super("You've already seen this movie here!");
    }
}
