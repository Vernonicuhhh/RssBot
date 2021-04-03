package com.vernonicuhhh.RssBot.Commands.RssComand;

import java.io.IOException;

import com.apptastic.rssreader.Item;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.EmbedBuilder;

public class rsscommand extends Command {
RSSPost post = new RSSPost();
    public rsscommand(){
        this.name = "glp";
        this.help = "gets the latest post from a give rss feed (ie: !!glp *rss feed URL*)";
        this.cooldown = 5;
    }
    @Override
    protected void execute(CommandEvent event) {
        String [] message = event.getMessage().getContentRaw().split(" ");
        if (message.length == 2) {
            try {
                Item retrievedPost = post.getLatestPost(message[1]);
                EmbedBuilder embed = new EmbedBuilder();
                embed.setTitle(retrievedPost.getTitle().get());
                if(post.filterHTMLTag(retrievedPost.getDescription().get()).length()<1024)
                    embed.setDescription(post.filterHTMLTag(retrievedPost.getDescription().get()));
                embed.setThumbnail("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2FPh5XrZvJwWI%2Fmaxresdefault.jpg&f=1&nofb=1");
                embed.addField("Link", retrievedPost.getLink().get(),true);
                embed.addField("Date", retrievedPost.getPubDate().get(),true);
                event.reply(embed.build());
            }
             catch (IOException e) {
                event.reply("invalid URL");
            }
    }
    
}
}
