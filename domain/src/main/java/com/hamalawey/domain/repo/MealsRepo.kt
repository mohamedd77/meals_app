package com.hamalawey.domain.repo

import com.hamalawey.domain.entity.CategoryResponse

interface MealsRepo {
    suspend fun getMealsFromRemote(): CategoryResponse
}