package chatmention.javahampus.Events;

import chatmention.javahampus.ChatMention;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;

public class MessageCreated implements Listener {

    ChatMention plugin;

    public MessageCreated(ChatMention plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMessageCreate(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        for(UUID key : plugin.getDataStorage().getMentionStatus().keySet()) {
            if(Bukkit.getPlayer(key) != null) {
                if(e.getMessage().contains(Bukkit.getPlayer(key).getName()) && plugin.getDataStorage().isPlayerMentionable(key)) {
                    Bukkit.getPlayer(key).sendMessage("You have been mentioned in the chat.");
                }
            }
        }
    }
}
