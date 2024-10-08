package com.manriquetavi.jetatapp.common.component.nav_drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manriquetavi.jetatapp.common.model.NavigationItem
import com.manriquetavi.jetatapp.ui.theme.primaryColor

@Composable
fun NavigationItemView(
    navigationItem: NavigationItem,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(size = 8.dp))
            .clickable { onClick() }
            .background(
                color = if (selected) primaryColor.copy(0.05f)
                else Color.Unspecified,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = navigationItem.icon,
            contentDescription = "Navigation Item Icon",
            tint = if (selected) primaryColor
            else MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = navigationItem.title,
            color = if (selected) primaryColor
            else MaterialTheme.colorScheme.onSurface,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
            lineHeight = 18.sp
        )
    }
}