package com.exercicio.exercicio_4;
import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.ai.textanalytics.models.DocumentSentiment;
import com.azure.core.credential.AzureKeyCredential;
public class App {
   public static void main(String[] args) {
       String endpoint = "https://anna-servico-cognitivo.cognitiveservices.azure.com/";
       String key = "284116735e1c4b96ab93b2eb276023ca";
       TextAnalyticsClient textAnalyticsClient = new TextAnalyticsClientBuilder()
           .credential(new AzureKeyCredential(key))
           .endpoint(endpoint)
           .buildClient();
       String[] documents = new String[] {
       	    "Eu adorei o novo design do produto!",  
       	    "O produto que comprei quebrou no primeiro uso.",  
       	    "O relatório foi entregue ontem.",  
       	    "O produto é de boa qualidade, mas o atendimento foi terrível." 
       	};
      
       for (String document : documents) {
           DocumentSentiment documentSentiment = textAnalyticsClient.analyzeSentiment(document);
           System.out.printf("Document: %s%nSentiment: %s%n", document, documentSentiment.getSentiment());
       }
   }
}
