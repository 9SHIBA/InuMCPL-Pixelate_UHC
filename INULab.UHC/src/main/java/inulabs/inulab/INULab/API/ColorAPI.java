package inulabs.inulab.INULab.API;

import org.bukkit.ChatColor;

public class ColorAPI {
    public static String Format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg.replace("{BLACK}", "&0").replace("{DARK_BLUE}", "&1").replace("{DARK_GREEN}", "&2").replace("{DARK_AQUA}", "&3").replace("{DARK_RED}", "&4").replace("{DARK_PURPLE}", "&5").replace("{GOLD}", "&6").replace("{GRAY}", "&7").replace("{DARK_GRAY}", "&8").replace("{BLUE}", "&9").replace("{GREEN}", "&a").replace("{AQUA}", "&b").replace("{RED}", "&c").replace("{LIGHT_PURPLE}", "&d").replace("{YELLOW}", "&e").replace("{WHITE}", "&f").replace("{BOLD}", "&l").replace("{B}", "&l").replace("{U}", "&n").replace("{I}", "&o").replace("{RESET}", "&r").replace("{N}", "\n").replace("{S}", " "));
    }
}
