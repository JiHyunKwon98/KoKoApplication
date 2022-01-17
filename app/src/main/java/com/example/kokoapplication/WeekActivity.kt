package com.example.kokoapplication
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import java.util.*
import android.widget.*


class WeekActivity : AppCompatActivity() {

/*  /* 주간 달력 부분  수정 예정 */
    private val lastDayInCalendar = Calendar.getInstance(Locale.ENGLISH)
    private val sdf = SimpleDateFormat("MMMM yyyy", Locale.ENGLISH)
    private val cal = Calendar.getInstance(Locale.ENGLISH)

    private val currentDate = Calendar.getInstance(Locale.ENGLISH)
    private val currentDay = currentDate[Calendar.DAY_OF_MONTH]
    private val currentMonth = currentDate[Calendar.MONTH]
    private val currentYear = currentDate[Calendar.YEAR]

    private var selectedDay: Int = currentDay
    private var selectedMonth: Int = currentMonth
    private var selectedYear: Int = currentYear

    private val dates = ArrayList<Date>()
*/

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week)

        /* 주간 달력 부분  수정 예정 */

/*        val snapHelper = LinearSnapHelper()

        val calendar_recycler_view : RecyclerView = findViewById(R.id.calendar_recycler_view)
        val calendar_prev_button : Button = findViewById(R.id.calendar_prev_button)
        val calendar_next_button : Button = findViewById(R.id.calendar_next_button)
        snapHelper.attachToRecyclerView(calendar_recycler_view)

        lastDayInCalendar.add(Calendar.MONTH, 6)

        setUpCalendar()

        calendar_prev_button!!.setOnClickListener {
            if (cal.after(currentDate)) {
                cal.add(Calendar.MONTH, -1)
                if (cal == currentDate)
                    setUpCalendar()
                else
                    setUpCalendar(changeMonth = cal)
            }
        }

        calendar_next_button!!.setOnClickListener {
            if (cal.before(lastDayInCalendar)) {
                cal.add(Calendar.MONTH, 1)
                setUpCalendar(changeMonth = cal)
            }
        }


        */

        val today : ImageView = findViewById(R.id.today)

        
        today.setOnClickListener{
            // Dialog만들기
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.today_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
            val  mAlertDialog = mBuilder.show()
            val noButton = mDialogView.findViewById<Button>(R.id.closeButton)
            noButton.setOnClickListener {
                mAlertDialog.dismiss()
            }

            val exercise1 = mDialogView.findViewById<CheckBox>(R.id.exercise1)
            val finish = mDialogView.findViewById<TextView>(R.id.finish)

            exercise1.setOnCheckedChangeListener{compoundButton, b ->
                if(b)
                    finish.text = "완료!"
                else
                    finish.text = " "
            }

        }

        val monthchange : ImageView = findViewById(R.id.monthchange)

        monthchange.setOnClickListener{
            val intent = Intent(this@WeekActivity, DatePickerActivity::class.java)
            startActivity(intent)
        }

        val input : ImageView = findViewById(R.id.input)
        input.setOnClickListener{
            val intent = Intent(this@WeekActivity, InputGoal::class.java)
            startActivity(intent)
        }

        val gograp : ImageView = findViewById(R.id.gograp)
        val golist : ImageView = findViewById(R.id.golist)
        val gohome : ImageView = findViewById(R.id.gohome)
        val gomy : ImageView = findViewById(R.id.gomy)


        gograp.setOnClickListener{
            val intent = Intent(this@WeekActivity, GraphActivity::class.java)
            startActivity(intent)
        }

        golist.setOnClickListener{
            val intent = Intent(this@WeekActivity, ManageActivity::class.java)
            startActivity(intent)
        }

        gohome.setOnClickListener{
            val intent = Intent(this@WeekActivity, WeekActivity::class.java)
            startActivity(intent)
        }


        gomy.setOnClickListener{
            val intent = Intent(this@WeekActivity, MyActivity::class.java)
            startActivity(intent)
        }

    }


   /* 주간 달력 부분  수정 예정*/
/*    private fun setUpCalendar(changeMonth: Calendar? = null) {
        val txt_current_month : TextView = findViewById(R.id.txt_current_month)
        val calendar_recycler_view : RecyclerView = findViewById(R.id.calendar_recycler_view)
        // first part
        txt_current_month!!.text = sdf.format(cal.time)
        val monthCalendar = cal.clone() as Calendar
        val maxDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)

        selectedDay =
            when {
                changeMonth != null -> changeMonth.getActualMinimum(Calendar.DAY_OF_MONTH)
                else -> currentDay
            }
        selectedMonth =
            when {
                changeMonth != null -> changeMonth[Calendar.MONTH]
                else -> currentMonth
            }
        selectedYear =
            when {
                changeMonth != null -> changeMonth[Calendar.YEAR]
                else -> currentYear
            }

        var currentPosition = 0
        dates.clear()
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1)

        while (dates.size < maxDaysInMonth) {
            if (monthCalendar[Calendar.DAY_OF_MONTH] == selectedDay)
                currentPosition = dates.size
            dates.add(monthCalendar.time)
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }
        // third part
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        calendar_recycler_view!!.layoutManager = layoutManager
        val calendarAdapter = CalendarAdapter(this, dates, currentDate, changeMonth)
        calendar_recycler_view!!.adapter = calendarAdapter

        when {
            currentPosition > 2 -> calendar_recycler_view!!.scrollToPosition(currentPosition - 3)
            maxDaysInMonth - currentPosition < 2 -> calendar_recycler_view!!.scrollToPosition(currentPosition)
            else -> calendar_recycler_view!!.scrollToPosition(currentPosition)
        }

        calendarAdapter.setOnItemClickListener(object : CalendarAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val clickCalendar = Calendar.getInstance()
                clickCalendar.time = dates[position]
                selectedDay = clickCalendar[Calendar.DAY_OF_MONTH]
            }
        })

    }*/

}

