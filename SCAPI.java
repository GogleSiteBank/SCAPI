package PACKAGEHERE;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/*
SCAPI by COnnOrZeUs
 */

public class SCAPI {
    ScoreboardManager mgr = Bukkit.getScoreboardManager();
    Scoreboard scr;

    {
        assert mgr != null;
        scr = mgr.getNewScoreboard();
    }

    Objective obj = scr.registerNewObjective("SCAPI-obj", "dummy", "SCAPI");
    Team t = scr.registerNewTeam("SCAPI-team");

    public static ArrayList<UUID> array = new ArrayList<>();

    public void setScoreObjective(Objective obj) {
        this.obj = obj;
    }

    public boolean checkPlayer(Player plr) {
        return array.contains(plr.getUniqueId());
    }


    public void addPlayer(Player plr) {
        t.addEntry(plr.getName());
        array.add(plr.getUniqueId());
    }

    public void removePlayer(Player plr) {
        t.removeEntry(plr.getName());
        array.remove(plr.getUniqueId());
    }


    public void setGlobalPrefix(String prefix) {
        t.setPrefix(ChatColor.translateAlternateColorCodes('&', prefix));
    }

    public void invisibleSee(boolean cansee) {
        t.setCanSeeFriendlyInvisibles(cansee);
    }

    public void friendlyFire(boolean allow) {
        t.setAllowFriendlyFire(allow);
    }

    public void setTitle(String title) {
        obj.setDisplayName(ChatColor.translateAlternateColorCodes('&', title));
    }

    public void setDisplaySlot(DisplaySlot slot) {
        obj.setDisplaySlot(slot);
    }

    public void createScore(String name, int l) {
        Score scr = obj.getScore(ChatColor.translateAlternateColorCodes('&', name));;
        scr.setScore(l);
    }

    public void removeScore(String name) {
        scr.resetScores(name);
    }

    public Set<String> getEntries() {
        return scr.getEntries();
    }

    public void resetEntries(String entry) {
        scr.resetScores(entry);
    }

    public void updateScoreboard(Player plr) {
        plr.setScoreboard(scr);
    }

    public void removeScoreboard(Player plr) {
        plr.setScoreboard(Objects.requireNonNull(Bukkit.getScoreboardManager()).getNewScoreboard());
    }

}
