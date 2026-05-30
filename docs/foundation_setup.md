# PulseTrack Implementation Plan - Phase 1: Foundation

This plan outlines the steps to initialize the PulseTrack project structure and core dependencies based on the provided FitTracker plan.

## Objective
Establish a clean, multi-module architecture (NowInAndroid style) and set up essential dependencies for Health tracking, persistence, and UI.

## Key Files & Context
- `libs.versions.toml`: Centralized dependency management.
- `settings.gradle.kts`: Module inclusion.
- `build.gradle.kts` (root & modules): Build configuration.
- `core/`: Shared domain, data, and UI logic.
- `feature/`: UI features.

## Implementation Steps

### 1. Update Dependency Management
- Update `gradle/libs.versions.toml` with the following:
    - **Plugins**: `android-library`, `kotlin-android`, `kotlin-serialization`, `hilt`, `ksp`, `google-services`.
    - **Libraries**:
        - Hilt (Android, Compiler, Navigation Compose)
        - Room (Runtime, KTX, Compiler)
        - Health Connect
        - Firebase BOM (Auth, Firestore)
        - Google Maps (Play Services, Maps Compose)
        - WorkManager
        - DataStore Preferences
        - Navigation Compose
        - Kotlinx Serialization

### 2. Multi-Module Setup
- Create the following module structure (folders and `build.gradle.kts` files):
    - `core:model` (Kotlin library)
    - `core:common` (Android library)
    - `core:database` (Android library)
    - `core:datastore` (Android library)
    - `core:network` (Android library)
    - `core:health` (Android library)
    - `core:data` (Android library)
    - `core:domain` (Kotlin library)
    - `core:ui` (Android library)
    - `feature:dashboard` (Android library)
    - `feature:workout` (Android library)
    - `feature:sleep` (Android library)
    - `feature:analytics` (Android library)
    - `feature:settings` (Android library)
    - `sync` (Android library)
- Register all modules in `settings.gradle.kts`.

### 3. Core Module Foundations
- **`core:model`**: Define basic data classes: `Steps`, `HeartRate`, `WorkoutSession`, `SleepSession`, `UserGoals`.
- **`core:database`**:
    - Setup `FitTrackerDatabase` with Room.
    - Define entities: `StepsEntity`, `WorkoutEntity`, `SleepEntity`.
    - Define DAOs: `StepsDao`, `WorkoutDao`, `SleepDao`.
- **`core:health`**:
    - Create `HealthConnectManager` to wrap Health Connect SDK.
    - Define `HealthDataSource` interface.
    - **Huawei Integration**:
        - Implement `HuaweiHealthSource` (detection logic for Huawei Health + Health Sync bridge).
        - Implement `HealthSourceDetector` to determine if data should come from Health Connect or Huawei (via bridge).
- **`core:datastore`**:
    - Setup `UserPreferencesDataSource` for goals and settings.

### 4. Feature Module Foundations
- Setup basic `Screen` and `ViewModel` templates for each feature module using Hilt.
- **`feature:dashboard`**: Include a placeholder for the `HuaweiSetupBanner` component.

### 5. App Integration
- Configure `MainActivity` to use Jetpack Navigation.
- Set up Hilt in `PulseTrackApplication`.

## Verification & Testing
- **Build**: Ensure the project compiles after adding modules and dependencies.
- **Unit Tests**: Add basic tests for Room DAOs and DataStore.
- **Health Connect**: Verify Health Connect availability check logic.
