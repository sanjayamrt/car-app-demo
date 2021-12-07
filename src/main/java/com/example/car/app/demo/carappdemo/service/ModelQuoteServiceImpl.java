package com.example.car.app.demo.carappdemo.service;

import com.example.car.app.demo.carappdemo.dto.QuotesFromDataMuseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class ModelQuoteServiceImpl implements  ModelQuoteService {

    Logger logger = LoggerFactory.getLogger(ModelQuoteServiceImpl.class);

    @Autowired
    private RestTemplate restClient;

    @Value("${datamuse.url}")
    private String dataMuseUrl;

    @Override
    public String generateQuoteForModel(String model) {
        String urlToRetreiveQuoteForModel = dataMuseUrl + "words?ml=" + model;
        logger.info("OUTGOING Request to " + urlToRetreiveQuoteForModel);
        QuotesFromDataMuseDTO[] wordsFromDataMuse =
                restClient.getForObject(urlToRetreiveQuoteForModel , QuotesFromDataMuseDTO[].class);
        String word = "";
        if (!Objects.isNull(wordsFromDataMuse) && wordsFromDataMuse.length > 0) {
            word = wordsFromDataMuse[0].getWord();
            logger.info("INCOMING  Response - Selected Word " + word);
        }
        return word;
    }
}
