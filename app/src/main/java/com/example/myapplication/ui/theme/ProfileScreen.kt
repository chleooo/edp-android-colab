package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProfileForm(
    state: ProfileUiState,
    viewModel: ProfileViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "My Profile",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Full Name
        OutlinedTextField(
            value = state.name,
            onValueChange = {
                viewModel.onNameChange(it)
            },
            label = {
                Text("Full name")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Email
        OutlinedTextField(
            value = state.email,
            onValueChange = {
                viewModel.onEmailChange(it)
            },
            label = {
                Text("Email")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Contact Number
        OutlinedTextField(
            value = state.contactNumber,
            onValueChange = {
                viewModel.onContactChange(it)
            },
            label = {
                Text("Contact number")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Address
        OutlinedTextField(
            value = state.address,
            onValueChange = {
                viewModel.onAddressChange(it)
            },
            label = {
                Text("Address")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Username
        OutlinedTextField(
            value = state.username,
            onValueChange = {
                viewModel.onUsernameChange(it)
            },
            label = {
                Text("Username")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Skills
        Text(
            text = "Skills",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Add Skill Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            OutlinedTextField(
                value = state.newSkill,
                onValueChange = {
                    viewModel.onNewSkillChange(it)
                },
                label = {
                    Text("Add a skill")
                },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    viewModel.addSkill()
                }
            ) {
                Text("Add")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Skills List
        state.skills.forEach { skill ->

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "• $skill",
                    modifier = Modifier.weight(1f)
                )

                TextButton(
                    onClick = {
                        viewModel.removeSkill(skill)
                    }
                ) {
                    Text("Remove")
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Preview Button
        Button(
            onClick = {
                viewModel.showPreview()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Preview")
        }
    }
}

@Composable
fun ProfilePreview(
    state: ProfileUiState,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "Profile Preview",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Name: ${state.name}",
            fontSize = 17.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Email: ${state.email}",
            fontSize = 17.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Contact: ${state.contactNumber}",
            fontSize = 17.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Address: ${state.address}",
            fontSize = 17.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Username: ${state.username}",
            fontSize = 17.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Skills:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (state.skills.isEmpty()) {

            Text(
                text = "No skills added yet."
            )

        } else {

            state.skills.forEach { skill ->

                Text(
                    text = "• $skill",
                    fontSize = 17.sp,
                    modifier = Modifier.padding(vertical = 3.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Back to Edit
        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to edit")
        }
    }
}

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    if (state.isPreview) {

        ProfilePreview(
            state = state,
            onBack = {
                viewModel.backToEdit()
            }
        )

    } else {

        ProfileForm(
            state = state,
            viewModel = viewModel
        )
    }
}
