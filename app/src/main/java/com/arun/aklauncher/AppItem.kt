package com.arun.aklauncher

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun AppItem(resolveInfo: ApplicationInfo, pm: PackageManager) {
    val context = LocalContext.current

    val packageName = resolveInfo.packageName ?: return
    val label = resolveInfo.loadLabel(pm)?.toString() ?: "App"
    val icon = resolveInfo.loadIcon(pm)

    Column(
        modifier = Modifier
            .clickable {
                val launchIntent = pm.getLaunchIntentForPackage(packageName)
                launchIntent?.let { context.startActivity(it) }
            }
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        icon?.let {
            Image(
                painter = rememberAsyncImagePainter(it),
                contentDescription = label,
                modifier = Modifier.size(48.dp)
            )
        }
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
