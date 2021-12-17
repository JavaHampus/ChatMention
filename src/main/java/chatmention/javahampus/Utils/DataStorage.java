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
