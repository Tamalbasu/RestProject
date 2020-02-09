package com.Think.project.service;

import com.Think.project.bean.Movie;
import com.Think.project.dao.FetchAllMovieList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {


    public List<Movie> fetchMovie(String movieList){
        FetchAllMovieList fetchAllMovieList = new FetchAllMovieList();
        List<String> movie= Arrays.asList(movieList.split(","));
        List<String> data=new ArrayList<>();
        movie.forEach(lis -> data.add(fetchAllMovieList.movieDetails(lis)));

        return parsing(data);
    }
    private List<Movie> parsing(List<String> data ){
        Gson gson=new Gson();
        List<Movie> lst=new ArrayList<>();
        data.forEach(data1->{JsonObject ar=gson.fromJson(data1, JsonObject.class);

        Movie movie= new Movie();
        movie.setTitle(ar.getAsJsonObject("parse").getAsJsonPrimitive("title").getAsString());
        String html=ar.getAsJsonObject("parse").getAsJsonObject("text").getAsJsonPrimitive("*").getAsString();
        htmlParsercode(html,movie);
        lst.add(movie);
        });

        return lst;
    }
    private Movie htmlParsercode(String html,Movie movie){

        Document doc = Jsoup.parse(html);
        for (Element table : doc.select("table")) {
            for (Element row : table.select("tr")) {
                Elements th = row.select("th");
                Elements tds = row.select("td");
                if(th.text().equals("Directed by")){

                    movie.setDirector(tds.text());
                }
                if(th.text().equals("Produced by")){
                    movie.setProducer(tds.text());
                }
                if(th.text().equals("Starring")){
                    movie.setActors(tds.text());
                }
                if(th.text().equals("Music by")){
                    movie.setMusic_composer(tds.text());
                }if(th.text().equals("Production companies")){
                    movie.setProduction_house(tds.text());
                }
                if(th.text().equals("Release date")){
                    movie.setRelease_Date(tds.text());
                }
                if(th.text().equals("Running time")){
                    movie.setDuration(tds.text());
                }
                if(th.text().equals("Language")){
                    movie.setLanguage(tds.text());
                }
                if(th.text().equals("Budget")){
                    movie.setBudget(tds.text());
                }
                if(th.text().equals("Box office")){
                    movie.setBox_Office_Collection(tds.text());
                }


            }
        }

        return movie;
    }

}
