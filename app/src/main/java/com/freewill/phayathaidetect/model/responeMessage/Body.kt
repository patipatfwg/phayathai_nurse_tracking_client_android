package com.freewill.phayathaidetect.model.responeMessage

import com.fg.mdp.fwgfacilitiesfinder.model.responsSend.NurseItem

data class Body(
    val itag_list: ArrayList<NurseItem>
)