package ipsis.playroom.utils;

import cofh.lib.inventory.ComparableItemStackSafe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Some of the blocks I need to look at are going to incorrectly match
 * with ComparableItemStackSafe.
 * There this subclass disables the oreID lookup completely.
 */

public class ComparableItemStackReallySafe extends ComparableItemStackSafe {


    public ComparableItemStackReallySafe(ItemStack stack) {

        super(stack);
        oreID = -1;
    }

    public ComparableItemStackReallySafe(Item item, int damage, int stackSize) {

        super(item, damage, stackSize);
        this.oreID = -1;
    }

    public static int getOreID(ItemStack stack) {

        return -1;
    }

    public static int getOreID(String oreName) {

        return -1;
    }

    @Override
    public ComparableItemStackReallySafe set(ItemStack stack) {

        super.set(stack);
        oreID = -1;

        return this;
    }
}
