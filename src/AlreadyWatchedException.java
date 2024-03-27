/**
 * RuntimeException class.
 * @author mpalucci3
 * @version 1
 */
public class AlreadyWatchedException extends RuntimeException {
    /**
     * NoArg RuntimeException constructor.
     */
    public AlreadyWatchedException() {
        super("You've already seen this movie here!");
    }
}
