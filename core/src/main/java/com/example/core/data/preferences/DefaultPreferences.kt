package com.example.core.data.preferences

import android.content.SharedPreferences
import com.example.core.domain.model.ActivityLevel
import com.example.core.domain.model.Gender
import com.example.core.domain.model.GoalType
import com.example.core.domain.model.UserInfo
import com.example.core.domain.preferences.Preferences
import com.example.core.domain.preferences.Preferences.Companion.KEY_ACTIVITY_LEVEL
import com.example.core.domain.preferences.Preferences.Companion.KEY_AGE
import com.example.core.domain.preferences.Preferences.Companion.KEY_CARB_RATIO
import com.example.core.domain.preferences.Preferences.Companion.KEY_FAT_RATIO
import com.example.core.domain.preferences.Preferences.Companion.KEY_GENDER
import com.example.core.domain.preferences.Preferences.Companion.KEY_GOAL_TYPE
import com.example.core.domain.preferences.Preferences.Companion.KEY_HEIGHT
import com.example.core.domain.preferences.Preferences.Companion.KEY_PROTEIN_RATIO
import com.example.core.domain.preferences.Preferences.Companion.KEY_WEIGHT

class DefaultPreferences
    (
    private val sharedPreferences: SharedPreferences
) : Preferences {
    override fun saveGender(gender: Gender) {
        sharedPreferences.edit().putString(KEY_GENDER, gender.name).apply()
    }

    override fun saveAge(age: Int) {
        sharedPreferences.edit().putInt(KEY_AGE, age).apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPreferences.edit().putFloat(KEY_WEIGHT, weight).apply()
    }

    override fun saveHeight(height: Int) {
        sharedPreferences.edit().putInt(KEY_HEIGHT, height).apply()
    }

    override fun saveActivityLevel(level: ActivityLevel) {
        sharedPreferences.edit().putString(KEY_ACTIVITY_LEVEL, level.name).apply()
    }

    override fun saveGoalType(type: GoalType) {
        sharedPreferences.edit().putString(KEY_GOAL_TYPE, type.name).apply()
    }

    override fun saveCarbRatio(ratio: Float) {
        sharedPreferences.edit().putFloat(KEY_CARB_RATIO, ratio).apply()
    }

    override fun saveProteinRatio(ratio: Float) {
        sharedPreferences.edit().putFloat(KEY_PROTEIN_RATIO, ratio).apply()
    }

    override fun saveFatRatio(ratio: Float) {
        sharedPreferences.edit().putFloat(KEY_FAT_RATIO, ratio).apply()
    }

    override fun loadUserInfo(): UserInfo {
        val age = sharedPreferences.getInt(KEY_AGE, 20)
        val gender = sharedPreferences.getString(KEY_GENDER, Gender.Male.name)
        val height = sharedPreferences.getInt(KEY_HEIGHT, 160)
        val weight = sharedPreferences.getFloat(KEY_WEIGHT, 80f)
        val activityLevel =
            sharedPreferences.getString(KEY_ACTIVITY_LEVEL, ActivityLevel.Medium.name)
        val goalType = sharedPreferences.getString(KEY_GOAL_TYPE, GoalType.KeepWeight.name)
        val carbRatio = sharedPreferences.getFloat(KEY_CARB_RATIO, 0f)
        val proteinRatio = sharedPreferences.getFloat(KEY_PROTEIN_RATIO, 0f)
        val fatRatio = sharedPreferences.getFloat(KEY_FAT_RATIO, 0f)
        return UserInfo(

            gender = Gender.fromString(gender ?: "male"),
            age = age,
            weight = weight,
            height = height,
            activityLevel = ActivityLevel.fromString(activityLevel ?: "medium"),
            goalType = GoalType.fromString(goalType ?: "keep_weight"),
            carbRatio = carbRatio,
            proteinRatio = proteinRatio,
            fatRatio = fatRatio
        )
    }

    override fun saveShouldShowOnboarding(shouldShow: Boolean) {
        sharedPreferences.edit().putBoolean(Preferences.KEY_SHOULD_SHOW_ONBOARDING, shouldShow)
            .apply()
    }

    override fun loadShouldShowOnboarding(): Boolean {
        return sharedPreferences.getBoolean(
            Preferences.KEY_SHOULD_SHOW_ONBOARDING,
            true
        )
    }
}