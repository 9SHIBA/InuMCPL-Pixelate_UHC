package inulabs.inulab.INULab;

import inulabs.inulab.INULab.API.ColorAPI;
import inulabs.inulab.INULab.Command.UHCCommand;
import inulabs.inulab.INULab.Command.UHCDevTool;
import inulabs.inulab.INULab.Core.DisplayCore;
import inulabs.inulab.INULab.Core.TimerCore;
import org.bukkit.BlockChangeDelegate;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import static inulabs.inulab.INULab.Core.TimerCore.scheduledTask;

public final class Main extends JavaPlugin {

    public static HashMap<String, Boolean> uhcstage = new HashMap<>();
    @Override
    public void onEnable() {
        //-------------- Command Registry -----------------------\\
        Objects.requireNonNull(this.getCommand("uhc")).setExecutor(new UHCCommand());
        Objects.requireNonNull(this.getCommand("uhcdev")).setExecutor(new UHCDevTool());

        //-------------- <Object Registry> ---------------------\\
        new DisplayCore(this);
        uhcstage.put("start",false);


        //     <TEST ArEA>   \\
        for (Player p: Bukkit.getOnlinePlayers()
             ) {
            System.out.print(p.getWorld().getName());
        }

    }

    public static void UHCStart() {
        if(uhcstage.get("start") != null){

             if(uhcstage.get("start") == false){
               uhcstage.put("start",true);
                new TimerCore();
        } else {
            for (Player p: Bukkit.getOnlinePlayers()) {
                p.sendMessage(ColorAPI.Format("{RED}[UHC System]{YELLOW} is Already Started"));
            }
        }
        }else {
            uhcstage.put("start",false);
        }
    }
    public static void UHCStop()  {
        uhcstage.put("start",false);
        for (Player p: Bukkit.getOnlinePlayers()) {
            p.sendMessage(ColorAPI.Format("{RED}[UHC System]{YELLOW} Force Stop!!"));
            p.playSound(p, Sound.ENTITY_ENDER_DRAGON_DEATH,100,100);
        }
        TimerCore.cancelTask();
    }


    @Override
    public void onDisable() {

            UHCStop();

    }
}
