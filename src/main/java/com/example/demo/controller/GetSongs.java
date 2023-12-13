package com.example.demo.controller;

import com.example.demo.service.YoutubeApi;
import com.google.api.services.youtube.model.SearchResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
@RequestMapping("songs")
public class GetSongs{

    @RequestMapping(method = RequestMethod.GET, path="year/{year}")
    public String getSongs(@PathVariable String year) throws GeneralSecurityException, IOException {
        if (1970 <= Integer.parseInt(year) && Integer.parseInt(year) <= 2023) {
            List<SearchResult> result = YoutubeApi.searchTopSongsByYear(year);
            System.out.println(result);
            return result.toString();
        } else {
            return "invalid year";
        }
    }
}

