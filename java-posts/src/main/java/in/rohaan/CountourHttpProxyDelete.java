package in.rohaan;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Code for https://stackoverflow.com/questions/68032970/deleting-contour-httpproxy-from-kubernetes-namespace-using-java-client/68045301#68045301
 */ 
public class CountourHttpProxyDelete {
    private static final Logger logger = LoggerFactory.getLogger(CountourHttpProxyDelete.class.getSimpleName());

    public static void main(String[] args) {
try (KubernetesClient client = new DefaultKubernetesClient()) {
    CustomResourceDefinitionContext context = new CustomResourceDefinitionContext.Builder()
            .withKind("HTTPProxy")
            .withPlural("httpproxies")
            .withGroup("projectcontour.io")
            .withVersion("v1")
            .withScope("Namespaced")
            .build();

    boolean isDeleted = client.customResource(context).inNamespace("default").withName("root").delete();
    if (!isDeleted) {
        logger.warn("Unable to Delete HTTPProxy {} in {} namespace", "root", "default");
    }
    logger.info("HTTPProxy {} successfully deleted.", "root");
} catch (KubernetesClientException exception) {
    logger.error("Exception in interacting with Kubernetes API", exception);
}
    }
}
