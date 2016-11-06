package am.ik.demo;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;

import reactor.core.publisher.Flux;

@SpringBootApplication
@EnableBinding(Processor.class)
public class WakatiKuromojiProcessorApplication {

	private final Tokenizer tokenizer = new Tokenizer();
	private static final Logger log = LoggerFactory
			.getLogger(WakatiKuromojiProcessorApplication.class);

	@StreamListener
	@Output(Processor.OUTPUT)
	public Flux<TokenBean> handle(@Input(Processor.INPUT) Flux<String> textStream) {
		return textStream.log("stream.input")
				.flatMap(text -> Flux.fromIterable(tokenizer.tokenize(text)))
				.map(TokenConverter::convert).log("stream.output");
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
