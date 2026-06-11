package com.stonercraft.stonercraft.util;

public enum StrainType {
    LEMON_HAZE("lemon_haze", "jungle", PlantGen.SATIVA),
    AFGHAN_KUSH("afghan_kush", "mountains", PlantGen.INDICA),
    PURPLE_HAZE("purple_haze", "swamp", PlantGen.SATIVA),
    WHITE_WIDOW("white_widow", "plains", PlantGen.HYBRID);

    private final String id;
    private final String preferredBiome;
    private final PlantGen plantGen;

    StrainType(String id, String preferredBiome, PlantGen plantGen) {
        this.id = id;
        this.preferredBiome = preferredBiome;
        this.plantGen = plantGen;
    }

    public String getId() {
        return id;
    }

    public String getSeedItemId() {
        return id + "_seed";
    }

    public String getBudItemId() {
        return id + "_bud";
    }

    public String getJointItemId() {
        return "joint_" + id;
    }

    public String getPreferredBiome() {
        return preferredBiome;
    }

    public PlantGen getPlantGen() {
        return plantGen;
    }
}
