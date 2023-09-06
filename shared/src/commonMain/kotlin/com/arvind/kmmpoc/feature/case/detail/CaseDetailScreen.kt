package com.arvind.kmmpoc.feature.case.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PersonAdd
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.arvind.kmmpoc.feature.case.CaseItem
import com.arvind.kmmpoc.feature.case.CaseListEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaseDetailScreen(
    isOpen: Boolean = false,
    case: CaseItem,
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
                    text = "Case Detail",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    fontWeight = FontWeight.Bold
                )
            }
            item {
                Card {
                    Column {
                        Text(
                            text = case.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = case.caseId,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = case.dateAdded,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

            }

        }
    }
}