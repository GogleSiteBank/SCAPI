import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

/*
SCAPI by COnnOrZeUs
 */

public class SCAPI {
    ScoreboardManager mgr = Bukkit.getScoreboardManager();
    Scoreboard scr = mgr.getNewScoreboard();
    Objective obj = scr.registerNewObjective("SCAPI-obj", "dummy", "SCAPI");
    Team t = scr.registerNewTeam("SCAPI-team");
    public void setobj(Objective obj) {
        this.obj = obj;
    }

    public boolean checkplr(Player plr) {
        if (t.hasEntry(plr.getName())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addplr(Player plr) {
        if (!t.hasEntry(plr.getName())) {
            t.addEntry(plr.getName());
            return true;
        } else {
            return false;
        }
    }

    public boolean removeplr(Player plr) {
        if (t.hasEntry(plr.getName())) {
            t.removeEntry(plr.getName());
            return true;
        } else {
            return false;
        }
    }

    public boolean setglobalprefix(String prefix) {
        t.setPrefix(ChatColor.translateAlternateColorCodes('&', prefix));
        return true;
    }

    public boolean setdisplay(String display) {
        t.setPrefix(ChatColor.translateAlternateColorCodes('&', display));
        return true;
    }

    public boolean InvisibleSee(boolean cansee) {
        t.setCanSeeFriendlyInvisibles(cansee);
        return true;
    }

    public boolean friendlyfire(boolean allow) {
        t.setAllowFriendlyFire(allow);
        return true;
    }

    public boolean settitle(String title) {
        obj.setDisplayName(ChatColor.translateAlternateColorCodes('&', title));
        return true;
    }

    public boolean setdisplayslot(DisplaySlot slot) {
        obj.setDisplaySlot(slot);
        return true;
    }

    public boolean createscore(String name, int l) {
        Score scr = obj.getScore(ChatColor.translateAlternateColorCodes('&', name));
        scr.setScore(l);
        return true;
    }


    public boolean updatescoreboard(Player plr) {
        plr.setScoreboard(scr);
        return true;
    }

    public boolean removescoreboard(Player plr) {
        plr.setScoreboard(mgr.getNewScoreboard());
        return true;
    }
}
