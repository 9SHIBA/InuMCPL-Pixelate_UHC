package inulabs.inulab.INULab.Core;

import inulabs.inulab.INULab.API.ColorAPI;
import inulabs.inulab.INULab.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class TimerCore {



    public static ScheduledFuture<?> scheduledTask;

        public TimerCore(){
            //READ ME:? warning this system will error when Server is Reloading And need to Restart Game\\

            //------------ <ScoreBoard Timer Not FOr system> -----------------\\
           startTimer();

            //------------ <System Timer Not Show in ScoreBoard> <RELOAD THIS SYSTEMWILL ERORR> --------------\\
//            scheduledTask = TaskScheduler.scheduleTask(10, TimeUnit.SECONDS, () -> {
//                     for (Player player : Bukkit.getOnlinePlayers()) {
//                          sendTitleMessage(player, "Started Now", "kai tham", 20, 40, 20);
//                         player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP,100,100);
//                       player.sendMessage(ColorAPI.Format("{GREEN}World boarder set to 2000 x 2000"));
//
//                       WorldBorderCore.setWorldBorderSize(20);
//                    }
//
//            });


            WorldBorderCore.setWorldBorderSize(2000,1);
        }








    public void sendTitleMessage(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        player.sendTitle(title, subtitle, fadeIn, stay, fadeOut);
    }

    public static void cancelTask()  {
//            System.out.print(scheduledTask.toString());
//        if (scheduledTask != null) {
//            scheduledTask.cancel(true);
//            TaskScheduler.shutdown();
//
//        }else {
//            for (Player p : Bukkit.getOnlinePlayers()
//                 ) {
//                p.sendMessage("fuck error");
//            }
//        }
    }


    public void test() {
        for (Player p :Bukkit.getOnlinePlayers() ) {
            p.sendMessage(ColorAPI.Format("{YELLOW}is 10 second test!!"));
        }
    }
    public static void startTimer() {
        Timer timer = new Timer();
        TimerData timerData = new TimerData(0, 0, 0);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(Main.uhcstage.get("start")){
                    timerData.increment();
                }else {
                    new TimerData(0,0,0);
                    cancel();
                }


               // System.out.println(timerData);
            }
        }, 0, 1000); // 1000 milliseconds = 1 second
    }

    public static class TimerData {
        private static int seconds;
        private static int minutes;
        private static int hours;

        public TimerData(int hours, int minutes, int seconds) {
            this.seconds = seconds;
            this.minutes = minutes;
            this.hours = hours;
        }
        public void increment() {
            seconds++;
            if (seconds >= 60) {
                seconds = 0;
                minutes++;
                if (minutes >= 60) {
                    minutes = 0;
                    hours++;
                }
            }
        }
        public static void setSeconds(int value){
            seconds = value;
        }
        public static void setMinutes(int value){
            minutes = value;
        }
        public static void setHours(int value){
            hours = value;
        }
        public static int getSeconds() {
            return seconds;
        }

        public static int getMinutes() {
            return minutes;
        }

        public static int getHours() {
            return hours;
        }
        }

}
