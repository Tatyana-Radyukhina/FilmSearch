package com.example.filmsearch

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.ActionMode
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.Nullable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.subscribe.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            Toast.makeText(this,"Меню", Toast.LENGTH_SHORT).show()
        }

        button2.setOnClickListener{
            Toast.makeText(this,"Избранное", Toast.LENGTH_SHORT).show()
        }

        button3.setOnClickListener{
            Toast.makeText(this,"Посмотреть позже", Toast.LENGTH_SHORT).show()
        }

        button4.setOnClickListener{
            Toast.makeText(this,"Подборки", Toast.LENGTH_SHORT).show()
        }

        button5.setOnClickListener{
            Toast.makeText(this,"Настройки", Toast.LENGTH_SHORT).show()
        }

        bottom_navigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.watch_later -> {
                    Toast.makeText(this, "Посмотреть позже", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.selections -> {
                    Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }


    }
}

class SubscribeView(context: Context, @Nullable attributeSet: AttributeSet): LinearLayout(context, attributeSet){
    private val editText: EditText
    private val subscribeButton: Button

    init{
        LayoutInflater.from(context).inflate(R.layout.subscribe, this)
        this.orientation = VERTICAL
        editText = et_subscribe
        subscribeButton = btn_subscribe
        subscribeButton.setOnClickListener {
            Toast.makeText(context, editText.text, Toast.LENGTH_SHORT).show()
        }
    }
}



