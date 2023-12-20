package io.papermc.testplugin;

import io.papermc.paper.event.player.ChatEvent;
import io.papermc.paper.event.world.StructuresLocateEvent;
import io.papermc.paper.math.Position;
import java.util.function.BiFunction;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.generator.structure.Structure;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public final class TestPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onChat(ChatEvent event) {
        final BiFunction<Location, Structure, StructuresLocateEvent.Result> biFunction = StructuresLocateEvent.Result::new;
        final StructuresLocateEvent.Result resultByConstructor = new StructuresLocateEvent.Result(event.getPlayer().getLocation(), Structure.FORTRESS);
        System.out.println(resultByConstructor.position());
        final StructuresLocateEvent.Result result = biFunction.apply(event.getPlayer().getLocation(), Structure.FORTRESS);
        System.out.println(result.position());
    }
}
