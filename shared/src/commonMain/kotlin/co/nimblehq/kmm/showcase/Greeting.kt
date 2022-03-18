package co.nimblehq.kmm.showcase

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}