package com.nali.fastkraft;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import static com.nali.fastkraft.FastKraft.ID;

@Config(modid = ID)
public class FastKraftConfig
{
    @Config.Name("Chunk")
    public static final Chunk CHUNK = new Chunk();

    public static class Chunk
    {
        @Config.Name("Count")
        public Count count = new Count();

        public static class Count
        {
            @Config.Name("X")
            public int x = 16;

            @Config.Name("Y")
            public int y = 16;

            @Config.Name("Z")
            public int z = 16;
        }
    }

    @Mod.EventBusSubscriber(modid = ID, value = Side.CLIENT)
    public static class ConfigEvent
    {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
        {
            if (event.getModID().equals(ID))
            {
                ConfigManager.sync(ID, Config.Type.INSTANCE);
            }
        }
    }
}
