package com.tenmafrank.myfirstcomposeapp.components.navigation

import com.tenmafrank.myfirstcomposeapp.components.navigation.examples.model.SettingsModel
import kotlinx.serialization.Serializable

@Serializable
object login
@Serializable
object home
@Serializable
data class detail (
    val id: String,
    val test: Boolean
)
@Serializable
data class settings(val settingsModel: SettingsModel)

@Serializable
data class setingsT(val settingsModel: SettingsModel)