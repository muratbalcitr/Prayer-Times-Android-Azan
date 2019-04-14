package com.eltaher.azan.sample

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.azan.Azan
import com.azan.Method
import com.azan.astrologicalCalc.Location
import com.azan.astrologicalCalc.SimpleDate
import com.azan.astrologicalCalc.SimpleTime
import sample.azan.eltaher.com.azan.R
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        azan()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    fun azan() {
        //Azan azan = new Azan(new Location(24.4833, 54.35, 4, 0 ), m);
        //azan.setCalendar(Calendar.getInstance());
        /* Call the main function to fill the Time times array of
         * structures */

        val qibla: SimpleTime
        val today = SimpleDate(GregorianCalendar())
        val location = Location(30.045411, 31.236735, 2.0, 0)
        val azan = Azan(location, Method.EGYPT_SURVEY)
        val prayerTimes = azan.getPrayerTimes(today)

        /* Call functions for other prayer times and qibla */
        val imsaak = azan.getImsaak(today)
        val nextFajr = azan.getNextDayFajr(today)
        val nextImsaak = azan.getNextDayImsaak(today)
        qibla = azan.northQibla
        print("\nQibla\t=$qibla\n")
        print(prayerTimes)
        println("Today's Imsaak: $imsaak")
        println("Tomorrow's Fajr: $nextFajr")
        println("Tomorrow's Imsaak: $nextImsaak")
        //System.out.println(Utils.PI + "\n");
        //System.out.println(Math.PI + "\n");

        println("---> ----------------------------------------")
        println("date ---> " + today.day + " / " + today.month + " / " + today.year)
        println("Fajr ---> " + prayerTimes.fajr())
        println("sunrise --->" + prayerTimes.shuruq())
        println("Zuhr --->" + prayerTimes.thuhr())
        println("Asr --->" + prayerTimes.assr())
        println("Maghrib --->" + prayerTimes.maghrib())
        println("ISHA  --->" + prayerTimes.ishaa())
        println("---> ----------------------------------------")

    }
}
