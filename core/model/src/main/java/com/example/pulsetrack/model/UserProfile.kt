package com.example.pulsetrack.model

data class UserProfile(
    val id: String,
    val email: String,
    val displayName: String?,
    val photoUrl: String?,
    val goals: UserGoals
)
