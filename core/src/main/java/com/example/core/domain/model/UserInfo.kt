package com.example.core.domain.model

data class UserInfo(
    val gender: Gender,
    val age: Int,
    val weight: Float,
    val height: Int,
    val activityLevel: ActivityLevel,
    val goalType: GoalType,
    val carbRatio: Float = 0f,
    val proteinRatio: Float = 0f,
    val fatRatio: Float = 0f
)
