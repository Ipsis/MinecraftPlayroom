package ipsis.playroom;

import com.google.common.primitives.Ints;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OreDictHelper {

    /* The generic dye is called dye, other dyes are named dyeXXX */
    private static final String GENERIC_DYE_ORE_NAME = "dye";
    private static final String SPECIFIC_DYE_ORE_TAG = "dye";

    public static boolean isGenericDyeName(int oreid) {
        return isGenericDyeName(OreDictionary.getOreName(oreid));
    }

    public static boolean isGenericDyeName(String s) {
        if (s != null && s.equals(GENERIC_DYE_ORE_NAME))
            return true;
        return false;
    }

    public static boolean isSpecificDyeName(int oreid) {
        return isSpecificDyeName(OreDictionary.getOreName(oreid));
    }

    public static boolean isSpecificDyeName(String s) {
        if (s != null && !isGenericDyeName(s) && s.startsWith(SPECIFIC_DYE_ORE_TAG))
            return true;
        return false;
    }

    /**
     *
     * @param s - the itemstack to check
     * @param isGeneric - true is generic dye, false for a specific dye
     * @return true if a dye (generic or specific)
     */
    public static boolean isDye(ItemStack s, boolean isGeneric) {

        if (s != null) {

            int[] ids = OreDictionary.getOreIDs(s);
            for (int i : ids) {
                String name = OreDictionary.getOreName(i);
                if (isGeneric && isGenericDyeName(name))
                    return true;
                else if (!isGeneric && isSpecificDyeName(name))
                    return true;
            }
        }

        return false;
    }

    public static String getSpecificDyeName(ItemStack s) {

        if (s != null) {
            int[] ids = OreDictionary.getOreIDs(s);
            for (int i : ids)
                if (isSpecificDyeName(i))
                    return OreDictionary.getOreName(i);
        }

        return "";
    }


    /**
     * Calculate which ore ids are valid for ALL the itemstacks.
     * So the common ore ids across all the itemstacks.
     * @param itemStacks the itemstacks to search
     * @return an array of the common ore ids
     */
    public static int[] getOreIdSet(ItemStack[] itemStacks) {

        if (itemStacks == null || itemStacks.length < 1)
            return new int[0];

        Set<Integer> set = new HashSet<Integer>();

        boolean valid = true;
        for (int i = 0 ; i < itemStacks.length && valid; i++) {

            int[] ids = OreDictionary.getOreIDs(itemStacks[i]);
            if (ids.length == 0) {
                valid = false;
            } else {
                if (set.isEmpty())
                    set.addAll(Ints.asList(ids));
                else
                    set.retainAll(Ints.asList(ids));
            }
        }

        if (!valid)
            set.clear();

        Integer[] tmp = set.toArray(new Integer[set.size()]);
        int[] ret = new int[tmp.length];
        for (int x = 0; x < tmp.length; x++)
            ret[x] = tmp[x];
        return ret;
    }

    public static String getCompressedOreName(int oreids[]) {

        if (oreids == null || oreids.length <= 0)
            return "";

        if (oreids.length == 1)
            return OreDictionary.getOreName(oreids[0]);

        return "";
    }
}
