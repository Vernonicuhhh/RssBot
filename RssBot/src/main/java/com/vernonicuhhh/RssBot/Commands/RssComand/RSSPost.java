package com.vernonicuhhh.RssBot.Commands.RssComand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.apptastic.rssreader.*;
import java.util.stream.Collectors;
import com.apptastic.rssreader.RssReader;

public class RSSPost {
    public List<Item> feed;

    public List<Item> getFeed(String URL) throws IOException {
        RssReader reader = new RssReader();
        feed = reader.read(URL)
        .collect(Collectors.toList());
        return feed;
    }

    public Item getLatestPost(String URL) throws IOException{
        RssReader reader = new RssReader();
        feed = reader.read(URL)
        .collect(Collectors.toList());
        return feed.get(0);
    }

    public String filterHTMLTag(String description){
        while(description.contains("<") || description.contains(">")){
            int start = description.indexOf("<");
            int stop = description.indexOf(">");
            String target = description.substring(start, stop+1);
            description = description.replace(target, " ");
        }
        return description;
    }

}