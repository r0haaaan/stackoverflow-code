package in.rohaan;

import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.strimzi.api.kafka.model.Kafka;

import java.io.InputStream;

public class KafkaLoadTyped {
    public static void main(String[] args) {
        try (KubernetesClient client = new DefaultKubernetesClient()) {
            MixedOperation<Kafka, KubernetesResourceList<Kafka>, Resource<Kafka>> kafkaClient = client.customResources(Kafka.class);

            InputStream is = KafkaLoadTyped.class.getResourceAsStream("/test-kafka.yml");
            Kafka myClusterkafka = kafkaClient.load(is).get();
            kafkaClient.inNamespace("default").createOrReplace(myClusterkafka);
        }
    }
}
