package com.example.studentmanagement.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.studentmanagement.R
import com.example.studentmanagement.model.Student

class EditStudentFragment : Fragment() {
    private lateinit var etStudentName: EditText
    private lateinit var etStudentId: EditText
    private lateinit var btnSave: Button
    private lateinit var btnCancel: Button

    private var studentToEdit: Student? = null
    private var studentPosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        studentToEdit = FragmentSingleton.student
        studentPosition = FragmentSingleton.position
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // SỬA LỖI: Inflate đúng file layout
        return inflater.inflate(R.layout.layout_fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // SỬA LỖI: Sử dụng đúng ID từ file layout
        etStudentName = view.findViewById(R.id.update_name)
        etStudentId = view.findViewById(R.id.update_id)
        btnSave = view.findViewById(R.id.btn_update)
        btnCancel = view.findViewById(R.id.btn_cancel_update)

        studentToEdit?.let {
            etStudentName.setText(it.studentName)
            etStudentId.setText(it.studentId)
            etStudentId.isEnabled = false // Không cho sửa MSSV
        }

        btnSave.setOnClickListener {
            saveChanges()
        }

        btnCancel.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun saveChanges() {
        val updatedName = etStudentName.text.toString().trim()
        val originalStudentId = studentToEdit?.studentId

        if (updatedName.isBlank() || originalStudentId == null) {
            Toast.makeText(requireContext(), "Tên sinh viên không được để trống", Toast.LENGTH_SHORT).show()
            return
        }

        val updatedStudent = Student(studentName = updatedName, studentId = originalStudentId)

        FragmentSingleton.studentActionListener?.onStudentUpdated(studentPosition, updatedStudent)

        findNavController().popBackStack()
    }
}
