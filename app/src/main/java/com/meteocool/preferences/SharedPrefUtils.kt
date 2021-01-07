package com.meteocool.preferences

import android.content.SharedPreferences
import android.location.Location
import com.meteocool.location.MeteocoolLocation

/**
 * Helper
 */
class SharedPrefUtils {
    companion object {
        const val KEY_LOCATION_LAT = "latitude"
        const val KEY_LOCATION_LON = "longitude"
        const val KEY_LOCATION_ALT = "altitude"
        const val KEY_LOCATION_ACC = "accuracy"
        const val KEY_LOCATION_NANOS = "elapsedNanos"

        /**
         * Saves location result as a string to [android.content.SharedPreferences].
         */
        fun saveResults(sharedPrefs: SharedPreferences, mLocation: Location) {
            sharedPrefs
                .edit()
                .putFloat(KEY_LOCATION_LAT, mLocation.latitude.toFloat())
                .putFloat(KEY_LOCATION_LON, mLocation.longitude.toFloat())
                .putFloat(KEY_LOCATION_ALT, mLocation.altitude.toFloat())
                .putFloat(KEY_LOCATION_ACC, mLocation.accuracy)
                .putLong(KEY_LOCATION_NANOS, mLocation.elapsedRealtimeNanos)
                .apply()
        }

        /**
         * Fetches location results from [android.content.SharedPreferences].
         */
        fun getSavedLocationResult(sharedPrefs: SharedPreferences): MeteocoolLocation {
            return MeteocoolLocation(
                sharedPrefs.getFloat(
                    KEY_LOCATION_LAT, -1.0f
                ).toDouble(),
                sharedPrefs.getFloat(
                    KEY_LOCATION_LON, -1.0f
                ).toDouble(),
                sharedPrefs.getFloat(
                    KEY_LOCATION_ALT, -1.0f
                ).toDouble(),
                sharedPrefs.getFloat(
                    KEY_LOCATION_ACC, -1.0f
                ),
                sharedPrefs.getLong(
                    KEY_LOCATION_NANOS, -1
                )
            )
        }

    }
}