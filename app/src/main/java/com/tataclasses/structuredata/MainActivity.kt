package com.tataclasses.structuredata

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject
import android.view.ViewGroup.LayoutParams as LayoutParams1


class MainActivity : AppCompatActivity() {
    var orientationDta: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val card = CardViewObj(
//            24f,
//            24f,
//            24f,
//            0xFF000000.toInt(),
//            0xff2ecc71.toInt(),
//            0xff2ecc71.toInt(),
//            0xffffffff.toInt(),
//            30f,
//            0xffffffff.toInt()
//        )

        getUsers()
//            getCardView(card)

//        getCardView2(card)
//        getCardView3(card)

//        Log.i("radius", "onCreate: data" + card.radius)
//        Log.i("textsize", "onCreate: data" + card.quoteTextSize)

    }


//    private fun getCardView(cardObj: CardViewObj): CardView {
//        val cardView = CardView(this)
//        cardView.radius = cardObj.radius
//        cardView.setCardBackgroundColor(cardObj.firstcardColor)
//        cardView.setContentPadding(36, 36, 36, 36)
//        val linLayout = LinearLayout(this)
//        // specifying vertical orientation
//        // specifying vertical orientation
//        linLayout.orientation = LinearLayout.VERTICAL
//        // creating LayoutParams
//        // creating LayoutParams
//
//
//        val params = LinearLayout.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.WRAP_CONTENT
//
//        )
//        params.weight = 1.0f
//        params.setMargins(16, 16, 16, 16)
//        cardView.layoutParams = params
//        cardView.cardElevation = cardObj.cardElevation
//        var quote = TextView(this)
//        quote.text =
//            "\"Our greatest weakness lies in giving up. \n"
//        quote.textSize = cardObj.quoteTextSize
//        quote.setTextColor(cardObj.quoteTextColor)
//        quote.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD)
//        val name = TextView(this)
//        name.text = "Vipin Shrivatri"
//        name.textSize = cardObj.nameTextSize
//        name.setTypeface(Typeface.MONOSPACE, Typeface.NORMAL)
//        name.setTextColor(cardObj.nameTextColor)
//
//        val mainLinearLayout = findViewById<LinearLayout>(R.id.constraintLayout)
//        val cardLinearLayout = LinearLayout(this)
//        cardLinearLayout.orientation = LinearLayout.VERTICAL
//        cardLinearLayout.addView(quote)
//        cardLinearLayout.addView(name)
//        cardView.addView(cardLinearLayout)
//        mainLinearLayout.addView(cardView)
//
//        return cardView
//    }

