package com.pr7.jc_retorit.data.repository

import com.pr7.jc_retorit.data.model.PostModel
import com.pr7.jc_retorit.data.network.RetrofitInstance

class PostRepository {


    suspend fun getAllData():ArrayList<PostModel>{
        val response= RetrofitInstance.getApi().getAllPosts()
        return  response
    }


}