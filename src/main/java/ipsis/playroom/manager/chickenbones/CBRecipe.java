package ipsis.playroom.manager.chickenbones;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Collection;

public class CBRecipe {

    public ItemStack output;
    public ArrayList<CBItemStack> ingredients;

    public boolean contains(Collection<CBItemStack> ingredients, ItemStack ingredient) {
        for (CBItemStack stack : ingredients)
            if (stack.contains(ingredient))
                return true;

        return false;
    }

    public boolean contains(Collection<CBItemStack> ingredients, Item ingred) {
        for (CBItemStack stack : ingredients)
            if (stack.contains(ingred))
                return true;
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(output == null ? "NO OUTPUT: " : output + " <==> ");

        for (CBItemStack i : ingredients)
            sb.append(i);

        return sb.toString();
    }
}