    @SuppressLint("WrongConstant")
    fun getUsers() {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url: String = "https://5e54f9f86f7b0.htmlsave.com/"

        // Request a string response from the provided URL.
        val stringReq = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->

                var strResp = response.toString()
//                    Toast.makeText(this,strResp,Toast.LENGTH_SHORT).show()
                val jsonObj: JSONObject = JSONObject(strResp)
                val viewArr: JSONArray = jsonObj.getJSONArray("views")

                for (view in 0 until viewArr.length()) {
                    var viewArrObj: JSONObject = viewArr.getJSONObject(view)
                    Log.i("jsonlengthview", "getUsers: " + viewArrObj.length())
                    Log.i("json", "getUsers: " + viewArrObj)
                    var jsonOrien = viewArrObj.getInt("orientation")

                    var layoutArr: JSONArray = viewArrObj.getJSONArray("layouts")
                    Log.i("layoutArr", "getUsers: " + layoutArr)
                    layoutArryFunction(layoutArr,jsonOrien)

//                    if(orientationflag==0){
//                    }
//                    else{
//                        Toast.makeText(this,"else part",Toast.LENGTH_SHORT).show()
//                    }
//                    layoutArryFunction(layoutArr)


//                    val cardLinearLayout = LinearLayout(this)
//
//                    cardLinearLayout.orientation = LinearLayout.VERTICAL
//                    cardLinearLayout.addView(quote)
//                    cardLinearLayout.addView(name)
//                    cardView.addView(cardLinearLayout)
//                    verticalLayout.addView(cardView)


                    //creating our adapter
                }
            },
            Response.ErrorListener { error: VolleyError? ->
                Toast.makeText(
                    this,
                    error.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            })
        queue.add(stringReq)
    }

    private fun layoutArryFunction(layoutArr: JSONArray,i:Int) {
        loop@ for (j in 0 until layoutArr.length()) {
            Log.i("debugforlayoutArr", "getUsers: " + layoutArr)
            var jsonLayoutData: JSONObject = layoutArr.getJSONObject(j)

            Log.i("jsonlength", "getUsers: " + jsonLayoutData.length())
            var model = CardViewObj(
//                jsonLayoutData.getString("radius").toFloat(),
//                jsonLayoutData.getString("marginL").toInt(),
//                jsonLayoutData.getString("marginT").toInt(),
//                jsonLayoutData.getString("marginR").toInt(),
//                jsonLayoutData.getString("marginB").toInt(),
//                jsonLayoutData.getString("contentPaddingL").toInt(),
//                jsonLayoutData.getString("contentPaddingT").toInt(),
//                jsonLayoutData.getString("contentPaddingR").toInt(),
//                jsonLayoutData.getString("contentPaddingB").toInt(),
                jsonLayoutData.getString("nameText"),
                jsonLayoutData.getString("quoteText"),
//                jsonLayoutData.getString("quoteTextSize").toFloat(),
//                jsonLayoutData.getString("nameTextSize").toFloat(),
                jsonLayoutData.getString("firstcardColor")
//                jsonLayoutData.getString("nameTextColor"),
//                jsonLayoutData.getString("cardElevation").toFloat(),
//                jsonLayoutData.getString("quoteTextColor")
            )
            Log.i("modeldata", "getUsers: " + model)

            var cardView = CardView(this)
//            cardView.radius = model.radius
            cardView.setCardBackgroundColor(Color.parseColor(model.firstcardColor))
//            cardView.setContentPadding(
//                model.contentPaddingL,
//                model.contentPaddingT,
//                model.contentPaddingR,
//                model.contentPaddingB
//            )


            val params = LinearLayout.LayoutParams(
                LayoutParams1.MATCH_PARENT,
                LayoutParams1.WRAP_CONTENT, 10f

            )

//            params.setMargins(
//                model.marginL,
//                model.marginT,
//                model.marginR,
//                model.marginB
//            )
            cardView.layoutParams = params


//            var horizontalLayoutView=LinearLayout(this)
//            val horizontalParams = LinearLayout.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT, 10f
//
//            )
//            horizontalLayoutView.layoutParams = horizontalParams
//            horizontalLayoutView.orientation=LinearLayout.HORIZONTAL

//            cardView.cardElevation = model.cardElevation
            var quote = TextView(this)
            quote.text = model.quoteText
//            quote.textSize = model.quoteTextSize
//            quote.setTextColor(Color.parseColor(model.quoteTextColor))
            quote.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD)
            val name = TextView(this)
            name.text = model.nameText
//            name.textSize = model.nameTextSize
            name.setTypeface(Typeface.MONOSPACE, Typeface.NORMAL)
//            name.setTextColor(Color.parseColor(model.nameTextColor))
//            var horizontalLayout = findViewById<LinearLayout>(R.id.horizontalLinear)
//            var  HorizontalLayot = findViewById<LinearLayout>(R.id.horizontalLinear)
//            var verticalLayout = findViewById<LinearLayout>(R.id.verticalLinear)
            val mainLayout=findViewById<RelativeLayout>(R.id.mainLayout)



//            horizontalLayout.addView(cardView)
//            verticalLayout.addView(cardView)

//                            when (orientationflag) {
//                                0 -> {
//                                    Log.i("js", "getUsers: "+orientationflag)
//                                    horizontalLayout.addView(cardView)
//                                }
//                                1 -> {
//                                    Log.v("else", "getUsers: "+orientationflag)
//                                    verticalLayout.addView(cardView)
//                                }
//                            }
//            CverticalLayout.addView(cardView)
//                        if (orientationflag==0){}
            when (i) {
                0 -> {
//                                    Log.i("js", "getUsers: "+orientationflag)
                    val cardLinearLayout = LinearLayout(this)
                    val Hlinear=LinearLayout(this)


                    cardLinearLayout.orientation = LinearLayout.VERTICAL

                    Hlinear.orientation=LinearLayout.HORIZONTAL
                    Hlinear.weightSum=5f
                    Hlinear.layoutParams= LinearLayout.LayoutParams(
                        LayoutParams1.MATCH_PARENT,
                        LayoutParams1.WRAP_CONTENT
                    )

                    cardLinearLayout.addView(quote)
                    cardLinearLayout.addView(name)
                    cardView.addView(cardLinearLayout)
                    Hlinear.addView(cardView)

//                    mainLayout.orientation=LinearLayout.HORIZONTAL

                    mainLayout.addView(Hlinear)
//                    horizontalLayoutView.addView(Hlinear)






//                    mainLayout.addView(Hlinear)
                }
                1 -> {
//                                    Log.v("else", "getUsers: "+orientationflag)

//                                    verticalLayout.addView(cardView)
                    val cardLinearLayout = LinearLayout(this)
                    val Vlinear=LinearLayout(this)
                    Vlinear.orientation=LinearLayout.HORIZONTAL
                    Vlinear.weightSum=5f
//                    horizontalLayout.addView(Vlinear)
                    cardLinearLayout.orientation = LinearLayout.VERTICAL
                    cardLinearLayout.weightSum = 5f
                    cardLinearLayout.addView(quote)
                    cardLinearLayout.addView(name)
                    cardView.addView(cardLinearLayout)
                    mainLayout.addView(cardView)
                    break@loop
//                    verticalLayout.addView(cardView)
                }


            }
        }
    }


}