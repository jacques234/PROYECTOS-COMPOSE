package com.diego.todoapp.addtask.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diego.todoapp.addtask.ui.model.TaskModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TaskVieModel @Inject constructor() : ViewModel() {


    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    private var _listTask = mutableStateListOf<TaskModel>()
    val listTask:List<TaskModel> = _listTask

    fun onDialogClose() {
        _showDialog.value = false
    }

    fun onTaskCreated(myTask: String) {
        _showDialog.value = false
        _listTask.add(TaskModel(task = myTask))
    }
    fun onClickAddTask(){
        _showDialog.value = true
    }

    fun onCheckBoxSelected(taskModel: TaskModel) {
        val index = _listTask.indexOf(taskModel)
        _listTask[index] = _listTask[index].let{
            it.copy(selected = !it.selected)
        }
    }
    fun onDeletedTask(taskModel: TaskModel) {
        val task = _listTask.find { it.id == taskModel.id }
        _listTask.remove(task)
    }
}