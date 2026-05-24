package com.example.pulsetrack.health

import android.content.Context
import android.content.pm.PackageManager
import com.example.pulsetrack.model.Steps
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.time.LocalDate
import javax.inject.Inject

class HuaweiHealthSource @Inject constructor(
    @ApplicationContext private val context: Context
): HealthDataSource {

    companion object {
        const val HUAWEI_HEALTH_PACKAGE = "com.huawei.health"
        const val HEALTH_SYNC_PACKAGE = "nl.appyhapps.healthsync"
    }

    override fun getStepsForData(data: LocalDate): Flow<Steps?> {
        return flowOf(null)
    }

    override fun isAvailable(): Boolean {
        return this.isHealthSyncInstalled()
    }

    fun isHealthSyncInstalled(): Boolean {
        return this.isPackageInstalled(HUAWEI_HEALTH_PACKAGE)
    }

    private fun isPackageInstalled(packageName: String): Boolean {
        return try {
            context.packageManager.getPackageInfo(packageName, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

}