package main.command.impl;

import main.Utils.Github;
import main.command.CommandContext;
import main.command.ICommand;
import net.dv8tion.jda.api.JDA;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

public class PingCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        JDA jda = ctx.getJDA();

        jda.getRestPing().queue(
                (ping) -> ctx.getChannel()
                        .sendMessageFormat("Reset ping: %sms\nWS ping: %sms", ping, jda.getGatewayPing()).queue()
        );
    }

    @Override
    public String getHelp() {
        return "Zeigt den aktuellen Ping des Bots zu den Discord Servern";
    }

    @Override
    public String getName() {
        return "ping";
    }
}
