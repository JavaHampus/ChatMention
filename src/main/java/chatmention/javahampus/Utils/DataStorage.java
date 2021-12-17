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

import java.util.HashMap;
import java.util.UUID;

public class DataStorage {

    private HashMap<UUID, Boolean> mentionStatus = new HashMap<>();

    public HashMap<UUID, Boolean> getMentionStatus() {
        return mentionStatus;
    }

    /**
     * Checks if player is mentionable in chat or not.
     *
     * @param uuid the player unique id.
     * @return boolean from key value in HashMap.
     */
    public boolean isPlayerMentionable(UUID uuid) {
        return mentionStatus.get(uuid);
    }

    /**
     * Checks if mentionsStatus HashMap contains key.
     *
     * @param uuid the player unique id.
     * @return boolean if key exists in HashMap.
     */
    public boolean containsPlayerKey(UUID uuid) {
        return mentionStatus.containsKey(uuid);
    }

    /**
     * Sets the value for a key in the mentionsStatus HashMap.
     *
     * @param uuid the player unique id.
     * @param bool set player mentionable to a boolean.
     */
    public void setPlayerMentionable(UUID uuid, Boolean bool) {
        mentionStatus.replace(uuid, bool);
    }

    /**
     * Creates key in mentionsStatus HashMap for a player.
     *
     * @param uuid the player unique id.
     */
    public void createPlayerKey(UUID uuid) {
        mentionStatus.put(uuid, true);
    }
}
