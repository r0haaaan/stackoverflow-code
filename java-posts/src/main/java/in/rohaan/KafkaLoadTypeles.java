package in.rohaan;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class KafkaLoadTypeles {
    public static void main(String[] args) {
        try (KubernetesClient client = new DefaultKubernetesClient()) {
            CustomResourceDefinitionContext context = new CustomResourceDefinitionContext.Builder()
                    .withScope("Namespaced")
                    .withVersion("v1beta2")
                    .withGroup("kafka.strimzi.io")
                    .withPlural("kafkas")
                    .build();

            InputStream is = KafkaLoadTypeles.class.getResourceAsStream("/test-kafka.yml");

            Map<String, Object> createdKafka = client.customResource(context).inNamespace("default").createOrReplace(is);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
