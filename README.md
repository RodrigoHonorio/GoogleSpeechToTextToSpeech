# Google Speech-to-Text-to-Speech

This project provides a simple application for converting speech to text and then to speech using the Google Cloud APIs. The application uses the Google Speech-to-Text API to transcribe speech to text and the Google Text-to-Speech API to synthesise text to speech.

## Features

* **Speech recognition:** The application can transcribe audio files to text using the Google Speech-to-Text API.
* **Speech synthesis:** The application can synthesise text to speech using the Google Text-to-Speech API.
* **Simple user interface:** The application provides a simple user interface for interacting with the APIs.

## Installation requirements

* Java Development Kit (JDK) 11 or higher
* Maven
* Google Cloud API credentials

## Running instructions

1. Create a project in the Google Cloud Console and enable the Speech-to-Text and Text-to-Speech APIs.
2. Generate API credentials and download the JSON file.
3. Rename the JSON file to `google_cloud_credentials.json` and place it in the `src/main/resources/` folder.
4. Compile the project: `mvn clean compile`
5. Run the application: `mvn exec:java -Dexec.mainClass="com.example.app.Main"`

## Contributions

Contributions are welcome! Please open an issue or a pull request to report problems or suggestions.

## License

This project is licensed under the Apache 2.0 License.

## Authors

* Rodrigo Honório

## Notes

* This project is just an example of how to use the Google Cloud APIs for speech recognition and speech synthesis.
* It is recommended to consult the official Google Cloud documentation for more information about the APIs.
* The application uses the free tier of the Google Cloud APIs. There may be usage limits.

## Example usage
Use code with caution.
Markdown
java -cp target/classes com.example.app.Main
## Additional information

* You can find more information about the project in the GitHub repository's wiki.
* The source code is available on the GitHub repository.
* If you have any questions, feel free to open an issue on the GitHub repository.
