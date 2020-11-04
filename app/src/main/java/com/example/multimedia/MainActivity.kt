package com.example.multimedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_1.setOnClickListener {
            if(bt_1.text.equals(getString(R.string.comenzar))){
                bt_1.text = getString(R.string.fin)
                et_1.visibility = View.VISIBLE
            }else{
                et_1.onEditorAction(EditorInfo.IME_ACTION_DONE)
                jokerBatman()
            }
        }

    }
    protected fun jokerBatman(){
        iv_1.visibility = View.VISIBLE
        if(et_1.text.toString().toLowerCase().equals("joker")){
            iv_1.setImageResource(R.mipmap.ic_jokern);
        }else if(et_1.text.toString().toLowerCase().equals("batman")){
            iv_1.setImageResource(R.mipmap.ic_batman);
        }else{

        }
    }
}