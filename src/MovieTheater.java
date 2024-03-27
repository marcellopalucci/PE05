import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class represents a movie theater playing different movies.
 * @author mpalucci3
 * @version 1
 */
public class MovieTheater {
    private ArrayList<String> movies;
    private ArrayList<String> watched;

    /**
     * Constructor taking in ArrayList of movies and ArrayList of watched.
     * @param movies String ArrayList representing the movies shown at the theater
     * @param watched String ArrayList representing the movies you have already watched at the theater
     */
    public MovieTheater(ArrayList<String> movies, ArrayList<String> watched) {
        this.movies = (movies != null) ? movies : new ArrayList<String>();
        this.watched = (watched != null) ? watched : new ArrayList<String>();
    }

    /**
     * Checks to see if ALL the movies you are interested in seeing are playing at the theater.
     * @param interestingMovies String ArrayList representing movies which are interesting
     * @throws FilmNotFoundException checked Exception representing films not found in the movie theater
     */
    public void throwIfMoviesMissing(ArrayList<String> interestingMovies) throws FilmNotFoundException {
        if (interestingMovies == null) {
            throw new IllegalArgumentException("Error, interestingMovies is null.");
        }
        for (String interestingMovie : interestingMovies) {
            if (!movies.contains(interestingMovie)) {
                throw new FilmNotFoundException(interestingMovie);
            }
        }
    }

    /**
     * Watch a movie at the theater if you haven't already watched it there.
     * @param movie String representing the movie to be watched.
     * @throws FilmNotFoundException checked Exception representing films not found in the movie theater
     */
    public void watchMovie(String movie) throws FilmNotFoundException {
        if (movie == null) {
            throw new IllegalArgumentException("Error, movie to watch is null.");
        }
        if (!movies.contains(movie)) {
            throw new FilmNotFoundException(movie);
        } else if (watched.contains(movie)) {
            throw new AlreadyWatchedException();
        } else if (movies.contains(movie)) {
            movies.remove(movie);
            watched.add(movie);
        }
    }

    /**
     * Using the list of movies recommended by a friend, determine which movies will be watched at the movie theater.
     * @param recommendedMoives String ArrayList representing your friend's list of recommended movies to watch
     * @return String ArrayList representing movies in theaters and those recommended
     */
    public ArrayList<String> selectRecommended(ArrayList<String> recommendedMoives) {
        if (recommendedMoives == null) {
            throw new IllegalArgumentException("Error, recommendedMovies is null.");
        }

        ArrayList<String> willSee = new ArrayList<String>();

        for (String movieToList : recommendedMoives) {
            if (movies.contains(movieToList) && !watched.contains(movieToList)) {
                willSee.add(movieToList);
            }
        }
        return willSee;
    }

    /**
     * Main method.
     * @param args no Args
     * @throws FilmNotFoundException checked Exception representing films not found in the movie theater
     */
    public static void main(String[] args) throws FilmNotFoundException {
        ArrayList<String> movies = new ArrayList<String>(Arrays.asList("Dune: Part Two",
                "Arthur the King",
                "Imaginary",
                "Kung fu Panda 4",
                "Luca"));


        ArrayList<String> watched = new ArrayList<String>(Arrays.asList("Luca",
                "Borat"));

        ArrayList<String> recommended = new ArrayList<String>(Arrays.asList("Borat",
                "Dune: Part Two",
                "Harold & Kumar"));

        MovieTheater plazaTheater = new MovieTheater(movies, watched);

        try {
            plazaTheater.throwIfMoviesMissing(movies);
            plazaTheater.watchMovie("Luca");
            plazaTheater.watchMovie("Borat");
            plazaTheater.watchMovie("Bean");
            for (String recommendedMovies : plazaTheater.selectRecommended(recommended)) {
                System.out.println(recommendedMovies);
            }
        } catch (FilmNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (AlreadyWatchedException awe) {
            System.out.println(awe.getMessage());
        } finally {
            System.out.println("Took a look at the movies!");
        }

    }

}
