package co.uk.GoogleSpeechToTextToSpeech.google;

import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.protobuf.ByteString;

import java.io.IOException;
import java.io.InputStream;

/**
 * The TranscriptionFromAudioToText class provides functionality to transcribe audio to text
 * using Google Cloud Speech-to-Text API.
 */
public class TranscriptionFromAudioToText {

    /**
     * Transcribes the audio input stream to text.
     *
     * @param audioInputStream The input stream of the audio to be transcribed.
     * @return The transcribed text.
     * @throws IOException If there is an error during the transcription process.
     */
    public static String transcribeAudio(InputStream audioInputStream) throws IOException {
        // Instantiate the Google Cloud Speech-to-Text client
        try (SpeechClient speechClient = SpeechClient.create()) {
            // Read the audio file
            ByteString audioBytes = ByteString.readFrom(audioInputStream);

            // Configure the speech recognition request
            RecognitionConfig config = RecognitionConfig.newBuilder()
                    .setEncoding(RecognitionConfig.AudioEncoding.OGG_OPUS) // Set the audio encoding to OGG_OPUS
                    .setSampleRateHertz(48000) // Set the audio sample rate to 48000 Hz
                    .setLanguageCode("en-GB") // Set the language code to British English
                    .build();
            RecognitionAudio audio = RecognitionAudio.newBuilder()
                    .setContent(audioBytes) // Set the audio content
                    .build();

            // Make the speech recognition request
            RecognizeResponse response = speechClient.recognize(config, audio);

            // Extract the transcription from the response
            StringBuilder transcricao = new StringBuilder();
            for (com.google.cloud.speech.v1.SpeechRecognitionResult result : response.getResultsList()) {
                transcricao.append(result.getAlternativesList().get(0).getTranscript()).append(" ");
            }
            return transcricao.toString(); // Return the transcription as a string
        }
    }
}
