package com.diego.todoapp.addtask.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import com.diego.todoapp.addtask.ui.model.TaskModel

@Composable
fun TaskScreen(modifier: Modifier, taskVieModel: TaskVieModel) {
    val showDialog: Boolean by taskVieModel.showDialog.observeAsState(false)
    Box(modifier = modifier.fillMaxSize()) {
        AddTaskDialog(
            showDialog,
            onDismiss = { taskVieModel.onDialogClose() },
            onTaskAdded = { taskVieModel.onTaskCreated(it) })
        FabDialog(
            Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            taskVieModel
        )
        TaskList(taskVieModel)
    }
}

@Composable
fun TaskList(taskVieModel: TaskVieModel) {


    val tasks: List<TaskModel> = taskVieModel.listTask

    LazyColumn {
        items(tasks, key = {it.id}) { currentTask ->
            ItemTask(currentTask,taskVieModel)
        }
    }
}

@Composable
fun ItemTask(taskModel: TaskModel, taskVieModel: TaskVieModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 15.dp).pointerInput(Unit){
                detectTapGestures (onLongPress = {
                    taskVieModel.onDeletedTask(taskModel)
                })
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor =
            MaterialTheme.colorScheme.surfaceVariant,
        )
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(text = taskModel.task, modifier = Modifier.weight(1f))
            Checkbox(checked = taskModel.selected, onCheckedChange = {taskVieModel.onCheckBoxSelected(taskModel)})
        }
    }

}

@Composable
fun FabDialog(modifier: Modifier, taskVieModel: TaskVieModel) {
    FloatingActionButton(
        onClick = { taskVieModel.onClickAddTask() },
        modifier = modifier
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Add")
    }
}

@Composable
fun AddTaskDialog(show: Boolean, onDismiss: () -> Unit, onTaskAdded: (String) -> Unit) {
    var myTask by remember {
        mutableStateOf("")
    }
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .padding(10.dp)

            ) {
                Text(
                    text = "New Task",
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.size(20.dp))
                TextField(
                    value = myTask,
                    onValueChange = { myTask = it },
                    singleLine = true,
                    maxLines = 1,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.size(20.dp))
                Button(onClick = { onTaskAdded(myTask)
                                 myTask = ""}, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Save Task")
                }
            }
        }
    }

}