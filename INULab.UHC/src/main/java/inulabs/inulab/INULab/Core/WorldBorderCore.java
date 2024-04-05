package inulabs.inulab.INULab.Core;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;

public class WorldBorderCore {
    public static void setWorldBorderSize(int size,int time) {
        World world = Bukkit.getServer().getWorld("world"); // Assuming the command is executed in the first loaded world
        if (world != null) {

            world.getWorldBorder().setSize(size,TimeUnit.MINUTES,time);

            for (Player p: Bukkit.getOnlinePlayers()
            ) {
                p.sendMessage("WorldBorder set to " + size);

            }
        } else {
            for (Player p: Bukkit.getOnlinePlayers()
            ) {
                p.sendMessage("Unable to get world!");

            }
        }
    }
    public static void setNetherWorldBorderSize( String worldName, int size) {
        World world = Bukkit.getWorld(worldName);
        if (world != null && world.getEnvironment() == World.Environment.NETHER) {
            world.getWorldBorder().setSize(size, TimeUnit.MINUTES,1);

            //.sendMessage("Nether world border size set to " + size);
        } else {
            //sender.sendMessage("Nether world '" + worldName + "' not found!");
        }
    }
}
