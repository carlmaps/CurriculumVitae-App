package com.example.curriculumvitae

import java.io.Serializable

class Skills(techSkill: String, skillLevel: Int) : Serializable{

    override fun toString(): String {
        return "Skills(techSkill=$this.techSkill, skillLevel=$this.skillLevel)"
    }
}