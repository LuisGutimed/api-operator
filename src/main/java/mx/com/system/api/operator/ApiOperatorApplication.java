package mx.com.system.api.operator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableElasticsearchRepositories
public class ApiOperatorApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiOperatorApplication.class, args);
  }

}
