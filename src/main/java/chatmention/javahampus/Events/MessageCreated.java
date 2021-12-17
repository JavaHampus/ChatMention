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

package chatmention.javahampus.Events;

import chatmention.javahampus.ChatMention;
import chatmention.javahampus.Utils.Constants;
import chatmention.javahampus.Utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
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
                Player mentioned = Bukkit.getPlayer(key);

                if(e.getMessage().contains(Constants.MENTION + mentioned.getName()) && plugin.getDataStorage().isPlayerMentionable(key)) {
                    mentioned.sendMessage(MessageUtils.prefixMessage("&cYou have been mentioned in the chat."));
                    mentioned.sendTitle(MessageUtils.colorMessage("&cYou have been mentioned"), MessageUtils.colorMessage("&cby " + p.getName()), 20, 40, 20);
                    mentioned.playSound(mentioned.getLocation(), Sound.BLOCK_GLASS_BREAK, 100, 100);
                }
            }
        }
    }
}
