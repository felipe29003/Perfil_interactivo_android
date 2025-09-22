// =================================================================
// Archivo: app/src/main/java/com/example/perfil_interactivo_android/viewmodel/ProfileViewModel.kt
// =================================================================
package com.example.perfil_interactivo_android.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.perfil_interactivo_android.model.Profile

class ProfileViewModel : ViewModel() {

    private val _profiles = mutableStateListOf<Profile>()
    val profiles: List<Profile> get() = _profiles

    init {
        loadSampleProfiles()
    }

    fun addProfile(name: String, season: Int, imageUrl: String) {
        val newProfile = Profile(name = name, season = season, imageUrl = imageUrl)
        _profiles.add(newProfile)
    }

    private fun loadSampleProfiles() {
        if (_profiles.isEmpty()) {
            _profiles.addAll(
                listOf(
                    Profile("Walter White", 5, "https://www.cinepremiere.com.mx/wp-content/uploads/2020/02/walter-white-breaking-bad.jpg"),
                    Profile("Jesse Pinkman", 5, "https://static.wikia.nocookie.net/breakingbad/images/5/5a/Jesse_Pinkman_S5B.png"),
                    Profile("Saul Goodman", 6, "https://static.wikia.nocookie.net/breakingbad/images/b/b3/BCS_S6_Portrait_Saul.png")
                )
            )
        }
    }
}
