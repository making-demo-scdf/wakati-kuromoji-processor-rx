package am.ik.demo;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;

@SpringBootApplication
@EnableBinding(Processor.class)
public class WakatiKuromojiProcessorApplication {

	private final Tokenizer tokenizer = new Tokenizer();
	private final MessageChannel output;
	private static final Logger log = LoggerFactory
			.getLogger(WakatiKuromojiProcessorApplication.class);

	public WakatiKuromojiProcessorApplication(MessageChannel output) {
		this.output = output;
	}

	@StreamListener(Processor.INPUT)
	public void handle(String text) {
		List<Token> tokens = tokenizer.tokenize(text);
		log.info("Tokenized to {} tokens", tokens.size());
		for (Token token : tokens) {
			output.send(
					MessageBuilder.withPayload(TokenConverter.convert(token)).build());
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(WakatiKuromojiProcessorApplication.class, args);
	}

	static class TokenConverter {
		public static TokenBean convert(Token token) {
			return new TokenBean(token.getSurface(), token.getPosition(),
					Arrays.asList(token.getAllFeaturesArray()),
					token.getPartOfSpeechLevel1(), token.getPartOfSpeechLevel2(),
					token.getPartOfSpeechLevel3(), token.getPartOfSpeechLevel4(),
					token.getConjugationType(), token.getConjugationForm(),
					token.getBaseForm(), token.getReading(), token.getPronunciation());
		}
	}
}
