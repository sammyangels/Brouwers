package be.vdab.restclients;

import be.vdab.exceptions.KanTemperatuurNietLezenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
class OpenWeatherMapClient implements WeerClient {
    private static final Logger LOGGER = Logger.getLogger(OpenWeatherMapClient.class.getName());
    private final String uriTemplate;
    private final RestTemplate restTemplate;

    @Autowired
    OpenWeatherMapClient(@Value("${openWeatherMapURL}") String uriTemplate, RestTemplate restTemplate) {
        this.uriTemplate = uriTemplate;
        this.restTemplate = restTemplate;
    }

    @Override
    public BigDecimal getTemperatuur(String plaats) {
        try {
            return restTemplate.getForObject(uriTemplate, Current.class, plaats).temperature.value;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "kan temperatuur niet lezen", ex);
            throw new KanTemperatuurNietLezenException();
        }
    }
}
