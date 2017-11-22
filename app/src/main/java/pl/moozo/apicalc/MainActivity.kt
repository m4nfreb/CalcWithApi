package pl.moozo.apicalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pl.moozo.apicalc.data.model.PostSum
import pl.moozo.apicalc.data.remote.APIService
import pl.moozo.apicalc.data.remote.ApiUtils

class MainActivity : AppCompatActivity() {

    private var responseTv: TextView? = null
    private var apiService: APIService? = null
    private var sendBtn: Button? = null
    private var x: Long = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendBtn = findViewById(R.id.sendBtn) as Button
        responseTv = findViewById(R.id.result) as TextView

        apiService = ApiUtils.getAPIService()
        sendBtn!!.setOnClickListener { postSum(x, 7) }
    }

    private fun postSum(a: Long, b: Long) {
        apiService!!.sum(PostSum(a, b))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { __ -> sendBtn!!.isEnabled = false }
                .doFinally { sendBtn!!.isEnabled = true }
                .subscribe(
                        { s ->
                            showResponse(s)
                            Log.i("TAG", "post submitted to API. Response: " + s)
                            x++
                        }
                ) { e ->
                    val msg = "Unable to submit post to API. " + e.message
                    showResponse(msg)
                    Log.e("TAG", msg)
                }
    }

    private fun showResponse(response: String) {
        if (responseTv!!.visibility == View.GONE) {
            responseTv!!.visibility = View.VISIBLE
        }
        responseTv!!.text = response
    }
}
