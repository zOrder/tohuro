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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.composable.THButton
import ui.composable.ThCheckBox
import ui.composable.ThOutlinedButton
import ui.composable.TheChip
import ui.theme.Theme
import ui.theme.TohuruTheme

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class)
@Composable
fun App() {
    TohuruTheme {
        var greetingText by remember { mutableStateOf("Hello, World!") }
        var showImage by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Theme.colors.background)
        ){
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = {
                    greetingText = "Hello, ${getPlatformName()}"
                    showImage = !showImage
                }) {
                    Text(greetingText)
                }

                THButton(
                    title = "Button Button ",
                    enabled = true,
                    onClick = { },
                    modifier = Modifier.fillMaxWidth().padding(top = 32.dp )
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
        }
    }
}

expect fun getPlatformName(): String