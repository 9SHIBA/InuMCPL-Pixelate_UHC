package inulabs.inulab.INULab.Core;

import inulabs.inulab.INULab.API.ColorAPI;
import inulabs.inulab.INULab.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class DisplayCore {
    Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
    Objective objective = scoreboard.getObjective("uhcdisplay");
    public DisplayCore(Main main) {


            Bukkit.getScheduler().runTaskTimer(main, this::updateScoreboard, 0, 20); // Update every 10 seconds

    }



    private void updateScoreboard() {

        if (objective == null) {
            objective = scoreboard.registerNewObjective("uhcdisplay", "dummy", "INU Labs - UHC ");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        }

        objective.getScoreboard().getEntries().forEach(entry -> objective.getScoreboard().resetScores(entry));
        // Update world border size
        objective.getScore(ColorAPI.Format("--")).setScore(12);
        objective.getScore(ColorAPI.Format("{BLUE}Time {RED}: {YELLOW}"+timedisplay())).setScore(11);
        objective.getScore(ColorAPI.Format("{BLUE}Border {RED}:" + getWorldBorderSize())).setScore(10);
        objective.getScore(ColorAPI.Format("-c")).setScore(9);
        objective.getScore(ColorAPI.Format("-d")).setScore(8);
        objective.getScore(ColorAPI.Format("-e")).setScore(7);
        objective.getScore(ColorAPI.Format("-f")).setScore(6);
        objective.getScore(ColorAPI.Format("-g")).setScore(5);
      //  objective.getScore(ColorAPI.Format("Timer :")).setScore(4);
        //objective.getScore(ColorAPI.Format(Integer.toString(TimerCore.TimerData.getSeconds()) + " Seconds")).setScore(3);
        //objective.getScore(ColorAPI.Format(Integer.toString(TimerCore.TimerData.getMinutes()) + " Minutes")).setScore(2);
        //objective.getScore(ColorAPI.Format(Integer.toString(TimerCore.TimerData.getHours()) + " Hours")).setScore(1);




        // Update player health
       // for (Player player : Bukkit.getOnlinePlayers()) {
        //    objective.getScore(player.getName()).setScore((int) player.getHealth());
       // }


    }
    public static String timedisplay(){
        String time = Integer.toString(TimerCore.TimerData.getSeconds()) + ":" + Integer.toString(TimerCore.TimerData.getMinutes()) + ":" + Integer.toString(TimerCore.TimerData.getHours());
        String[] parts = time.split(":");

        // Pad each part with leading zeros if necessary
        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            // Convert each part to integer
            int value = Integer.parseInt(part);

            // Append padded part to result
            if (result.length() > 0) {
                result.append(":");
            }
            result.append(String.format("%02d", value));
        }
        return result.toString();
    }
    private String getWorldBorderSize() {
        Double size = null;
        String isNether = null;
        for (Player p: Bukkit.getOnlinePlayers()
             ) {
        World world = p.getWorld();
            if(world.getName().equals("world")){
                size =  p.getWorld().getWorldBorder().getSize();
                isNether = " {YELLOW}({GREEN}☀{YELLOW})";
            } else {
                if(world.getEnvironment() == World.Environment.NETHER){
                    size = p.getWorld().getWorldBorder().getSize();
                    isNether = " {YELLOW}({RED}🛑{YELLOW})";
                } else {
                    size = (double) 0;
                    isNether = " {RED}-";
                }

            }

        }

        return Double.toString(size) + isNether;
    }

}
