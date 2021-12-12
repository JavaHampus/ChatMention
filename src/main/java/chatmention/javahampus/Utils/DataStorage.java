package chatmention.javahampus.Utils;

import java.util.HashMap;
import java.util.UUID;

public class DataStorage {

    private HashMap<UUID, Boolean> mentionStatus = new HashMap<>();

    public HashMap<UUID, Boolean> getMentionStatus() {
        return mentionStatus;
    }

    public boolean isPlayerMentionable(UUID uuid) {
        return mentionStatus.get(uuid);
    }

    public boolean containsPlayerKey(UUID uuid) {
        return mentionStatus.containsKey(uuid);
    }

    public void setPlayerMentionable(UUID uuid, Boolean bool) {
        mentionStatus.replace(uuid, bool);
    }

    public void createPlayerKey(UUID uuid) {
        mentionStatus.put(uuid, true);
    }
}
