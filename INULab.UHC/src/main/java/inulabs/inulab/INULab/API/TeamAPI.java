package inulabs.inulab.INULab.API;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TeamAPI{
    public static void createTeam(String teamName) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getTeam(teamName);

        if (team == null) {
            team = scoreboard.registerNewTeam(teamName);
            team.setDisplayName("Example Team"); // Set display name
            team.setPrefix(ColorAPI.Format("{YELLOW}[{"+teamName.toUpperCase()+"}"+"{YELLOW}]")); // Set prefix
        }
    }

    public static void addPlayerToTeam(Player player, String teamName) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getTeam(teamName);
        if (team != null) {
            team.addEntry(player.getName());
        }
    }
    public void spreadPlayersByTeam() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        for (Team team : scoreboard.getTeams()) {
            spreadPlayers(team.getName());
        }
    }

    // Method to spread players of a specific team
    private void spreadPlayers(String teamName) {
        Team team = Bukkit.getScoreboardManager().getMainScoreboard().getTeam(teamName);
        if (team != null) {
            Location center = Bukkit.getWorlds().get(0).getSpawnLocation(); // Center point for spreading
            int spreadDistance = 100; // Spread distance in blocks

            for (String entry : team.getEntries()) {
                Player player = Bukkit.getPlayer(entry);
                if (player != null) {
                    Location randomLocation = getRandomLocation(center, spreadDistance);
                    player.teleport(randomLocation);
                }
            }
        }
    }

    // Method to get a random location around a center point within a specified radius
    private Location getRandomLocation(Location center, int radius) {
        double angle = Math.random() * Math.PI * 2; // Random angle in radians
        double distance = Math.random() * radius; // Random distance from center

        double xOffset = Math.cos(angle) * distance;
        double zOffset = Math.sin(angle) * distance;

        return center.clone().add(xOffset, 0, zOffset);
    }
}
