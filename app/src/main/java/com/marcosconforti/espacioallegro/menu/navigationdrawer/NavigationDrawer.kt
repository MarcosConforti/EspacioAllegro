package com.marcosconforti.espacioallegro.menu.navigationdrawer

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerScreen(
    drawerState: DrawerState,
    items: List<NavigationItems>,
    onItemClick: (NavigationItems) -> Unit
) {
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    ModalDrawerSheet {
        items.forEachIndexed { index, item ->
            NavigationDrawerItem(
                label = { Text(text = item.title) },
                selected = index == selectedItemIndex,
                onClick = {
                    selectedItemIndex = index
                    scope.launch {
                        drawerState.close()
                    }
                    onItemClick(item)
                },
                icon = {
                    Icon(
                        imageVector = if (index == selectedItemIndex) {
                            item.selectedIcon
                        } else item.unSelectedIcon,
                        contentDescription = item.title
                    )
                }
            )
        }
    }
}

