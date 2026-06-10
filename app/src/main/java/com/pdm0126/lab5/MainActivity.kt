package com.pdm0126.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pdm0126.lab5.ui.theme.Lab4Theme
//import okhttp3.internal.concurrent.Task

//data class Task (
//    val id: Int,
//    val title: String,
//    val description: String,
//    val endDate: Date = Date(),
//    val isCompleted: Boolean = false
//)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab4Theme {
                App()
            }
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Greeting() {
//    var showDialog by remember { mutableStateOf(false) }
//    val taskList = remember { mutableStateListOf<Task>() }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(title = {Text("Tasks list")})
//        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = {showDialog = true}) {
//                Icon(Icons.Default.Add, contentDescription = "Añadir")
//            }
//        }
//    ) { paddingValues ->
//        LazyColumn(modifier = Modifier.padding(paddingValues)) {
//            items(taskList){
//                task ->
//                TaskCard(task)
//                Spacer(modifier = Modifier.height(24.dp))
//            }
//        }
//
//        if (showDialog){
//            CreateTask(
//                onDismiss = { showDialog = false },
//                onTaskCreated = { newTitle, newDescription ->
//                    val newTask = Task(
//                        id = taskList.size + 1,
//                        title = newTitle,
//                        description = newDescription
//                    )
//                    taskList.add(newTask)
//                    showDialog = false
//                }
//            )
//        }
//
//    }
//}

//@Composable
//fun CreateTask(
//    onDismiss: () -> Unit,
//    onTaskCreated: (String, String) -> Unit
//){
//    var title by remember { mutableStateOf("") }
//    var description by remember { mutableStateOf("") }
//            Dialog(
//                onDismissRequest = {
//                    onDismiss()
//                },
//                properties = DialogProperties(
//                    dismissOnBackPress = false,
//                    dismissOnClickOutside = false
//                ),
//            ) {
//                Column(
//                    modifier = Modifier
//                        .wrapContentSize()
//                        .background(Color.Black),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center
//                ) {
//
//                    Text(
//                        text = "Nueva Tarea",
//                        style = MaterialTheme.typography.headlineSmall,
//                        modifier = Modifier.padding(bottom = 16.dp)
//                    )
//
//                    OutlinedTextField(
//                        value = title,
//                        onValueChange = { title = it },
//                        label = { Text("Título") },
//                        modifier = Modifier.fillMaxWidth()
//                    )
//
//                    Spacer(modifier = Modifier.height(8.dp))
//
//
//                    OutlinedTextField(
//                        value = description,
//                        onValueChange = { description = it },
//                        label = { Text("Descripción") },
//                        modifier = Modifier.fillMaxWidth()
//                    )
//
//                    Spacer(modifier = Modifier.height(24.dp))
//
//                    Row(
//                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp),
//                    ) {
//                        Button(onClick = { onDismiss()}) {
//                            Text(text = "Cerrar")
//                        }
//
//                        Button(onClick = {
//                            if (title.isNotBlank()){
//                                onTaskCreated(title,description)
//                            }
//                        },
//                            enabled = title.isNotBlank()) {
//                            Text("Crear")
//                        }
//                    }
//                }
//            }
//        }

@Preview(showBackground = true)
@Composable
fun TaskScreenPreview() {
    Lab4Theme {
        App()
    }
}