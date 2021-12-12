package chatmention.javahampus.Events;

import chatmention.javahampus.ChatMention;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerConnection implements Listener {

    ChatMention plugin;

    public PlayerConnection(ChatMention plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerConnection(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if(!plugin.getDataStorage().containsPlayerKey(p.getUniqueId())) {
            plugin.getDataStorage().createPlayerKey(p.getUniqueId());
        }
    }
}
