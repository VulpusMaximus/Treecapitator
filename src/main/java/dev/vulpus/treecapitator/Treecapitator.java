package dev.vulpus.treecapitator;

import org.bukkit.plugin.java.JavaPlugin;

public final class Treecapitator extends JavaPlugin {

    @Override
    public void onEnable() {

        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Events(getConfig()), this);

    }

}
