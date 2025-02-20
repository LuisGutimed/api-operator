package mx.com.system.api.operator.config;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

@Configuration
@Slf4j
public class ElasticsearchConfig extends ElasticsearchConfiguration {

  @Value("${elasticsearch.host}")
  private String host;

  @Value("${elasticsearch.user}")
  private String user;

  @Value("${elasticsearch.pass}")
  private String pass;


  @Override
  public ClientConfiguration clientConfiguration() {
    return ClientConfiguration.builder()
        .connectedTo(host)
        .usingSsl()
        .withConnectTimeout(Duration.ofSeconds(5))
        .withSocketTimeout(Duration.ofSeconds(3))
        .withBasicAuth(user, pass)
        .build();
  }
}
