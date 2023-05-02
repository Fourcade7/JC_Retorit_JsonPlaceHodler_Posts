package com.pr7.jc_retorit.data.network

import com.pr7.jc_retorit.data.model.PostModel
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    suspend fun getAllPosts(): ArrayList<PostModel>

}