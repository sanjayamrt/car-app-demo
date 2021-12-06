package com.example.car.app.demo.carappdemo.service;

import com.example.car.app.demo.carappdemo.dto.QuotesFromDataMuseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class ModelQuoteServiceImpl implements  ModelQuoteService {

    @Autowired
    private RestTemplate restClient;

    @Value("${datamuse.url}")
    private String dataMuseUrl;

    @Override
    public String generateQuoteForModel(String model) {
        String urlToRetreiveQuoteForModel = dataMuseUrl + "words?ml=" + model;
        System.out.println(urlToRetreiveQuoteForModel);
        QuotesFromDataMuseDTO[] wordsFromDataMuse =
                restClient.getForObject(urlToRetreiveQuoteForModel , QuotesFromDataMuseDTO[].class);
        if (!Objects.isNull(wordsFromDataMuse) && wordsFromDataMuse.length > 0) {
            return wordsFromDataMuse[0].getWord();
        }

        return "";
    }
}
