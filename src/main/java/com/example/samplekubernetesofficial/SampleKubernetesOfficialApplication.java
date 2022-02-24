package com.example.samplekubernetesofficial;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SampleKubernetesOfficialApplication {

    @Bean
    CoreV1Api coreV1Api(ApiClient client) {
        return new CoreV1Api(client);
    }

    @Bean
    ApplicationRunner runner(CoreV1Api client) {
        return args ->
                client.listPodForAllNamespaces(
                                false, null, null, null,
                                null, null, null, null,
                                -1, false)
                        .getItems()
                        .forEach(System.out::println);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleKubernetesOfficialApplication.class, args);
    }

}
