package com.arvind.kmmpoc.feature.case

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.PersonAdd
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arvind.kmmpoc.feature.case.detail.CaseDetailScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaseListScreen(
    state: CaseListState,
    onEvent: (CaseListEvent) -> Unit,
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onEvent(CaseListEvent.OnPickPhotoClicked)
                },
                shape = RoundedCornerShape(20.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.PersonAdd,
                    contentDescription = "Add Photo"
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .padding(8.dp),
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Assigned Cases  (${state.cases.size})",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    fontWeight = FontWeight.Bold
                )
            }
            items(state.cases) { case ->
                CaseItemCard(case, onEvent)
            }
        }
    }

}

@Composable
private fun CaseItemCard(item: CaseItem, onEvent: (CaseListEvent) -> Unit) {
    Card(
        shape = RoundedCornerShape(size = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable {
                    onEvent(CaseListEvent.SelectCase(item))
                }
                .padding(vertical = 10.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(width = 12.dp))
            Icon(
                imageVector = Icons.Rounded.Person,
                contentDescription = item.name,
                modifier = Modifier.size(25.dp),
                tint = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Spacer(modifier = Modifier.width(width = 12.dp))
            Column {
                Text(
                    text = item.name,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.width(width = 12.dp))
                Text(
                    text = item.dateAdded,
                    fontSize = 14.sp
                )
            }

        }
    }

}