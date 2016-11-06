package am.ik.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WakatiKuromojiProcessorApplicationTests {
	@Autowired
	protected Processor channels;

	@Autowired
	protected MessageCollector messageCollector;

	@Test
	public void contextLoads() throws Exception {
		channels.input().send(MessageBuilder.withPayload("お寿司が食べたい。").build());
		BlockingQueue<Message<?>> queue = messageCollector.forChannel(channels.output());
		Message<?> message1 = queue.poll(2, TimeUnit.SECONDS);

		assertThat(message1).isNotNull();
		assertThat(message1.getPayload()).isInstanceOf(TokenBean.class);
		assertThat(((TokenBean) message1.getPayload()).getSurface()).isEqualTo("お");
		assertThat(((TokenBean) message1.getPayload()).getPartOfSpeechLevel1())
				.isEqualTo("接頭詞");

		Message<?> message2 = queue.poll(2, TimeUnit.SECONDS);
		assertThat(message2).isNotNull();
		assertThat(message2.getPayload()).isInstanceOf(TokenBean.class);
		assertThat(((TokenBean) message2.getPayload()).getSurface()).isEqualTo("寿司");
		assertThat(((TokenBean) message2.getPayload()).getPartOfSpeechLevel1())
				.isEqualTo("名詞");

		Message<?> message3 = queue.poll(2, TimeUnit.SECONDS);
		assertThat(message3).isNotNull();
		assertThat(message3.getPayload()).isInstanceOf(TokenBean.class);
		assertThat(((TokenBean) message3.getPayload()).getSurface()).isEqualTo("が");
		assertThat(((TokenBean) message3.getPayload()).getPartOfSpeechLevel1())
				.isEqualTo("助詞");

		Message<?> message4 = queue.poll(2, TimeUnit.SECONDS);
		assertThat(message4).isNotNull();
		assertThat(message4.getPayload()).isInstanceOf(TokenBean.class);
		assertThat(((TokenBean) message4.getPayload()).getSurface()).isEqualTo("食べ");
		assertThat(((TokenBean) message4.getPayload()).getPartOfSpeechLevel1())
				.isEqualTo("動詞");

		Message<?> message5 = queue.poll(2, TimeUnit.SECONDS);
		assertThat(message5).isNotNull();
		assertThat(message5.getPayload()).isInstanceOf(TokenBean.class);
		assertThat(((TokenBean) message5.getPayload()).getSurface()).isEqualTo("たい");
		assertThat(((TokenBean) message5.getPayload()).getPartOfSpeechLevel1())
				.isEqualTo("助動詞");

		Message<?> message6 = queue.poll(2, TimeUnit.SECONDS);
		assertThat(message6).isNotNull();
		assertThat(message6.getPayload()).isInstanceOf(TokenBean.class);
		assertThat(((TokenBean) message6.getPayload()).getSurface()).isEqualTo("。");
		assertThat(((TokenBean) message6.getPayload()).getPartOfSpeechLevel1())
				.isEqualTo("記号");
	}

}
