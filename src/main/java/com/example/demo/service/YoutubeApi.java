package com.example.demo.service;


import com.google.api.client.http.javanet.NetHttpTransport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.SearchResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

//Defining the class for YouTube api
public class YoutubeApi {
    // Defining the API key
    private static final String API_KEY = "AIzaSyB-p5tt3c6QiCByMFmvS80j52SjnjWyPpU";
    private static final String APPLICATION_NAME = "TuneTime";

    //defining serach function
    public static List<SearchResult> searchTopSongsByYear(String year) throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

        // ?
        YouTube youtube = new YouTube.Builder(httpTransport, jsonFactory, null)
                .setApplicationName(APPLICATION_NAME)
                .build();

        // here to line 42 is the search function with parametres
        String searchQuery = "Top songs " + year;

        // Define and execute the API request
        YouTube.Search.List request = youtube.search().list("snippet");
        SearchListResponse response = request.setKey(API_KEY)
                .setQ(searchQuery)
                .setMaxResults(5L)
                .execute();

        return response.getItems();
    }
}