
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Part4 {

    public static void saveSongToFile(String filename) {
        String song = "In the town where I was born\n" +
                "Lived a man who sailed to sea\n" +
                "And he told us of his life\n" +
                "In the land of submarines\n" +
                "So we sailed on to the sun\n" +
                "Til we found a sea of green\n" +
                "And we lived beneath the waves\n" +
                "In our yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "And our friends are all aboard\n" +
                "Many more of them live next door\n" +
                "And the band begins to play\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "Full steam ahead, Mister Boatswain, full steam ahead\n" +
                "Full steam ahead it is, Sergeant\n" +
                "(Cut the cable, drop the cable)\n" +
                "Aye-aye, sir, aye-aye\n" +
                "Captain, captain\n" +
                "As we live a life of ease (a life of ease)\n" +
                "Every one of us (every one of us)\n" +
                "Has all we need (has all we need)\n" +
                "Sky of blue (sky of blue)\n" +
                "And sea of green (sea of green)\n" +
                "In our yellow (in our yellow)\n" +
                "Submarine (submarine, aha)\n" +
                "We all live in a yellow submarine\n" +
                "A yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "A yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine\n" +
                "We all live in a yellow submarine\n" +
                "Yellow submarine, yellow submarine";

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("/Users/acumic/IdeaProjects/javaCorePart2/resources/" + filename))) {
            writer.write(song);
            System.out.println("Song saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static String readSongFromFile(String filename) throws IOException {
        StringBuilder songContent = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                songContent.append(line).append("\n");
            }
        }
        return songContent.toString();
    }

    public static class BeatlesException extends Exception {
        public BeatlesException(String message) {
            super("BeatlesException: " + message);
        }
    }

    public static boolean isStringInSong(String song, String searchString) {
        return song.toLowerCase().contains(searchString.toLowerCase());
    }

    public static void verifyStringInSong(String song, String searchString) throws BeatlesException {
        if (!isStringInSong(song, searchString)) {
            throw new BeatlesException("The string '" + searchString + "' was not found in the song.");
        }
    }

    public static void main(String[] args) {

        String filename = "yellow_submarine_song.txt";
        saveSongToFile(filename);

        try{
            String song = readSongFromFile("/Users/acumic/IdeaProjects/javaCorePart2/resources/" + filename);

            String randomString = "Show must go on!";
            String actualString = "Yellow submarine";

            try{
                verifyStringInSong(song, randomString);
            } catch (BeatlesException e){
                System.out.println(e.getMessage());
            }

            try {
                verifyStringInSong(song, actualString);
                System.out.println("The string '" + actualString + "' is found in the song!");
            } catch (BeatlesException e){
                System.out.println(e.getMessage());
            }

        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
