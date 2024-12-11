package com.example.exercise_jparelationi.Controller;

import com.example.exercise_jparelationi.ApiResponse.ApiResponse;
import com.example.exercise_jparelationi.Model.Teacher;
import com.example.exercise_jparelationi.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeacher());
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addTeacher(@RequestBody @Valid Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(201).body(new ApiResponse("Teacher added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher
    ) {
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.ok(new ApiResponse("Teacher updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok(new ApiResponse("Teacher deleted successfully"));
    }
}