package ipsis.playroom.item;

import cpw.mods.fml.common.registry.GameRegistry;
import ipsis.playroom.reference.Names;

public class Items {

    public static void preInit() {

        itemPaintDebug = new ItemPaintDebug();

        GameRegistry.registerItem(itemPaintDebug, Names.Items.ITEM_PAINT_DEBUG);
    }

    public static void initialize() {

    }

    public static void postInit() {

    }

    public static ItemPlayroom itemPaintDebug;

}
