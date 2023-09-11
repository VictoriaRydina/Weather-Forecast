import androidx.compose.ui.window.ComposeUIViewController
import com.grishchenkova.app.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    return ComposeUIViewController { App() }
}
