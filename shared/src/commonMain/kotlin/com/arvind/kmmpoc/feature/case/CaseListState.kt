package com.arvind.kmmpoc.feature.case

data class CaseListState(
    val cases: List<CaseItem> = emptyList(),
    val selectedCase: CaseItem? = null,
    val isCaseSelected: Boolean = false,
    val openCameraApp: Boolean = false
)