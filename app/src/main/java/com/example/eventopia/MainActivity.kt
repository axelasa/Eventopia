package com.example.eventopia

import android.app.Application
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eventopia.data.repositories.EventRepository
import com.example.eventopia.data.repositories.EventRepositoryImpl
import com.example.eventopia.data.services.network.http_client.HttpClient
import com.example.eventopia.data.services.network.tiket.TicketApi
import com.example.eventopia.presentation.theme.ui.core.EventopiaTheme
import com.example.eventopia.presentation.ui.features.explore_events.view_model.ExploreViewModel
import androidx.compose.runtime.livedata.observeAsState


class MainActivity : ComponentActivity() {
    lateinit var exploreViewModel: ExploreViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        exploreViewModel = ExploreViewModel(
            Application(),
            eventRepository = EventRepositoryImpl(ticketApiService =HttpClient.ticketService , apikey ="eq4X5AgfxXcj4R854Oa3cBK6SC0EEcsb",))
exploreViewModel.toastMessage.observe(this){

    println("HERE IS THE ERROR  $it")

    Toast.makeText(this,it,Toast.LENGTH_LONG).show()

}
        setContent {
            EventopiaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    ShowData(
                        viewModel = exploreViewModel,
                                modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

@Composable
fun ShowData(viewModel: ExploreViewModel, modifier: Modifier = Modifier) {
    val eventList by viewModel.eventList.observeAsState(emptyList())

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 14.dp, bottom = 14.dp)
    ) {
        items(eventList) { event ->
            Text(text = event.name)
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    EventopiaTheme {
//        Greeting("Android")
//    }
//}