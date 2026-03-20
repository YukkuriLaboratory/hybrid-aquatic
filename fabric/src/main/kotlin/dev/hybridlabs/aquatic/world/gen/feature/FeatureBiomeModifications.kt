package dev.hybridlabs.aquatic.world.gen.feature

import dev.hybridlabs.aquatic.config.HybridAquaticConfig
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors

/**
 * Applies biome modifications to features when initialised.
 */
object FeatureBiomeModifications {
    fun registerBiomeModifications(config: HybridAquaticConfig) {
        for (addition in BiomeFeatureAddition.builtIn) {
            if (!config.enableMessageInABottle && addition.placedFeature == HybridAquaticPlacedFeatures.MESSAGE_IN_A_BOTTLE) {
                continue
            }

            BiomeModifications.addFeature(
                BiomeSelectors.tag(addition.biomeTag),
                addition.step,
                addition.placedFeature,
            )
        }
    }
}
