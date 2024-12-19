package watch;

import necesse.engine.modLoader.ModSettings;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.BuffRegistry;
import necesse.engine.registries.ItemRegistry;
import necesse.engine.registries.RecipeTechRegistry;
import necesse.inventory.item.Item;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;

@ModEntry
public class Watch {
    public static Settings settings;

    public void init() {
        System.out.println("Watch Loaded!");
        ItemRegistry.registerItem("Watch", new WatchItem(Item.Rarity.UNCOMMON,"watchbuff",400), 10f, true);
        BuffRegistry.registerBuff("watchbuff", new WatchBuff());
    }

    public void postInit() {
        Recipes.registerModRecipe(new Recipe(
                "Watch",
                1,
                RecipeTechRegistry.DEMONIC_WORKSTATION,
                new Ingredient[]{
                        new Ingredient("glass", 1),
                        new Ingredient("ironbar", 3),
                        new Ingredient("wire", 5),
                        new Ingredient("leather", 2)
                }
        ).showAfter("chainshirt"));
    }
    public ModSettings initSettings() {
        settings = new Settings();
        return settings;
    }
}
