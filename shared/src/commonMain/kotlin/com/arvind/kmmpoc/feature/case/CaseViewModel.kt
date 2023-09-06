package com.arvind.kmmpoc.feature.case

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CaseViewModel(
    private val caseRepository: CaseRepository = CaseRepository()
) : ViewModel() {
    private val _state = MutableStateFlow(CaseListState())
    val state get() = _state


    fun onEvent(event: CaseListEvent) {
        when (event) {
            CaseListEvent.OnCaseListScreenLaunch -> fetchAllCase()
            is CaseListEvent.SelectCase -> caseItemClicked(event.caseItem)
            CaseListEvent.OnPickPhotoClicked -> TODO()
        }

    }

    private fun caseItemClicked(caseItem: CaseItem) {
        _state.update {
            it.copy(
                isCaseSelected = true,
                selectedCase = caseItem
            )
        }
    }

    private fun fetchAllCase() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    cases = caseRepository.fetchAllCases()
                )
            }
        }
    }
}