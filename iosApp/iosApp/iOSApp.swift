import SwiftUI
import Firebase
import shared

@main
struct iOSApp: App {
    
    init(){
       FirebaseApp.configure()
       SharedModuleKt.doInitKoin()
     }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
