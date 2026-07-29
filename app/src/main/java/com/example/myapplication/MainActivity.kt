package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color



// --- Light Palette ---
val LiceoMaroonPrimary = Color(0xFF800000)          // Liceo Deep Maroon
val LiceoOnPrimary = Color(0xFFFFFFFF)              // Text/Icon on Maroon
val LiceoGoldSecondary = Color(0xFFD4AF37)          // Gold Accent
val LiceoSurfaceLight = Color(0xFFFFF8F6)           // Light warm background
val LiceoOnSurfaceLight = Color(0xFF221A18)         // Primary text
val LiceoOnSurfaceVariantLight = Color(0xFF53433F)  // Muted label text

// --- Dark Palette ---
val LiceoMaroonDarkPrimary = Color(0xFFFFB4AB)      // Light Maroon/Pink Accent
val LiceoOnPrimaryDark = Color(0xFF560003)          // Dark text on primary
val LiceoGoldSecondaryDark = Color(0xFFE6C18D)      // Soft Gold Accent
val LiceoSurfaceDark = Color(0xFF1A1110)            // Dark surface background
val LiceoOnSurfaceDark = Color(0xFFEDE0DE)          // Light text
val LiceoOnSurfaceVariantDark = Color(0xFFD8C2BC)   // Soft label text

private val LightColorScheme = lightColorScheme(
    primary = LiceoMaroonPrimary,
    onPrimary = LiceoOnPrimary,
    secondary = LiceoGoldSecondary,
    surface = LiceoSurfaceLight,
    onSurface = LiceoOnSurfaceLight,
    onSurfaceVariant = LiceoOnSurfaceVariantLight
)

private val DarkColorScheme = darkColorScheme(
    primary = LiceoMaroonDarkPrimary,
    onPrimary = LiceoOnPrimaryDark,
    secondary = LiceoGoldSecondaryDark,
    surface = LiceoSurfaceDark,
    onSurface = LiceoOnSurfaceDark,
    onSurfaceVariant = LiceoOnSurfaceVariantDark
)

@Composable
fun ProfileCardLabTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileCardLabTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    ProfileScreen()
                }
            }
        }
    }
}