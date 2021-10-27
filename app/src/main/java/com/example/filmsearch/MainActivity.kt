package com.example.filmsearch

import android.animation.*
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.subscribe.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        button6.setOnClickListener {
            val view = ImageView(this)
            a1.addView(imageView6)
        }

        a1.layoutTransition.setAnimator(LayoutTransition.APPEARING, AnimatorInflater.loadAnimator(this, R.animator.animator_file))
        a1.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)


        button6.setOnClickListener {
            if(a1.childCount != 0) {
                a1.removeViewAt(a1.childCount - 1)
            }
        }









        val anim = ObjectAnimator.ofFloat(imageView1, View.ALPHA, 0F, 1F)
        anim.duration = 500

        val anim1 = ObjectAnimator.ofFloat(imageView2, View.ALPHA, 0F, 1F)
        anim.duration = 500

        val anim2 = ObjectAnimator.ofFloat(imageView3, View.ALPHA, 0F, 1F)
        anim.duration = 500

        val anim3 = ObjectAnimator.ofFloat(imageView4, View.ALPHA, 0F, 1F)
        anim.duration = 500

        val animator = AnimatorSet()
        animator.play(anim3).after(anim)
        animator.start()

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

        button.setOnClickListener{

            val anim = ObjectAnimator.ofFloat(imageView1, View.ALPHA, 0F, 1F)
            anim.duration = 500
            anim.start()

            val animationUpdateListener = object: Animator.AnimatorListener {
                override fun onAnimationRepeat(p0: Animator?) {
                    Toast.makeText(this@MainActivity, "Animation repeat", Toast.LENGTH_SHORT).show()
                }

                override fun onAnimationEnd(p0: Animator?) {
                    Toast.makeText(this@MainActivity, "Animation End", Toast.LENGTH_SHORT).show()
                }

                override fun onAnimationCancel(p0: Animator?) {
                    Toast.makeText(this@MainActivity, "Animation cancel", Toast.LENGTH_SHORT).show()
                }

                override fun onAnimationStart(p0: Animator?) {
                    Toast.makeText(this@MainActivity, "Animation start", Toast.LENGTH_SHORT).show()
                    println("start")
                }
            }

            button.setOnClickListener {
                val anim = ObjectAnimator.ofFloat(button, View.TRANSLATION_Y, 0F, -1000F)
                anim.duration = 1000
                anim.addListener(animationUpdateListener)
                anim.start()
            }
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







