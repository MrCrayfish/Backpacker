package com.mrcrayfish.backpacker;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Author: MrCrayfish
 */
public class Config
{
    public static class Common
    {
        public final ForgeConfigSpec.IntValue rucksackInventorySize;
        public final ForgeConfigSpec.IntValue shulkerpackInventorySize;
        public final ForgeConfigSpec.IntValue nethersackInventorySize;

        public Common(ForgeConfigSpec.Builder builder)
        {
            builder.push("common");
            {
                this.rucksackInventorySize = builder.comment("The amount of rows in the rucksack inventory. Each row is nine slots of storage.").defineInRange("rucksackInventorySize", 2, 1, 6);
                this.shulkerpackInventorySize = builder.comment("The amount of rows in the shulkerpack inventory. Each row is nine slots of storage.").defineInRange("shulkerpackInventorySize", 3, 1, 6);
                this.nethersackInventorySize = builder.comment("The amount of rows in the nethersack inventory. Each row is nine slots of storage.").defineInRange("nethersackInventorySize", 5, 1, 6);
            }
            builder.pop();
        }
    }

    static final ForgeConfigSpec commonSpec;
    public static final Config.Common COMMON;

    static
    {
        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        commonSpec = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
    }
}
