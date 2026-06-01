package com.example.multitoolapp.brain

object AiBrain {
    // TODO: Replace with a real on-device model (e.g., TFLite Gemma)
    fun generateDetail(topic: String): String {
        // Placeholder logic – in future, call TFLite model
        return when {
            topic.contains("exercise") -> "Do 20 minutes of cardio, stay hydrated."
            topic.contains("read") -> "Read 10 pages of a non-fiction book."
            topic.contains("prayer") -> "Perform Salah on time and reflect."
            else -> "Stay consistent and track your progress daily."
        }
    }

    fun getMotivationalQuote(): String {
        val quotes = listOf(
            "Great job! Keep pushing!",
            "You’re building unstoppable momentum!",
            "Small steps lead to big changes.",
            "Success is the sum of small efforts repeated daily."
        )
        return quotes.random()
    }

    fun getChatbotResponse(input: String): String {
        // Simple rule-based for offline demo
        return when {
            input.contains("hello", ignoreCase = true) -> "Hello! How can I help you?"
            input.contains("how are you", ignoreCase = true) -> "I'm a bot, always fine!"
            input.contains("motivation") -> getMotivationalQuote()
            else -> "I'm learning. Try asking about habits or motivation."
        }
    }
}
