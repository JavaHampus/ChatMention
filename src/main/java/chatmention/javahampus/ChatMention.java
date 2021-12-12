package chatmention.javahampus;

import chatmention.javahampus.Commands.ToggleMention;
import chatmention.javahampus.Events.PlayerConnection;
import chatmention.javahampus.Utils.DataStorage;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatMention extends JavaPlugin {

    DataStorage dataStorage;


    @Override
    public void onEnable() {
        dataStorage = new DataStorage();

        registerCommands();
        registerEvents();

        getLogger().info("This server is using ChatMention developed by JavaHampus.");
    }

    private void registerCommands() {
        getCommand("togglemention").setExecutor(new ToggleMention(this));
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new PlayerConnection(this), this);
    }

    public DataStorage getDataStorage() {
        return dataStorage;
    }
}
