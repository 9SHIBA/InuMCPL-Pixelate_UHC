package inulabs.inulab.INULab.Command;

import inulabs.inulab.INULab.API.ColorAPI;
import inulabs.inulab.INULab.Core.TimerCore;
import inulabs.inulab.INULab.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UHCCommand implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(sender instanceof Player p && p.isOp()){
            if(args.length >= 1) {
                if(args[0].equals("start")){
                    Main.UHCStart();
                    p.sendMessage(ColorAPI.Format("{RED}[UHC System]{GREEN} Started Now!!"));
                }
                if(args[0].equals("stop")){
                        Main.UHCStop();

                }
            }

            }

        return false;
    }
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> list = new ArrayList<>();
        if(args.length == 1) {
            list.add("start");
            list.add("stop");
        }

        return list;
    }
}
