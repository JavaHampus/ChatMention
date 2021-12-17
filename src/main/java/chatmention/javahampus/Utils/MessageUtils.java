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

package chatmention.javahampus.Utils;

import chatmention.javahampus.ChatMention;
import org.bukkit.ChatColor;

public class MessageUtils {

    ChatMention plugin;

    public ChatMention getPlugin() {
        return plugin;
    }

    /**
     * @param msg message to be sent.
     * @return color translated message.
     */
    public static String colorMessage(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    /**
     * Used for sending messages with plugin prefix.
     *
     * @param msg
     * @return color translated message with plugin prefix.
     */
    public static String prefixMessage(String msg) {
        return colorMessage(Constants.PLUGIN_PREFIX + msg);
    }
}
