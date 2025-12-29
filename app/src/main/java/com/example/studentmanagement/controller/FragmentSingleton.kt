package com.example.studentmanagement.controller

import com.example.studentmanagement.controller.AddStudentFragment.OnStudentAddedListener
import com.example.studentmanagement.model.Student

object FragmentSingleton {
    var position: Int = 0
    var onStudentAddedListener: OnStudentAddedListener? = null
    var student: Student? = null
    var studentActionListener: StudentActionListener? = null
}
