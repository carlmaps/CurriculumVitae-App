package com.example.curriculumvitae

import java.io.Serializable

class AboutInfo  : Serializable{
    var skills: List<Skills>? = null
    var education: List<Education>? = null
    var certificate: List<Certificate>? = null
}