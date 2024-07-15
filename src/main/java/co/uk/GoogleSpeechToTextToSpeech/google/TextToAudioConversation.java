package co.uk.GoogleSpeechToTextToSpeech.google;

import com.google.cloud.texttospeech.v1.*;
import com.google.protobuf.ByteString;

/**
 * The TextToAudioConversation class provides functionality to convert text to audio using
 * Google Cloud Text-to-Speech API.
 */
public class TextToAudioConversation {

    /**
     * Creates an audio byte array from the given text.
     *
     * @param text The text to be converted to audio.
     * @return A byte array containing the generated audio in OGG_OPUS format.
     * @throws Exception If there is an error during the text-to-speech conversion process.
     */
    public byte[] createAudio(String text) throws Exception {
        // Create a TextToSpeechClient instance
        try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {

            // Configure the voice parameters (language, voice name, etc.)
            VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
                    .setLanguageCode("en-GB") // Set the language code to British English
                    .setName("en-GB-Wavenet-A") // Adjust the voice name accordingly
                    .build();

            // Configure the audio output parameters (encoding format, sample rate, etc.)
            AudioConfig audioConfig = AudioConfig.newBuilder()
                    .setAudioEncoding(AudioEncoding.OGG_OPUS) // Set the audio encoding to OGG_OPUS
                    .build();

            // Create the synthesis input with the provided text
            SynthesisInput input = SynthesisInput.newBuilder()
                    .setText(text) // Set the input text
                    .build();

            // Make a request to the Text-to-Speech API to synthesize the speech
            SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

            // Retrieve the generated audio content as a ByteString
            ByteString audioContents = response.getAudioContent();

            // Return the audio content as a byte array
            return audioContents.toByteArray();
        }
    }
}
