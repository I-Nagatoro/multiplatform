package org.example.project.ViewModel

import androidx.compose.runtime.Composable

@Composable
expect fun GetPath(onPathSelected: (String) -> Unit)