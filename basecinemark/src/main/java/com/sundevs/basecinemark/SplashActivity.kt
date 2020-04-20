package com.sundevs.basecinemark

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.marcosholgado.core.resource.CmkCoreSettings
import dagger.android.support.DaggerAppCompatActivity
import java.util.*
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var cmkCoreSettings: CmkCoreSettings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val myLocale = Locale(
                cmkCoreSettings.getLocaleCmk().language,
                cmkCoreSettings.getLocaleCmk().country
            )

            val res = resources
            val conf = res.configuration

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                MyContextWrapper.setSystemLocale(conf, myLocale)
            } else {
                MyContextWrapper.setSystemLocaleLegacy(conf, myLocale)
            }

            conf.setLayoutDirection(myLocale);
            resources.updateConfiguration(conf, resources.getDisplayMetrics())
            startActivity(Intent(this, MainActivity::class.java))
        }, 1000)
    }
}
