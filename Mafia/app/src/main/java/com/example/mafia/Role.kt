package com.example.mafia

import com.example.mafia.ui.theme.MafiaThemeColor
import androidx.compose.ui.graphics.Color
import com.example.mafia.ui.theme.CivilBackgroundColor
import com.example.mafia.ui.theme.CivilThemeColor
import com.example.mafia.ui.theme.DetectiveBackgroundColor
import com.example.mafia.ui.theme.DetectiveThemeColor
import com.example.mafia.ui.theme.DoctorBackgroundColor
import com.example.mafia.ui.theme.DoctorThemeColor
import com.example.mafia.ui.theme.MafiaBackgroundColor

enum class Role(val mainThemeColor: Color,val backGroundColor: Color,val whoYouAre: Int, val description: Int, val logoImage: Int) {
    MAFIA(MafiaThemeColor, MafiaBackgroundColor,R.string.mafia, R.string.mafia_desc,R.drawable.mafia_hat),

    DETECTIVE(DetectiveThemeColor, DetectiveBackgroundColor,R.string.detective,R.string.detective_desc,R.drawable.detective_glass),

    CIVIL(CivilThemeColor, CivilBackgroundColor,R.string.civil,R.string.civil_desc,R.drawable.town_house),

    DOCTOR(DoctorThemeColor, DoctorBackgroundColor,R.string.medic, R.string.medic_desc,R.drawable.medic_cross),
}