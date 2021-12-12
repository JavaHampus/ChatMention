package chatmention.javahampus.Commands;

import chatmention.javahampus.ChatMention;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ToggleMention implements CommandExecutor {

    private final ChatMention plugin;

    public ToggleMention(ChatMention plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(!(sender instanceof Player)) return true;

        Player p = (Player) sender;

        if(!plugin.getDataStorage().containsPlayerKey(p.getUniqueId())) {
            p.sendMessage("Message --");
            return true;
        }

        if(plugin.getDataStorage().isPlayerMentionable(p.getUniqueId())) {
            plugin.getDataStorage().setPlayerMentionable(p.getUniqueId(), false);

        } else {
            plugin.getDataStorage().setPlayerMentionable(p.getUniqueId(), true);

        }
        p.sendMessage("Message --");

        return true;
    }
}
