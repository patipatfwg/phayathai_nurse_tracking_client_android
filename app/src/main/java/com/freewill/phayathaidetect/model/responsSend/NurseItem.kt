package com.fg.mdp.fwgfacilitiesfinder.model.responsSend

import com.google.gson.annotations.SerializedName


data class NurseItem(

	@field:SerializedName("mac_address")
	val macAddress: String? = null ,

	@field:SerializedName("distance")
	val distance: Short ? = null



)