package com.example.curriculumvitae

import java.io.Serializable

class User(var fullName: String, var userName: String, var contactNumber: String, var password: String):
    Serializable {

//    var summary: String? = null
//    var aboutInfo: AboutInfo? = null
//    var workExperience: WorkExperience? = null
//    var academicProject: AcademicProject? = null

    override fun toString(): String {
        return "User(fullName=$fullName, , userName=$userName, contactNumber=$contactNumber, password=$password)"
    }
}