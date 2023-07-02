package com.amrita.jpl.cys21046.practice.file;

//public class txtFile {
//}

import java.io.BufferedWriter;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

public class txtFile {

    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("topmovies.txt"));

            List<String> movies = new ArrayList<>();
            movies.add("Citizen Kane (1941)");
            movies.add("The Godfather (1972)");
            movies.add("Casablanca (1942)");
            movies.add("Raging Bull (1980)");
            movies.add("Singin' in the Rain (1952)");
            movies.add("Gone with the Wind (1939)");
            movies.add("Lawrence of Arabia (1962)");
            movies.add("Schindler's List (1993)");
            movies.add("Vertigo (1958)");
            movies.add("The Wizard of Oz (1939)");
            movies.add("City Lights (1931)");
            movies.add("The Searchers (1956)");
            movies.add("Star Wars (1977)");
            movies.add("Psycho (1960)");
            movies.add("2001: A Space Odyssey (1968)");
            movies.add("Sunset Boulevard (1950)");
            movies.add("The Graduate (1967)");
            movies.add("The General (1926)");
            movies.add("On the Waterfront (1954)");
            movies.add("It's a Wonderful Life (1946)");
            movies.add("Chinatown (1974)");
            movies.add("Some Like It Hot (1959)");
            movies.add("The Grapes of Wrath (1940)");
            movies.add("E.T. the Extra-Terrestrial (1982)");
            movies.add("To Kill a Mockingbird (1962)");
            movies.add("Mr. Smith Goes to Washington (1939)");
            movies.add("High Noon (1952)");
            movies.add("All About Eve (1950)");
            movies.add("Double Indemnity (1944)");
            movies.add("Apocalypse Now (1979)");
            movies.add("The Maltese Falcon (1941)");
            movies.add("The Godfather Part II (1974)");
            movies.add("One Flew Over the Cuckoo's Nest (1975)");
            movies.add("Snow White and the Seven Dwarfs (1937)");
            movies.add("Annie Hall (1977)");
            movies.add("The Bridge on the River Kwai (1957)");
            movies.add("The Best Years of Our Lives (1946)");
            movies.add("The Treasure of the Sierra Madre (1948)");
            movies.add("Dr. Strangelove or: How I Learned to Stop Worrying and Love the Bomb (1964)");
            movies.add("The Sound of Music (1965)");
            movies.add("King Kong (1933)");
            movies.add("Bonnie and Clyde (1967)");
            movies.add("Midnight Cowboy (1969)");
            movies.add("The Philadelphia Story (1940)");
            movies.add("Shane (1953)");
            movies.add("It Happened One Night (1934)");
            movies.add("A Streetcar Named Desire (1951)");
            movies.add("Rear Window (1954)");
            movies.add("Intolerance (1916)");
            movies.add("The Lord of the Rings: The Fellowship of the Ring (2001)");
            movies.add("West Side Story (1961)");
            movies.add("Taxi Driver (1976)");
            movies.add("The Deer Hunter (1978)");
            movies.add("MASH (1970)");
            movies.add("North by Northwest (1959)");
            movies.add("Jaws (1975)");
            movies.add("Rocky (1976)");
            movies.add("The Gold Rush (1925)");
            movies.add("Nashville (1975)");
            movies.add("Duck Soup (1933)");
            movies.add("Sullivan's Travels (1941)");
            movies.add("American Graffiti (1973)");
            movies.add("Cabaret (1972)");
            movies.add("Network (1976)");
            movies.add("The African Queen (1951)");
            movies.add("Raiders of the Lost Ark (1981)");
            movies.add("Who's Afraid of Virginia Woolf? (1966)");
            movies.add("Unforgiven (1992)");
            movies.add("Tootsie (1982)");
            movies.add("A Clockwork Orange (1971)");
            movies.add("Saving Private Ryan (1998)");
            movies.add("The Shawshank Redemption (1994)");
            movies.add("Butch Cassidy and the Sundance Kid (1969)");
            movies.add("The Silence of the Lambs (1991)");
            movies.add("In the Heat of the Night (1967)");
            movies.add("Forrest Gump (1994)");
            movies.add("All the President's Men (1976)");
            movies.add("Modern Times (1936)");
            movies.add("The Wild Bunch (1969)");
            movies.add("The Apartment (1960)");
            movies.add("Spartacus (1960)");
            movies.add("Sunrise: A Song of Two Humans (1927)");
            movies.add("Titanic (1997)");
            movies.add("Easy Rider (1969)");
            movies.add("A Night at the Opera (1935)");
            movies.add("Platoon (1986)");
            movies.add("12 Angry Men (1957)");
            movies.add("Bringing Up Baby (1938)");
            movies.add("The Sixth Sense (1999)");
            movies.add("Swing Time (1936)");
            movies.add("Sophie's Choice (1982)");
            movies.add("Goodfellas (1990)");
            movies.add("The French Connection (1971)");
            movies.add("Pulp Fiction (1994)");
            movies.add("The Last Picture Show (1971)");
            movies.add("Do the Right Thing (1989)");
            movies.add("Blade Runner (1982)");
            movies.add("Yankee Doodle Dandy (1942)");
            movies.add("Toy Story (1995)");
            movies.add("Ben-Hur (1959)");

            for (int i = 0; i < movies.size(); ++i) {
                String movie = (i + 1) + ". " + movies.get(i) + "\n";
                writer.write(movie);
            }

            writer.close();
            System.out.println("Text file created successfully.");
        } catch (IOException e) {
            System.out.println("Failed to create the text file.");
            e.printStackTrace();
        }
    }
}

