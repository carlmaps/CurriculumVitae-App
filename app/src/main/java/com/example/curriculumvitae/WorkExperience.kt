package com.example.curriculumvitae

import java.io.Serializable

data class WorkExperience(var jobTitle: String, var company: String, var startDate: String, var endDate: String, var workContrib: String) : Serializable{

    override fun toString(): String {
        return "WorkExperience(position=$this.jobTitle, company=$this.company, startDate=$this.startDate, endDate=$this.endDate, workContrib=$this.workContrib)"
    }
}