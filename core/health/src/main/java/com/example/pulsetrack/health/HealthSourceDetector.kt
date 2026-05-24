package com.example.pulsetrack.health

import android.content.Context
import androidx.health.connect.client.HealthConnectClient
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

enum class HealthSourceType {
    HEALTH_CONNECT,
    HUAWEI_WATCH,
    MANUAL;
}

@Singleton
class HealthSourceDetector @Inject constructor(
    @ApplicationContext private val context: Context,
    private val huaweiHealthSource: HuaweiHealthSource
) {

    suspend fun detectPreferredSource(): HealthSourceType {
        val healthConnectStatus = HealthConnectClient.getSdkStatus(context)
        if (healthConnectStatus == HealthConnectClient.SDK_AVAILABLE) {
            return HealthSourceType.HEALTH_CONNECT
        }

        if (this.huaweiHealthSource.isAvailable()) {
            return HealthSourceType.HUAWEI_WATCH
        }

        return HealthSourceType.MANUAL
    }

    fun needsHuaweiBridge(): Boolean {
        return huaweiHealthSource.isAvailable() && !huaweiHealthSource.isHealthSyncInstalled()
    }

}