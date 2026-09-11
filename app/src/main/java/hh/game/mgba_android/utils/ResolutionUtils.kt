package hh.game.mgba_android.utils

import android.content.Context

object ResolutionUtils {
    private const val PREFS_NAME = "mgba_prefs"
    private const val KEY_MULTIPLIER = "resolution_multiplier"
    const val DEFAULT_MULTIPLIER = 1.0f

    // Label to internal render scale multiplier. 6.75x is exact for GBA (160 * 6.75 = 1080),
    // matching a 1080p display vertically at native pixel ratio.
    val OPTIONS: List<Pair<String, Float>> = listOf(
        "1x (Native)" to 1.0f,
        "2x" to 2.0f,
        "3x" to 3.0f,
        "4x" to 4.0f,
        "5x" to 5.0f,
        "6x" to 6.0f,
        "6.75x (1080p)" to 6.75f
    )

    fun getMultiplier(context: Context): Float {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getFloat(KEY_MULTIPLIER, DEFAULT_MULTIPLIER)
    }

    fun setMultiplier(context: Context, multiplier: Float) {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit()
            .putFloat(KEY_MULTIPLIER, multiplier)
            .apply()
    }
}
