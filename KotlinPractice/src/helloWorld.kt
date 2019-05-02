
    fun main(args : Array<String>) {
        var myName = "kevin"
        val doubles = 3.14
        println(doubles + .1)
        myName = "h"
        println("Hello World")
        println("My Name: $myName")
        println(summer(3,2))
        doNothing("billy")
        println(ifStatements(1,2))
        println(conciseIf(5,2))
    }

    fun summer ( a : Int, b : Int) = a +b

    fun doNothing(s : String) {
        println("I return Nothing, here is my String: $s")
    }
    fun staticAddTest(x : Int){
        var tempX = x;
        tempX++
    }

    fun ifStatements(a : Int, b : Int) : Boolean{
        if(a>b) {
            return true
        }
        return false
    }

    fun conciseIf(a : Int, b : Int) = if(a>b) a else b

    fun testNull(s : String){
        val x = Integer.parseInt(s)

        if(x==null){
            println("reet")
        }

    }
