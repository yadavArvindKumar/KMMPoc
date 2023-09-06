package com.arvind.kmmpoc.feature.case

class CaseRepository {
    fun fetchAllCases(): List<CaseItem> {
        return listOf<CaseItem>(
            CaseItem("Arvind Kumar", "100011", "31/12/2023"),
            CaseItem("Arvind Kumar Yadav", "200011", "31/12/2023"),
            CaseItem("Arvind Yadav", "300011", "31/12/2023")
        )
    }
}