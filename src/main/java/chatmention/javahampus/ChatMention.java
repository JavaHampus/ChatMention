/**
 * MIT License
 *
 * Copyright (c) 2021-2020 JavaHampus
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package chatmention.javahampus;

import chatmention.javahampus.Commands.ToggleMention;
import chatmention.javahampus.Events.MessageCreated;
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
        getServer().getPluginManager().registerEvents(new MessageCreated(this), this);
        getServer().getPluginManager().registerEvents(new PlayerConnection(this), this);
    }

    public DataStorage getDataStorage() {
        return dataStorage;
    }
}
