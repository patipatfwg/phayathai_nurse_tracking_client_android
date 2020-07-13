package com.fg.mdp.fwgfacilitiesfinder.model.responsSend


import com.google.gson.annotations.SerializedName

data class iTAG(

    @field:SerializedName("version")
    val version: String? = null,

    @field:SerializedName("itag_list")
    val itag_list: ArrayList<NurseItem> = ArrayList()


)