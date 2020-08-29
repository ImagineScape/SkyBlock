package com.rempler.skyblock.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber
public final class ConfigOptions {
    public static class Common {
        //Void Options
        public static ForgeConfigSpec.BooleanValue netherVoid;
        public static ForgeConfigSpec.BooleanValue endVoid;
        public static ForgeConfigSpec.IntValue cloudLevel;
        public static ForgeConfigSpec.IntValue horizonLevel;
        //Common Island Options
        public static ForgeConfigSpec.IntValue islandDistance;
        public static ForgeConfigSpec.IntValue islandSize;
        public static ForgeConfigSpec.IntValue islandYLevel;
        public static ForgeConfigSpec.EnumValue<BottomBlockType> bottomBlockType;
        public static ForgeConfigSpec.BooleanValue allowIslandCreation;
        //GoG Island
        public static ForgeConfigSpec.BooleanValue enableGoGIsland;
        //Advanced World Generation
        public static ForgeConfigSpec.BooleanValue allowVisitCommand;
        public static ForgeConfigSpec.BooleanValue allowHomeCommand;
        public static ForgeConfigSpec.BooleanValue allowIslandRegen;

        public enum BottomBlockType {
            BEDROCK, SECONDARYBLOCK
        }

        public Common(ForgeConfigSpec.Builder server) {
            netherVoid = server.comment("Nether dimension will be a void world").define("netherVoid", true);
            endVoid = server.comment("End dimension will be a void world").define("netherVoid", true);
            cloudLevel = server.comment("Level where clouds appear").defineInRange("cloudLevel", 96, 1, 255);
            islandDistance = server.comment("The multiplier for island distances for multiplayer Garden of Glass worlds.\n" +
                    "Islands are placed on a grid with 256 blocks between points, with the spawn island always being placed on 256, 256.\n" +
                    "By default, the scale is 8, putting each island on points separated by 2048 blocks.\n" +
                    "You can't set the Value < 4 due to Nether portal collisions.")
                    .defineInRange("islandDistance", 8, 4, 512);
            horizonLevel = server.comment("Level where the horizon appears").defineInRange("horizonLevel", 1, 1, 255);
            islandSize = server.comment("Width of islands (Not yet working!!!)").defineInRange("islandSize", 3, 1, 15);
            islandYLevel = server.comment("Y Level to spawn islands at (Set to 2 above where you want the ground block)").defineInRange("islandYLevel", 72, 1, 240);
            bottomBlockType = server.comment("Type of block to spawn under islands").defineEnum("bottomBlockType", BottomBlockType.BEDROCK);
            allowIslandCreation = server.comment("Allow players to create or reset their islands").define("allowIslandCreation", true);enableGoGIsland = server.comment("Allow garden of glass island to be used").define("enableGoGIsland", false);
            allowVisitCommand = server.comment("Allows the visit command to be used").define("allowVisitCommand", true);
            allowHomeCommand = server.comment("Allows the home command to be used").define("allowHomeCommand", true);
            allowIslandRegen = server.comment("Allows island generation").define("allowIslandRegen", true);
        }
    }

    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;
    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }
}
