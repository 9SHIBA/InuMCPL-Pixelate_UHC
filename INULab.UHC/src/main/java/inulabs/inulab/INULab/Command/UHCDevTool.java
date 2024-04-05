package inulabs.inulab.INULab.Command;

import inulabs.inulab.INULab.API.ColorAPI;
import inulabs.inulab.INULab.Core.TimerCore;
import inulabs.inulab.INULab.Core.WorldBorderCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class UHCDevTool implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(sender instanceof Player p && p.isOp()){
            if(args.length >= 1) {
                if(args[0].equals("timer")) {
                    if(args[1].equals("second") ){
                        TimerCore.TimerData.setSeconds(Integer.valueOf(args[2]));
                    }

                    if(args[1].equals("minutes") ) {
                        TimerCore.TimerData.setMinutes(Integer.valueOf(args[2]));
                    }
                    if(args[1].equals("hour") ) {
                        TimerCore.TimerData.setHours(Integer.valueOf(args[2]));
                    }

                }
                if (args[0].equals("border")){
                    if(args[1].equals("nether")){

                    }
                    if(args[1].equals("overworld")){

                        WorldBorderCore.setWorldBorderSize(Integer.valueOf(args[2]),Integer.valueOf(args[3]));
                        p.sendMessage(ColorAPI.Format("{RED}[UHC System]{GREEN} - Set WorldBorder to " + args[2] + " in " + args[3] +" minutes"));
                    }
                }
            }
        }
        return false;
    }


    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> list = new ArrayList<>();
        if (args.length == 1){
            list.add("timer");
            list.add("border");
        }
        if (args[0].equals("timer")){
            if(args.length == 2)
            {
                list.add("minutes");
                list.add("second");
                list.add("hour");
            }
        }
        if(args[0].equals("border")){
            list.add("nether");
            list.add("overworld");
        }
        return list;
    }
}
