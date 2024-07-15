package co.uk.GoogleSpeechToTextToSpeech;

import co.uk.GoogleSpeechToTextToSpeech.audio.Audio;
import co.uk.GoogleSpeechToTextToSpeech.google.TextToAudioConversation;
import co.uk.GoogleSpeechToTextToSpeech.google.TranscriptionFromAudioToText;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;

/**
 * The GoogleSpeechToTextToSpeechApplication class demonstrates integration with Google Cloud
 * Speech-to-Text and Text-to-Speech APIs for audio transcription and text-to-audio conversion.
 * <p>
 * The main method initiates Spring Boot application context, generates audio from text,
 * saves the audio to a file, reads the audio back from the file, and transcribes it to text.
 */
@SpringBootApplication
public class GoogleSpeechToTextToSpeechApplication {

	/**
	 * Main method to run the GoogleSpeechToTextToSpeechApplication.
	 *
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(GoogleSpeechToTextToSpeechApplication.class, args);

		try {
			TextToAudioConversation textToAudioConversation = new TextToAudioConversation();
			Audio audio = new Audio();
			String text = "Hello, this is a test of text-to-audio conversion.";

			// Generate audio from text
			byte[] audioData = textToAudioConversation.createAudio(text);

			// Save audio to file
			String filePath = audio.saveAudioToFile(audioData);

			// Read audio from file
			InputStream audioInputStream = audio.readAudioFromFile(filePath);

			// Transcribe audio to text
			String transcription = TranscriptionFromAudioToText.transcribeAudio(audioInputStream);
			System.out.println("Transcription: " + transcription);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

