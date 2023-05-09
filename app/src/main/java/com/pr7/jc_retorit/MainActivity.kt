package com.pr7.jc_retorit

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.pr7.jc_retorit.data.model.PostModel
import com.pr7.jc_retorit.data.repository.PostRepository
import com.pr7.jc_retorit.ui.theme.JC_RetoritTheme
import com.pr7.jc_retorit.ui.theme.screens.PostResponseUi
import com.pr7.jc_retorit.ui.theme.screens.PostUiLazyColumn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition", "UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_RetoritTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val postRepository= PostRepository()
                    var arrayList by remember {
                            mutableStateOf(ArrayList<PostModel>())
                    }


                    lifecycleScope.launch{
                        arrayList=postRepository.getAllData()
                        Log.d("PR77777", "onCreate: ${arrayList.size-1}")
                    }
                    PostUiLazyColumn(arrayList = arrayList)
                    //PostResponseUi(postModel = list.get(0))
                    prnewdesign(arrayList.size.toString())
                    val mytext by remember {
                        mutableStateOf("")
                    }

                }
            }
        }
        val sc=CoroutineScope(Dispatchers.Main)
        sc.launch {
            delay(1000)
            Log.d("PR77777", "onCreate: 7")
        }
    }


}

@Composable
fun prnewdesign(text:String) {

    val mytext by remember {
        mutableStateOf("")
    }

    Text(text = text)
}


