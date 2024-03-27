/**
 * Exception class.
 * @author mpalucci3
 * @version 1
 */
public class FilmNotFoundException extends Exception {
    /**
     * Exception constructor taking in String movie.
     * @param movie String representing the movie that is not found
     */
    public FilmNotFoundException(String movie) {
        super(String.format("%s is not playing at this movie theater.", movie));
    }
}
