package com.example.wetrade

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class WeTradeViewModel: ViewModel() {

    val types = mutableStateListOf(
        "Week", "ETFs", "Stocks", "Funds", "Others"
    )

    val funds = mutableStateListOf(
        Fund("ALK", "Alaska Air Group, Inc.", "$7,918", -0.54f, R.drawable.ic_home_alk),
        Fund("BA", "Boeing Go.", "$1,293", +4.18f, R.drawable.ic_home_ba),
        Fund("DAL", "Delta Airlines Inc.", "$893,50", -0.54f, R.drawable.ic_home_dal),
        Fund("EXPE", "Expedia Group Inc.", "$12,301", +2.51f, R.drawable.ic_home_exp),
        Fund("EADSY", "Airbus SE", "$12,301", +1.38f, R.drawable.ic_home_eadsy),
        Fund("JBLU", "Jetblue Airways Corp.", "$8,521", +1.56f, R.drawable.ic_home_jblu),
        Fund("MAR", "Marriott International Inc.", "$521", +2.75f, R.drawable.ic_home_mar),
        Fund("CCL", "Carnival Corp", "$5,481", +0.14f, R.drawable.ic_home_ccl),
        Fund("RCL", "oyal Caribbean Cruises", "$9,184", +1.69f, R.drawable.ic_home_rcl),
        Fund("TRVL", "Travelocity Inc.", "$654", +3.23f, R.drawable.ic_home_trvl),
    )


}