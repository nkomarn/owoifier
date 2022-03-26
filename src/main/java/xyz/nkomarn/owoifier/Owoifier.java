package xyz.nkomarn.owoifier;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.nkomarn.owoifier.util.Owoification;

import java.util.Random;

public class Owoifier extends JavaPlugin implements Listener {

    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onAsyncChat(AsyncPlayerChatEvent event) {
        final Player p = event.getPlayer();
        if((p.hasPermission("owoifier.use.chat") && getConfig().getBoolean("use_perms"))||!getConfig().getBoolean("use_perms")) {
            final Random random = new Random();
            final String expression = Owoification.EXPRESSIONS[random.nextInt(Owoification.EXPRESSIONS.length)];
            event.setMessage(Owoification.owoify(event.getMessage()) + " " + expression);
        }
    }

    @EventHandler
    public void onSignChange(SignChangeEvent event) {
        final Player p = event.getPlayer();
        if((p.hasPermission("owoifier.use.sign") && getConfig().getBoolean("use_perms"))||!getConfig().getBoolean("use_perms")) {
            int lineNumber = 0;
            for (final String line : event.getLines()) {
                event.setLine(lineNumber++, Owoification.owoify(line));
            }
        }
    }
}
