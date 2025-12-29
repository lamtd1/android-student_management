package com.example.studentmanagement.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.studentmanagement.R

class AddStudentFragment : Fragment(R.layout.layout_add_student_fragment) {

    interface OnStudentAddedListener {
        fun onStudentAdded(name: String, id: String)
    }

    private var listener: OnStudentAddedListener? = null
    private lateinit var etName: EditText
    private lateinit var etId: EditText

    private fun setOnStudentAddedListener(listener: OnStudentAddedListener?) {
        this.listener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setOnStudentAddedListener(FragmentSingleton.onStudentAddedListener)
        return inflater.inflate(R.layout.layout_add_student_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etName = view.findViewById(R.id.edit_name)
        etId = view.findViewById(R.id.edit_id)
        val btnSave = view.findViewById<Button>(R.id.btn_add)
        val btnCancel = view.findViewById<Button>(R.id.btn_cancel)

        btnSave.setOnClickListener {
            val name = etName.text.toString().trim()
            val id = etId.text.toString().trim()

            if (name.isNotEmpty() && id.isNotEmpty()) {
                listener?.onStudentAdded(name, id)
                parentFragmentManager.popBackStack()
            } else {
                Toast.makeText(requireContext(), "Tên và MSSV không được để trống", Toast.LENGTH_SHORT).show()
            }
        }

        btnCancel.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}
