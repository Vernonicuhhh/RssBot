package com.vernonicuhhh.RssBot;

import javax.security.auth.login.LoginException;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.vernonicuhhh.RssBot.Commands.shutdown;
import com.vernonicuhhh.RssBot.Commands.RssComand.rsscommand;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Bot {
          public static void main(String[] args) throws Exception{
            JDA jda =  JDABuilder.createDefault(System.getenv("BOT_TOKEN")).build();
            CommandClientBuilder builder = new CommandClientBuilder();
            builder.setOwnerId(System.getenv("OWNER"));
            builder.setPrefix(System.getenv("PREFIX"));
            builder.setHelpWord("helpme");
            builder.setActivity(Activity.watching("your mom"));
            builder.addCommand(new rsscommand());
            builder.addCommand(new shutdown());
            CommandClient client = builder.build();
            jda.addEventListener(client);    
        
    }
}
