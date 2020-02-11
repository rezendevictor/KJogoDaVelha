package com.example.kjogodavelha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import java.text.FieldPosition
import kotlin.collections.Collection as Collection1

class MainActivity : AppCompatActivity() {

    val playerOne = ArrayList<Int>()
    val playerTwo = ArrayList<Int>()
    var currentPlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






    }

    fun play(position: Int,btnSelected: ImageButton){

        if(currentPlayer == 1){
            btnSelected.setBackgroundResource(R.drawable.player1icon)
            playerOne.add(position)
            currentPlayer = 2

        }else{
            btnSelected.setBackgroundResource(R.drawable.player2icon)
            playerTwo.add(position)
            currentPlayer = 1
        }

        btnSelected.isClickable = false
        checkResult()

    }


    fun btnPosition(view: View) {
        return when(view.id){

            R.id.btn1 ->play(1, view as ImageButton)
            R.id.btn2 ->play(2, view as ImageButton)
            R.id.btn3 ->play(3, view as ImageButton)
            R.id.btn4 ->play(4, view as ImageButton)
            R.id.btn5 ->play(5, view as ImageButton)
            R.id.btn6 ->play(6, view as ImageButton)
            R.id.btn7 ->play(7, view as ImageButton)
            R.id.btn8 ->play(8, view as ImageButton)
            R.id.btn9 ->play(9, view as ImageButton)


            else -> play(0,view as ImageButton)
        }
    }

    fun checkResult(){
        val row1 = listOf<Int>(1,2,3)
        val row2 = listOf<Int>(4,5,6)
        val row3 = listOf<Int>(7,8,9)




        val col1 = listOf<Int>(1,4,7)
        val col2 = listOf<Int>(2,5,8)
        val col3 = listOf<Int>(3,6,9)


        val diag1 = listOf<Int>(1,5,9)
        val diag2 = listOf<Int>(3,5,7)

        val valores = listOf<List<Int>>(row1,row2,row3,col1,col2,col3,diag1,diag2)

        var winner = -1

        for (x in valores){
            if(playerOne.containsAll(x)){
                winner = 1
            }else if(playerTwo.containsAll(x)){
                winner = 2
            }

        }

        when(winner){
            1 -> Toast.makeText(this,"Parabens, Jogador 1 Venceu!",Toast.LENGTH_LONG).show()
            2 -> Toast.makeText(this,"Parabens, Jogador 2 Venceu!",Toast.LENGTH_LONG).show()
        }



    }

    fun restart(view: View){
        playerOne.clear()
        playerTwo.clear()
        setContentView(R.layout.activity_main)

    }
}
