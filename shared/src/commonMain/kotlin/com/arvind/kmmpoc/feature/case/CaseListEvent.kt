package com.arvind.kmmpoc.feature.case

sealed interface CaseListEvent {
    object OnCaseListScreenLaunch : CaseListEvent
    data class SelectCase(val caseItem: CaseItem) : CaseListEvent

    object OnPickPhotoClicked : CaseListEvent
}