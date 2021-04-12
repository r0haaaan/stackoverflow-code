package in.rohaan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Code for https://stackoverflow.com/questions/67059625
 */ 
public class JacksonAnnotationsData {
    private static class Policy {
        private final String policyOwnerName;
        private final String policyNumber;

        public Policy(String ownerName, String number) {
            this.policyOwnerName = ownerName;
            this.policyNumber = number;
        }

        public String getPolicyOwnerName() { return this.policyOwnerName; }

        public String getPolicyNumber() { return this.policyNumber; }
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        WebServiceRequest webServiceRequest = new WebServiceRequest();

        Policy[] policies = new Policy[] { new Policy("User1", "12345")};

        List<WebServiceRequestDataEntry> data = new ArrayList<>();
        for (Policy p : policies) {
            data.add(new WebServiceRequestDataEntry("Pol_OwnerName", p.getPolicyOwnerName()));
            data.add(new WebServiceRequestDataEntry("Pol_Number", p.getPolicyNumber()));
        }
        webServiceRequest.setData(data);

        System.out.println(objectMapper.writeValueAsString(webServiceRequest));
    }
}
