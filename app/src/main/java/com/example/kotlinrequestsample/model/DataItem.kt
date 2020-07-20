package com.example.kotlinrequestsample.model

import com.google.gson.annotations.SerializedName

data class DataItem(@SerializedName("last_name")
                    val lastName: String = "",
                    @SerializedName("id")
                    val id: Int = 0,
                    @SerializedName("avatar")
                    val avatar: String = "",
                    @SerializedName("first_name")
                    val firstName: String = "",
                    @SerializedName("email")
                    val email: String = "",
                    @SerializedName("per_page")
                    val perPage: Int = 0,
                    @SerializedName("total")
                    val total: Int = 0,
                    @SerializedName("ad")
                    val ad: Ad,
                    @SerializedName("data")
                    val data: List<DataItem>?,
                    @SerializedName("page")
                    val page: Int = 0


                    )