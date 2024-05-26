package com.example.todo_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToDoViewModel : ViewModel() {

    // Private mutable LiveData
    private val _tasks = MutableLiveData<List<String>>(emptyList())

    // Public immutable LiveData
    val tasks: LiveData<List<String>> get() = _tasks

    // Function to add a new task
    fun addTask(task: String) {
        if (task.isNotBlank()) {
            val updatedTasks = _tasks.value.orEmpty() + task
            _tasks.value = updatedTasks
        }
    }

    // Function to remove a task
    fun removeTask(task: String) {
        val updatedTasks = _tasks.value.orEmpty() - task
        _tasks.value = updatedTasks
    }
}