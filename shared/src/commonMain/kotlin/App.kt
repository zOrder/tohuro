import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
//import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.composable.THButton
import ui.composable.ThCheckBox
import ui.composable.ThOutlinedButton
import ui.composable.TheChip
import ui.composable.TheNavigationBar
import ui.composable.TheNavigationBarItem
import ui.theme.Theme
import ui.theme.TohuruTheme
import user.User

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class)
@Composable
fun App() {
    TohuruTheme {
        var greetingText by remember { mutableStateOf("Hello, World!") }
        var showImage by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Theme.colors.background),
            verticalArrangement = Arrangement.Bottom
        ){
            Column(Modifier.fillMaxWidth()) {
                var list by remember { mutableStateOf(listOf<User>()) }
                LaunchedEffect(Unit) {
                    list = getUsers()
                }
                LazyColumn {
                    items(list) {
                        UserItem(it)
                    }
                }
            }

            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                THButton(
                    title = greetingText,
                    enabled = true,
                    onClick = {
                        greetingText = "Hello, ${getPlatformName()}"
                        showImage = !showImage
                    },
                    modifier = Modifier.padding(top = 32.dp )
                )
                Spacer(modifier = Modifier.size(30.dp))
                ThOutlinedButton(
                    title = "Outline",
                    onClick = { },
                )
                Spacer(modifier = Modifier.size(30.dp))

                var checked by remember { mutableStateOf(false) }
                ThCheckBox(
                    label = "check",
                    isChecked = checked,
                    onCheck = { isChecked -> checked = isChecked  },
                )

                Spacer(modifier = Modifier.size(30.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    var selected by remember { mutableStateOf(false) }
                    var selected1 by remember { mutableStateOf(true) }
                    var selected2 by remember { mutableStateOf(true) }
                    TheChip(
                        label = "Click me",
                        onClick = { isSelected -> selected = isSelected },
                        isSelected = selected,
                        painter = Icons.Default.CheckCircle
                    )
                    TheChip(
                        label = "Click me",
                        onClick = { isSelected -> selected1 = isSelected },
                        isSelected = selected1,
                        painter = Icons.Default.ArrowForward
                    )
                    TheChip(
                        label = "Click me",
                        onClick = { isSelected -> selected2 = isSelected },
                        isSelected = selected2,
                        painter = Icons.Default.Star
                    )
                }

                AnimatedVisibility(showImage) {
                    Image(
                        painterResource("compose-multiplatform.xml"),
                        null
                    )
                }
            }

            BottomNavigationBarPreview()
        }
    }
}

expect fun getPlatformName(): String

@Composable
fun UserItem(user: User) {
    Column {
        Text(
            text = user.name
        )
        Text(
            text = user.age.toString()
        )
    }
}
suspend fun getUsers(): List<User> {
    val firebaseFirestore = Firebase.firestore
    try {
        val userResponse =
            firebaseFirestore.collection("USERS").get()
        return userResponse.documents.map {
            it.data()
        }
    } catch (e: Exception) {
        throw e
    }
}

@Composable
fun BottomNavigationBarPreview() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("one", "two", "three", "four")

    TheNavigationBar  {
        items.forEachIndexed { index, item ->
            TheNavigationBarItem(
                icon = { tint ->
                    Icon(Icons.Filled.Favorite, contentDescription = item, tint = tint)
                },
                label = { style ->
                    Text(item, style = style)
                },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}