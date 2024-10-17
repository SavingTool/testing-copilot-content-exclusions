// Example.scala

import scala.concurrent.{Future, ExecutionContext}
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

// Basic math functions
object MathOperations {
  def add(a: Int, b: Int): Int = a + b
  def subtract(a: Int, b: Int): Int = a - b
  def multiply(a: Int, b: Int): Int = a * b
  def divide(a: Int, b: Int): Either[String, Int] = {
    if (b == 0) Left("Division by zero is not allowed")
    else Right(a / b)
  }
}

// Person class
class Person(val firstName: String, val lastName: String, val age: Int) {
  def getFullName: String = s"$firstName $lastName"
  def isAdult: Boolean = age >= 18
}

// Async operation with Future
object AsyncOperations {
  def fetchData(url: String): Future[String] = {
    // Simulating an asynchronous data fetch using Future
    Future {
      Thread.sleep(1000) // Simulate network delay
      if (url == "https://valid-url.com") "Data from valid URL"
      else throw new RuntimeException("Invalid URL")
    }
  }
}

// Main object to test the functionalities
object Example extends App {

  // Testing math operations
  println(s"Add: ${MathOperations.add(5, 3)}")
  println(s"Subtract: ${MathOperations.subtract(10, 4)}")
  println(s"Multiply: ${MathOperations.multiply(6, 7)}")
  MathOperations.divide(10, 0) match {
    case Right(result) => println(s"Divide: $result")
    case Left(error) => println(s"Error: $error")
  }

  // Testing the Person class
  val person = new Person("Jane", "Doe", 22)
  println(s"Full Name: ${person.getFullName}")
  println(s"Is Adult: ${person.isAdult}")

  // Testing async operation
  val url = "https://valid-url.com"
  val futureData = AsyncOperations.fetchData(url)

  futureData.onComplete {
    case Success(data) => println(s"Data fetched: $data")
    case Failure(exception) => println(s"Error fetching data: ${exception.getMessage}")
  }

  // Ensuring the main thread doesn't exit before async operation finishes
  Thread.sleep(2000)
}
