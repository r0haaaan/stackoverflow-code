package in.rohaan;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebServiceRequestDataEntry {
    @JsonProperty("field")
    private String field;
    @JsonProperty("value")
    private String value;

    public WebServiceRequestDataEntry(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public String getField() { return field; }

    public void setField(String field) { this.field = field; }

    public String getValue() { return value; }

    public void setValue(String value) { this.value = value; }
}
