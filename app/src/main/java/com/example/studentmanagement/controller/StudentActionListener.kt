package com.example.studentmanagement.controller

import com.example.studentmanagement.model.Student

/**
 * Interface để xử lý các hành động liên quan đến sinh viên từ các Fragment và Adapter.
 */
interface StudentActionListener {
    /**
     * Được gọi khi người dùng nhấn vào một sinh viên để sửa.
     * @param position Vị trí của sinh viên trong danh sách.
     * @param student Đối tượng sinh viên được chọn để sửa.
     */
    fun onStudentEditClicked(position: Int, student: Student)

    /**
     * Được gọi khi thông tin sinh viên được cập nhật trong EditStudentFragment.
     * @param position Vị trí của sinh viên trong danh sách.
     * @param student Đối tượng sinh viên với thông tin đã được cập nhật.
     */
    fun onStudentUpdated(position: Int, student: Student)

    /**
     * Được gọi khi người dùng nhấn nút xóa sinh viên.
     * @param position Vị trí của sinh viên trong danh sách.
     * @param student Đối tượng sinh viên sẽ bị xóa.
     */
    fun onStudentDeleteClicked(position: Int, student: Student)
}
