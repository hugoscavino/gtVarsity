import java.util.Objects;

public class Movie {
    String name;
    String media;
    int year;

    public Movie(String name, String media, int year) {
        this.name = name;
        this.media = media;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return year == movie.year && Objects.equals(name, movie.name) && Objects.equals(media, movie.media);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, media, year);
    }

    @Override
    public String toString() {
        return "" + year + '\t' +
                media + '\t' +
                name;
    }
}
