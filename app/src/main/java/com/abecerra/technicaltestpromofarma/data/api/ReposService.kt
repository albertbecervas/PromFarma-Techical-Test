package com.abecerra.technicaltestpromofarma.data.api

import com.abecerra.technicaltestpromofarma.data.api.dto.RepoDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ReposService {

    @GET("/users/jakewharton/repos")
    fun getRepos(
        @Query("page") page: Int,
        @Query("per_page") count: Int,
        @Query("sort") sort: String,
        @Query("direction") direction: String
    ): Single<List<RepoDto>>

}