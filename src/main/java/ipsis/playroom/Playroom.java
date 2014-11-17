package ipsis.playroom;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import ipsis.playroom.item.Items;
import ipsis.playroom.reference.Reference;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class Playroom {

    @Mod.Instance(Reference.MOD_ID)
    public static Playroom instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        Items.preInit();
    }

    @Mod.EventHandler
    public void initialize(FMLInitializationEvent event) {

        Items.initialize();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        Items.postInit();
    }
}

