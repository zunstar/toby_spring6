package tobyspring.hellospring.exrate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ExRageDate(String result , Map<String, BigDecimal> rates) {
}
