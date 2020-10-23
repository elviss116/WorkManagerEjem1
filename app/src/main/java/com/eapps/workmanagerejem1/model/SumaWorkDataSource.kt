package com.eapps.workmanagerejem1.model

import com.eapps.workmanagerejem1.util.OperationResult

interface SumaWorkDataSource {
    fun suma(n1: Int, n2: Int): OperationResult<Int>
}