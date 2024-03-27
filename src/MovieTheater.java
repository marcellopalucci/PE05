import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MovieTheater{
    private ArrayList<String> movies;
    private ArrayList<String> watched;

    public MovieTheater(ArrayList<String> movies, ArrayList<String> watched){
        this.movies = (movies != null) ? movies : new ArrayList<String>();
        this.watched = (watched != null) ? watched : new ArrayList<String>();
    }
    public void throwIfMoviesMissing (ArrayList <String> interestingMovies) throws FilmNotFoundException{
        if (interestingMovies == null){
            throw new IllegalArgumentException("Error, interestingMovies is null.");
        }
        for (String interestingMovie : interestingMovies){
                if (!movies.contains(interestingMovie)){
                    throw new FilmNotFoundException(interestingMovie);
                }
        }
    }

    public void watchMovie(String movie) throws FilmNotFoundException{
        if (movie == null){
            throw new IllegalArgumentException("Error, movie to watch is null.");
        }
        if (!movies.contains(movie)) {
            throw new FilmNotFoundException(movie);
        } else if (watched.contains(movie)){
            throw new AlreadyWatchedException();
        } else if (movies.contains(movie)){
            movies.remove(movie);
            watched.add(movie);
        }
    }

    public ArrayList<String> selectRecommended(ArrayList<String> recommendedMoives){
        if (recommendedMoives == null){
            throw new IllegalArgumentException ("Error, recommendedMovies is null.");
        }

        ArrayList<String> willSee = new ArrayList<String>();

        for (String movieToList : recommendedMoives){
            if (movies.contains(movieToList) && !watched.contains(movieToList)){
                willSee.add(movieToList);
            }
        }
        return willSee;
    }

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

        MovieTheater PlazaTheater = new MovieTheater(movies, watched);

        try {
            PlazaTheater.throwIfMoviesMissing(movies);
            PlazaTheater.watchMovie("Luca");
            PlazaTheater.watchMovie("Borat");
            PlazaTheater.watchMovie("Bean");
            for (String recommendedMovies : PlazaTheater.selectRecommended(recommended)){
                System.out.println(recommendedMovies);
            }
        } catch (FilmNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
        } catch (AlreadyWatchedException awe){
            System.out.println(awe.getMessage());
        } finally {
            System.out.println("Took a look at the movies!");
        }

    }

}
