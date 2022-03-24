import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()

	var body: some View {
        NavigationView {
            VStack {
                NavigationLink(destination: JobDetailsView()) {
                    VStack {
                        Text(greet)
                        Text("show job details")
                    }
                }
            }
        }
	}
}
