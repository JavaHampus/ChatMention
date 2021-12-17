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

package chatmention.javahampus.Commands;

import chatmention.javahampus.ChatMention;
import org.bukkit.ChatColor;
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
            p.sendMessage();
            return true;
        }

        if(plugin.getDataStorage().isPlayerMentionable(p.getUniqueId())) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', (String) plugin.getConfig().get("prefix") + plugin.getConfig().get("disableMessage")));
            plugin.getDataStorage().setPlayerMentionable(p.getUniqueId(), false);

        } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', (String) plugin.getConfig().get("prefix") + plugin.getConfig().get("enableMessage")));
            plugin.getDataStorage().setPlayerMentionable(p.getUniqueId(), true);
        }

        return true;
    }
}
