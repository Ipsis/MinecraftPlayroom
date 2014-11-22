package ipsis.playroom.manager.chickenbones;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

public class CBItemStack {

    public ItemStack[] items;

    private CBItemStack() { }

    public CBItemStack(Object o) {

        items = extractItems(o);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (items.length == 0) {
            sb.append("{Empty}");
        } else {
            sb.append("{");
            for (ItemStack i : items)
                sb.append(i.getUnlocalizedName() + ":" + i.getItemDamage() + " ");
            sb.append("}");
        }

        return sb.toString();
    }

    /* ChickenBones NEIServerUtils.java */
    @SuppressWarnings("unchecked")
    private ItemStack[] extractItems(Object obj) {
        if (obj instanceof ItemStack)
            return new ItemStack[]{(ItemStack) obj};
        if (obj instanceof ItemStack[])
            return (ItemStack[]) obj;
        if (obj instanceof List)
            return ((List<ItemStack>) obj).toArray(new ItemStack[0]);

        throw new ClassCastException("not an ItemStack, ItemStack[] or List<ItemStack?");
    }

    /* ChickenBones NEIServerUtils.java */
    private static boolean areStacksSameTypeCrafting(ItemStack stack1, ItemStack stack2) {
        return stack1 != null && stack2 != null &&
                stack1.getItem() == stack2.getItem() &&
                (stack1.getItemDamage() == stack2.getItemDamage() ||
                        stack1.getItemDamage() == OreDictionary.WILDCARD_VALUE ||
                        stack2.getItemDamage() == OreDictionary.WILDCARD_VALUE || stack1.getItem().isDamageable());
    }

    /* ChickenBones PositionedStack.java */
    public boolean contains(ItemStack ingredient)
    {
        for(ItemStack item : items)
            if(areStacksSameTypeCrafting(item, ingredient))
                return true;

        return false;
    }

    /* ChickenBones PositionedStack.java */
    public boolean contains(Item ingred)
    {
        for(ItemStack item : items)
            if(item.getItem() == ingred)
                return true;

        return false;
    }
}
