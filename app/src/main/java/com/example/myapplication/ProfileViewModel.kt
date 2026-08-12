package com.example.myapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel : ViewModel() {

    // Private, editable state
    private val _uiState = MutableStateFlow(ProfileUiState())

    // Public, read-only state
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    // Update Full Name
    fun onNameChange(value: String) {
        _uiState.update {
            it.copy(name = value)
        }
    }

    // Update Email
    fun onEmailChange(value: String) {
        _uiState.update {
            it.copy(email = value)
        }
    }

    // Update Contact Number
    fun onContactChange(value: String) {
        _uiState.update {
            it.copy(contactNumber = value)
        }
    }

    // Update Address
    fun onAddressChange(value: String) {
        _uiState.update {
            it.copy(address = value)
        }
    }

    // Update Username
    fun onUsernameChange(value: String) {
        _uiState.update {
            it.copy(username = value)
        }
    }

    // Update New Skill
    fun onNewSkillChange(value: String) {
        _uiState.update {
            it.copy(newSkill = value)
        }
    }

    // Add Skill
    fun addSkill() {
        val skill = _uiState.value.newSkill.trim()

        // Ignore empty input
        if (skill.isEmpty()) {
            return
        }

        _uiState.update { current ->
            current.copy(
                skills = current.skills + skill,
                newSkill = ""
            )
        }
    }

    // Remove Skill
    fun removeSkill(skill: String) {
        _uiState.update { current ->
            current.copy(
                skills = current.skills - skill
            )
        }
    }

    // Show Preview
    fun showPreview() {
        _uiState.update {
            it.copy(isPreview = true)
        }
    }

    // Back to Edit
    fun backToEdit() {
        _uiState.update {
            it.copy(isPreview = false)
        }
    }
}
