package in.rohaan;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WebServiceRequest {
    @JsonProperty("data")
    private List<WebServiceRequestDataEntry> data;

    public List<WebServiceRequestDataEntry> getData() { return data; }

    public void setData(List<WebServiceRequestDataEntry> data) { this.data = data; }
}
