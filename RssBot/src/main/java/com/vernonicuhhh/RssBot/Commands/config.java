package com.vernonicuhhh.RssBot.Commands;
import io.github.cdimascio.dotenv.Dotenv;

public class config {
    private static final Dotenv DOTENV = Dotenv.load();
    public static String get(String key){
        return DOTENV.get(key);
    }

    
}
