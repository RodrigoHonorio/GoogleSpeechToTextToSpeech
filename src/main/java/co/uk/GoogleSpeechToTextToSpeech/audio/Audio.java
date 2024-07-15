package co.uk.GoogleSpeechToTextToSpeech.audio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * The Audio class provides methods for saving audio data to a file
 * and reading audio data from a file.
 */
public class Audio {

    /**
     * Saves audio data to a file in the user's GoogleAudio directory.
     *
     * @param audioData The audio data to be saved.
     * @return The absolute path of the saved audio file.
     * @throws IOException If an I/O error occurs during file operations.
     */
    public String saveAudioToFile(byte[] audioData) throws IOException {
        // Define the directory path for GoogleAudio in the user's home directory
        String userHome = System.getProperty("user.home");
        String googleAudioPath = userHome + File.separator + "GoogleAudio";
        File googleAudioDir = new File(googleAudioPath);

        // Create the directory if it doesn't exist
        if (!googleAudioDir.exists()) {
            if (!googleAudioDir.mkdirs()) {
                throw new IOException("Failed to create directory: " + googleAudioPath);
            }
        }

        // Define the full file path
        String filePath = googleAudioPath + File.separator + "output.ogg";
        File fileToSave = new File(filePath);

        try (FileOutputStream fos = new FileOutputStream(fileToSave)) {
            fos.write(audioData); // Write the audio data to the file
            fos.flush();
        }

        System.out.println("File saved at: " + fileToSave.getAbsolutePath());
        return fileToSave.getAbsolutePath();  // Return the absolute path of the saved file
    }

    /**
     * Reads audio data from a file specified by the filePath.
     *
     * @param filePath The path of the audio file to be read.
     * @return An InputStream containing the audio data from the file.
     * @throws IOException If an I/O error occurs during file operations.
     */
    public InputStream readAudioFromFile(String filePath) throws IOException {
        return new FileInputStream(new File(filePath)); // Return an InputStream for reading audio data from file
    }
}
