package inulabs.inulab.INULab.Core;

import inulabs.inulab.INULab.Main;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimeCore {


    public GameTimeCore(Main main){
        new BukkitRunnable() {
            @Override
            public void run() {

            }
        }.runTaskTimer(main,10,10);
    }




}
