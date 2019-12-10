package com.example.callobsever

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //declare module level variable
    private lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","onCreated")

        //Initialise view model
        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)

        //add an observer to counter
        //it = counterViewMode.getCounter
        counterViewModel.getCounter.observe(

            this,
            Observer{
                if(it.equals(4)) goodLuck()
            }
        )

        textViewCounter.text=counterViewModel.getCounter.value.toString()

        buttonPlus.setOnClickListener {
            counterViewModel.increment()
            textViewCounter.text = counterViewModel.getCounter.value.toString()
        }
        buttonMinus.setOnClickListener {
            counterViewModel.decrement()
            textViewCounter.text= counterViewModel.getCounter.value.toString()
        }
    }

    private fun goodLuck(){
        Toast.makeText(applicationContext,"GoodLuck!",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        Log.d("MainActivity","onDestroy")
        super.onDestroy()
    }
}
