package com.example.curriculumvitae

import java.io.Serializable

class Education(degree: String, school: String, dateGraduated: String) : Serializable{

    override fun toString(): String {
        return "Education(degree=$this.degree, school=$this.school, dateGraduated=$this.dateGraduated)"
    }
}