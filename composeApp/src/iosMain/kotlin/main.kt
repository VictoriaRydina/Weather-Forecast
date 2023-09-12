import androidx.compose.ui.window.ComposeUIViewController
import com.grishchenkova.app.App
import com.grishchenkova.app.di.appModule
import org.koin.core.context.startKoin
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {

    startKoin {
        modules(appModule)
    }

    return ComposeUIViewController {
        App()
    }
}
