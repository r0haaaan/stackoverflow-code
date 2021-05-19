package in.rohaan;

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

/*
 * Code for https://stackoverflow.com/questions/67586863
 */ 
public class OverrideKubeConfigFabric8 {
    public static void main(String[] args) {
        System.setProperty("kubeconfig", "/tmp/mykubeconfig");
        try (KubernetesClient kubernetesClient = new DefaultKubernetesClient()) {
            kubernetesClient.pods().inAnyNamespace().list().getItems().stream()
                    .map(Pod::getMetadata)
                    .map(ObjectMeta::getName)
                    .forEach(System.out::println);
        }
    }
}
