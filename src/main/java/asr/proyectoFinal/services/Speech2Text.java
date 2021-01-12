package asr.proyectoFinal.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.language_translator.v3.LanguageTranslator;
import com.ibm.watson.language_translator.v3.model.TranslateOptions;
import com.ibm.watson.language_translator.v3.model.TranslationResult;
import com.ibm.watson.speech_to_text.v1.SpeechToText;
import com.ibm.watson.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.speech_to_text.v1.model.SpeechRecognitionResults;
import com.ibm.watson.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.text_to_speech.v1.model.GetVoiceOptions;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.model.Voice;
import com.ibm.watson.text_to_speech.v1.util.WaveUtils;

public class Speech2Text
{
	public static String leer(String audio){
	
		IamAuthenticator authenticator = new IamAuthenticator("ZHpjjI8h5DF7YOdBPuwxG7MwRaVJu262TpuyEq_o0khi");
		SpeechToText speechToText = new SpeechToText(authenticator);
		speechToText.setServiceUrl("https://api.eu-gb.speech-to-text.watson.cloud.ibm.com/instances/3631035b-ff2b-482d-9528-e9d89e4c2871");
		String salida = "";
		
		try {
			  RecognizeOptions recognizeOptions = new RecognizeOptions.Builder()
			    .audio(new FileInputStream(audio))
			    .contentType("audio/wav")
			    .wordAlternativesThreshold((float) 0.9)
			    .keywords(Arrays.asList("colorado", "tornado", "tornadoes"))
			    .keywordsThreshold((float) 0.5)
			    .build();
			  
			  SpeechRecognitionResults speechRecognitionResults =
			    speechToText.recognize(recognizeOptions).execute().getResult();
			  
			  salida = speechRecognitionResults.toString();
			  
			  System.out.println(speechRecognitionResults.toString());
			  } catch (FileNotFoundException e) {
			    e.printStackTrace();
			  }		
		
		return salida;
	}
}