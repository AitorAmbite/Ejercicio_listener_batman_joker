package com.example.multimedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ImageView
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_1.setOnClickListener {
            if(bt_1.text.equals(getString(R.string.comenzar))){
                bt_1.text = getString(R.string.fin)
                et_1.visibility = View.VISIBLE
            }else{
                var llamada = jokerBatman()
                et_1.onEditorAction(EditorInfo.IME_ACTION_DONE)
                et_1.clearFocus()
                if(!llamada){
                    et_1.visibility = View.INVISIBLE
                    bt_1.text = getString(R.string.comenzar)
                }
            }
        }

        et_1.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus){
                et_1.setText("")
            }else{
                et_1.setText("Introduce tu nombre")
            }
        }
    }

    private fun jokerBatman():Boolean{
        iv_1.visibility = View.VISIBLE
        var fail = false
        if(et_1.text.toString().toLowerCase().equals("joker")){
            iv_1.setImageResource(R.mipmap.ic_jokern)
            cl_1.setBackgroundColor(getColor(R.color.colorPrimary))
            theme.applyStyle(R.style.customTheme,true)

        }else if(et_1.text.toString().toLowerCase().equals("wayne")){
            iv_1.setImageResource(R.mipmap.ic_batman);

        }else{
            iv_1.setImageResource(R.mipmap.ic_what);
            et_1.setText("Introduce tu nombre")
            fail = true
        }

        return fail
    }
}