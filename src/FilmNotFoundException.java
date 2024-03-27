public class FilmNotFoundException extends Exception {
    public FilmNotFoundException(String movie) {
        super(String.format("%s is not playing at this movie theater.", movie));
    }
}
