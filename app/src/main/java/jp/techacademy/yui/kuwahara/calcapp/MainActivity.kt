package jp.techacademy.yui.kuwahara.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View//クリックリスナーを使うため
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent//intentを使うため
import android.widget.Button
import android.widget.EditText
import android.util.Log
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(),View.OnClickListener{
    var num1: Float = 0.0f
    var num2: Float = 0.0f
    var flag: Int = 0
    var num: Float = 0.0f
    //val rootLayout: View = findViewById(android.R.id.content)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rootLayout: View = findViewById(android.R.id.content)

        //if(editText1.text.toString().isEmpty() == false && editText2.text.toString().isEmpty() == false) {
            button1.setOnClickListener(this)
            button2.setOnClickListener(this)
            button3.setOnClickListener(this)
            button4.setOnClickListener(this)
        //}/*else{
            //val snackbar = Snackbar.make(rootLayout, "数値を入力してください", Snackbar.LENGTH_INDEFINITE)
               // .setAction("exit"){}.show()
        //}*/
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, SecondActivity::class.java)

        if(v == button1){
            flag = 1
        }else if(v == button2){
            flag = 2
        }else if(v == button3){
            flag = 3
        }else if(v == button4) {
            flag = 4
        }

        if(editText1.text.isNullOrEmpty() || editText2.text.isNullOrEmpty()) {
            if (v != null) {
                val snackbar = Snackbar.make(v, "数値を入力してください", Snackbar.LENGTH_INDEFINITE)
                    .setAction("exit") {}.show()
            }
        }
        else {
            Calculation(flag)
            intent.putExtra("num", num)
            startActivity(intent)
        }
    }

    fun Calculation(flag: Int): Float{
        num1 = editText1.text.toString().toFloat()
        num2 = editText2.text.toString().toFloat()

        Log.d("kotlintest", "計算")

        if(flag == 1){
            num = num1 + num2
        }else if(flag == 2){
            num = num1 - num2
        }else if(flag == 3){
            num = num1 * num2
        }else if(flag == 4){
            num = num1 / num2
        }

        return num
    }
}