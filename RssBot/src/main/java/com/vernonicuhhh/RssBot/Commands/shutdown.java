package com.vernonicuhhh.RssBot.Commands;

import java.util.logging.Logger;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class shutdown extends Command {
    public shutdown(){
        this.name = "shutdown";
        this.help = "Shuts down the bot. Only avaible to owner";
    }

    @Override
    protected void execute(CommandEvent event) {
        if(event.getAuthor().getId().equalsIgnoreCase(config.get("OWNER_ID"))){
            System.out.println("shutting down...");
            event.getJDA().shutdownNow();
        }
    }

    
    
}
