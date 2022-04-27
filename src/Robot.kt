import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ISO_LOCAL_TIME
import java.time.format.FormatStyle
import java.util.*

class Robot(var name : String) {

    private var currentDate: LocalDate? = LocalDate.now()

    fun ringAlarm() : Boolean{
        var currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        return if(currentDate?.dayOfWeek != DayOfWeek.SUNDAY){
            if(currentHour > 6){

                //Extracting current time...
                var currentTimeNotFormat = Calendar.getInstance().time
                var format = SimpleDateFormat("HH:mm:ss")
                var currentTime = format.format(currentTimeNotFormat)

                println("Good Morning!! It's ${currentDate?.dayOfWeek}, the time is already ${currentTime}, please Wake up")
                true
            }else{
                println("Good Morning!! It's ${currentDate?.dayOfWeek}. Don't worry, take a nap :)")
                false
            }
        }else{
            println("It's Sunday!!.. What are your plans for today..")
            true
        }
    }

    fun makeCoffee(){

        println("COFFEE TIME!!")
        //Type of Coffee
        println("It's ${currentDate?.dayOfWeek}! What will you like to have?")
        println("Which type of coffee would you like? Black or with Milk?")
        var input = readLine()
        while(true){
            if(input.equals("Black", true) || input.equals("With Milk", true)) {
                break
            }else{
                println("Uh oh.. Don't know the ingredients for this coffee.. :)")
                input = readLine()
            }
        }

        //Amount of sugar
        println("Now, how many spoons of sugar?")
        var checkSugar = false
        while(true) {
            try {
                var inputSugar = readLine()?.toInt()
                while(true){
                    if (inputSugar != null) {
                        if(inputSugar > 3){
                            println("THIS MUCH SUGAR??")
                            var check = readLine()
                            if(check.equals("yes", true)){
                                println("Great !! Your coffee (${input}) with $inputSugar spoons of sugar is ready !!")
                                checkSugar = true
                                break
                            }else if(check.equals("no", true)){
                                println("Now, How many spoons of sugar?")
                                break
                            }else{
                                println("Kindly enter yes or no")
                            }
                        }else{
                            println("Great !! Your coffee (${input}) with $inputSugar spoons of sugar is ready !!")
                            checkSugar = true
                            break
                        }
                    }
                }
                if(checkSugar){
                    break
                }
            } catch (e1: Exception) {
                println("Really? Kindly tell me the number of spoons bro!")
            }
        }
    }

    fun heatWater(){
        println("BATH TIME!!")
        println("Temp of Water in Celsius ??")
        try{
            var waterSuitable = false
            while(true){
                var temp = readLine()?.toDouble()
                if (temp != null) {
                    if(temp > 40) {
                        println("You sure about this ?")

                        while (true) {
                            var check = readLine()
                            if (check.equals("yes", true)) {
                                println("Got it!..The water will be ready within 5 minutes :)")
                                waterSuitable = true
                                break
                            } else if (check.equals("no", true)) {
                                println("Knew it..")
                                break
                            } else {
                                println("Kindly enter yes or no")
                            }
                        }
                    }else{
                        println("Got it!..The water will be ready within 5 minutes :)")
                        waterSuitable = true
                        break
                    }
                    if(waterSuitable){
                        break
                    }
                }
            }
        }
        catch(e1 : Exception){
            println("Please provide a defined value!")
        }
    }

    fun packBag(){
        println("PACK YOUR BAG")
        when(currentDate?.dayOfWeek){
            DayOfWeek.MONDAY ->{
                var list = mutableListOf<String>("CS, Maths, Physics, Chemistry")
                println(message = "Today's schedule include $list")
            }
            DayOfWeek.TUESDAY ->{
                var list = mutableListOf<String>("CS, Maths, Electrical, Chemistry")
                println(message = "Today's schedule include $list")
            }
            DayOfWeek.WEDNESDAY ->{
                var list = mutableListOf<String>("CS, Maths, Electrical, Mechanical")
                println(message = "Today's schedule include $list")
            }
            DayOfWeek.THURSDAY ->{
                var list = mutableListOf<String>("CS, Android Dev, Physics, Chemistry")
                println(message = "Today's schedule include $list")
            }
            DayOfWeek.FRIDAY ->{
                var list = mutableListOf<String>("Android Dev, Mechanical, Electrical, Chemistry")
                println(message = "Today's schedule include $list")
            }
            DayOfWeek.SATURDAY ->{
                var list = mutableListOf<String>("CS, Android Dev, Technical Talk")
                println(message = "Today's schedule include $list")
            }
            else ->{
                println("It's ${currentDate?.dayOfWeek}, wanna pack some sandwiches and get going for a ride? :)")
            }
        }
    }

    fun cook(){
        println("COOKING TIME!!")
        val breakfastList = listOf<String>("Oats", "Fruits", "High-Fibre Cereals", "Whole wheat toast")
        val lunchList = listOf<String>("White Cheddar Grilled cheese", "Garlic Lentil Bowl", "Sweet Potato Panatella", "Tofu Chow Mein")

        println("Breakfast is packed! Guess what?? It's your favourite ${breakfastList.random()}")
        println("Breakfast is packed! Guess what?? It's your favourite ${lunchList.random()}")
    }

    fun ironClothes(){
        println("What would you like to wear today")
        var clothes = readLine()
        println("Don't worry, till you bath, I will keep your clothes ready :)")
    }

}

fun main(){
    val jarvis = Robot("Jarvis")

    var wakeOrNot = jarvis.ringAlarm()
    if(!wakeOrNot){
        return;
    }
    println("\n")
    jarvis.makeCoffee()

    println("\n")
    jarvis.ironClothes()

    println("\n")
    jarvis.heatWater()

    println("\n")
    jarvis.packBag()

    println("\n")
    jarvis.cook()

    println("\n")
    println("Your clothes are ready!!..Best of Luck and have a nice day :)")

}

