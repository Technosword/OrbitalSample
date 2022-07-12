package us.techno.samplepluginorbit;

import org.bukkit.plugin.java.JavaPlugin;
import us.techno.samplepluginorbit.commands.ExplodeCommand;
import us.techno.samplepluginorbit.commands.FireCommand;
import us.techno.samplepluginorbit.commands.LightningCommand;

import java.util.Objects;

public final class SamplePluginOrbit extends JavaPlugin {

    SamplePluginOrbit plugin;
    @Override
    public void onEnable() {
       plugin = this;
       Objects.requireNonNull(getCommand("explode")).setExecutor(new ExplodeCommand());
       Objects.requireNonNull(getCommand("fire")).setExecutor(new FireCommand());
       Objects.requireNonNull(getCommand("lightning")).setExecutor(new LightningCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
